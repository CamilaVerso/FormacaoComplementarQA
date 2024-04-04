package usuarios;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class UsuariosCenariosNegativosTest {

    @BeforeEach
    public void setUp(){
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarUsuarioSemNome(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(
                        """
                        {
                          "nome": "",
                          "email": "camilapereira2@qa.com.br",
                           "password": "teste",
                          "administrador": "true"
                        }
                        """
                )
        .when()
                .post("/usuarios")
        .then()
                .log().all()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("nome", equalTo("nome não pode ficar em branco"))

        ;
    }

    @Test
    public void testBuscarUsuariosComIdInvalido(){
        String idUsuario = "0Od8yZ85LPVfOLM9";

        given()
                .log().all()
                .queryParam("_id", idUsuario)
        .when()
                .get("/usuarios")
        .then()
                .log().all()
                .statusCode(200)
                .body("quantidade", equalTo(0))
                .body("usuários", is(nullValue()))
        ;
    }

    @Test
    public void testAlterarNomeSemPassarTodosOsDados(){
        String idUsuario = "TALZ6B6NykZgGMLl";

        given()
                .log().all()
                .pathParams("_id", idUsuario)
                .contentType(ContentType.JSON)
                .body(
                        """
                        {
                        "nome": "Camila Pereira Gonçalves"
                        }
                        """
                )
       .when()
                .put("usuarios/{_id}")
       .then()
                .log().all()
                .statusCode(400)
                .body("email", equalTo("email é obrigatório"))
                .body("password", equalTo("password é obrigatório"))
                .body("administrador", equalTo("administrador é obrigatório"))
                ;
    }

    @Test
    public void testDeletarUsuarioComIdInexistente(){
        String idUsuario = "TALZ6B6NykZgGMLp";

        given()
                .log().all()
                .pathParams("_id", idUsuario)
        .when()
                .delete("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Nenhum registro excluído"))
        ;
    }
}
