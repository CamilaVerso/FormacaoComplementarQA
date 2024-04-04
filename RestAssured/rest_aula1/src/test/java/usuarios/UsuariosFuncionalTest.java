package usuarios;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

    @BeforeEach
    public void setUp(){
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarUsuarioComSucesso(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(
                         """
                         {
                           "nome": "Camila Pereira",
                           "email": "camilapereira@qa.com.br",
                            "password": "teste",
                           "administrador": "true"
                         }
                         """
                )
        .when()
                .post("/usuarios")
        .then()
                .log().all()
                .statusCode(201)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue())
                ;
    }

    @Test
    public void testBuscarUsuariosComSucesso(){

        given()
                .log().all()
        .when()
                .get("/usuarios")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void testAtualizarUsuarioComSucesso(){
        String idUsuario = "0Od8yZE5LPVfOLM9";

        given()
                .log().all()
                .pathParams("_id", idUsuario)
                .contentType(ContentType.JSON)
                .body("""
                         {
                              "nome": "Adam Costa da Silva",
                              "email": "Jarrod_Runolfsson@yahoo.com",
                              "password": "rrGoV9b_bL1umku",
                              "administrador": "true"
                             
                            }
                        """
                )
        .when()
                .put("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"))
        ;
    }

    @Test
    public void testDeletarUsuarioComSucesso(){
        String idUsuario = "eNyGWfbuZ571bOBh";

        given()
                .log().all()
                .pathParams("_id", idUsuario)
        .when()
                .delete("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"))
        ;

    }

}
