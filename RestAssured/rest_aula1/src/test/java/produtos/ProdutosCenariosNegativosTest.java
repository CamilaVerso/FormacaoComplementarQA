package produtos;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ProdutosCenariosNegativosTest {
    @BeforeEach
    public void setUp(){
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testTentarCadastrarProdutoComNomeJaExistente(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhbWlsYWdvbmNhbHZlc0BxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNzEyMjQ3OTM5LCJleHAiOjE3MTIyNDg1Mzl9.C3yO_YrlBy4dphh8jysY7iadET1n_Zo24ivRgxUdkAE";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(
                        """
                        {
                          "nome": "Impressora Matricial",
                          "preco": 470,
                          "descricao": "Mouse",
                          "quantidade": 381
                        }
                        """
                )
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(400)
                .body("message", equalTo("Já existe produto com esse nome"));

    }

@Test
    public void testBuscarProdutoComIdInvalido(){
        String idProduto = "09KYZUVSa4gZs6ay";

        given()
                .log().all()
                .pathParams("_id", idProduto)
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(400)
                .body("message", equalTo("Produto não encontrado"))
        ;
}

    @Test
    public void testAlterarNomeDoProdutoSemPassarTodosOsDados(){
        String idProduto = "SHt1cSljWPxOzwl1";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhbWlsYWdvbmNhbHZlc0BxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNzEyMjQ4NjIxLCJleHAiOjE3MTIyNDkyMjF9.1RM1yhrjSHZ1805s1xkNp34oUbz1C5i2G0VDQx8CFGI";


        given()
                .log().all()
                .pathParams("_id", idProduto)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(
                        """
                        {
                        "nome": "Videogame"
                        }
                        """
                )
                .when()
                .put("produtos/{_id}")
                .then()
                .log().all()
                .statusCode(400)
                .body("preco", equalTo("preco é obrigatório"))
                .body("descricao", equalTo("descricao é obrigatório"))
                .body("quantidade", equalTo("quantidade é obrigatório"))
        ;
    }

    @Test
    public void testDeletarProdutoComIdInexistente(){
        String idProduto = "BALZ6B6NykZgGMLp";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhbWlsYWdvbmNhbHZlc0BxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNzEyMjQ4NzA2LCJleHAiOjE3MTIyNDkzMDZ9.Y5E4JwUQ-82a3Rw4wTQmt4K_VGf03E2CKsDtZXbIheg";

        given()
                .log().all()
                .pathParams("_id", idProduto)
                .header("Authorization", "Bearer " + token)
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Nenhum registro excluído"))
        ;
    }
}
