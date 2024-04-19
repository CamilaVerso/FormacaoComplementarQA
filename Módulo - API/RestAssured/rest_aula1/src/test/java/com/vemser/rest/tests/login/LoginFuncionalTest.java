package com.vemser.rest.tests.login;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginFuncionalTest {
    @BeforeEach
    public void setUp(){
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testRealizarLoginComSucesso(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(
                        """
                                {
                                  "email": "camilagoncalves@qa.com.br",
                                  "password": "teste"
                                }
                                """
                )
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", notNullValue())
                ;
    }
}
