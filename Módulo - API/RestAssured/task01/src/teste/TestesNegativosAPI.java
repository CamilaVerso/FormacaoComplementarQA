package teste;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestesNegativosAPI {

    @Test //POST  -- Para este teste passar novamente precisa de um novo token
    public void testPostProdutoComNomeJaCadastrado(){
       String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVtYWlsQHFhLmNvbS5iciIsInBhc3N3b3JkIjoidGVzdGUiLCJpYXQiOjE3MTIxNTMyMzksImV4cCI6MTcxMjE1MzgzOX0.5Lo-rO7Y64LeFuMhtFLoZBs9gKSqThyMrOckperqabQ";
        String requestBody = "{\"nome\": \"mouse 23\",\"preco\": 470, \"descricao\": \"Mouse\", \"quantidade\": 381 }";

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .when()
                .post("http://localhost:3000/produtos")
                .then()
                .statusCode(400)
                .body("message", equalTo("Já existe produto com esse nome"));

    }

    @Test //GET
    public void testBuscarProdutoComIdInvalido() {
        given()
                .pathParams("id", "09KYZUVSa4gZs6ay")
                .when()
                .get("http://localhost:3000/produtos/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo("Produto não encontrado"));

    }

    @Test //PUT -- Para este teste passar novamente precisa de um novo token
    public void testAtualizarProdutoParaUmNomeJaUtilizado(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVtYWlsQHFhLmNvbS5iciIsInBhc3N3b3JkIjoidGVzdGUiLCJpYXQiOjE3MTIxNTM2ODIsImV4cCI6MTcxMjE1NDI4Mn0.33EYSIRd83g6tkmCrKfS35WLUl7FhL9a8Zk9k8Blesk";
        String novoNome = "Notebook";
        String novaDescricao = "Hic magni in et aut. Repellendus perspiciatis adipisci rerum error rem natus laboriosam.";
        double novoPreco = 900.00;
        double novaQuantidade = 500;

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body("{ \"nome\": \"" + novoNome + "\", \"descricao\": \"" + novaDescricao + "\", \"preco\": " + novoPreco + ", \"quantidade\": " + novaQuantidade + " }")
                .when()
                .put("http://localhost:3000/produtos/{id}", "JwZvPFxLiqCcld1T")
                .then()
                .statusCode(400)
                .body("message", equalTo("Já existe produto com esse nome"));
    }

    @Test // Para este teste passar novamente se faz necessário alterar o token e o id
    public void testDeletarProdutoComIdInexistente(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVtYWlsQHFhLmNvbS5iciIsInBhc3N3b3JkIjoidGVzdGUiLCJpYXQiOjE3MTIxNTQwMTQsImV4cCI6MTcxMjE1NDYxNH0.Owra_FgAbwBuPl9IPQMd0SUtd5DwQhDKVeJpNbsmFLY";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .pathParams("id", "si6Ooc8JQUaKnLLP")
                .when()
                .delete("http://localhost:3000/produtos/{id}")
                .then()
                .extract()
                .response();

        response.then().statusCode(200);
        response.then().body("message", containsString("Nenhum registro excluído"));

    }
}
