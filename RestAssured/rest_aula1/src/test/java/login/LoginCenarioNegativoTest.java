package login;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoginCenarioNegativoTest {
    @BeforeEach
    public void setUp(){
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testTentarRealizarLoginComEmailIncorreto(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(
                        """
                               {
                                  "email": "camilagoncalves3@qa.com.br",
                                  "password": "teste"
                                }
                                """
                )
        .when()
                .post("/login")
        .then()
                .log().all()
                .statusCode(401)
                .body("message", equalTo("Email e/ou senha inválidos"))
                ;
    }

}
