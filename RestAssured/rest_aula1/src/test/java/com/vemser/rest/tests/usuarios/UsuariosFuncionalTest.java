package com.vemser.rest.tests.usuarios;

import io.restassured.http.ContentType;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Response;
import pojo.UsuarioPojo;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

    private Faker faker = new Faker(new Locale("PT-BR"));
    private Random geradorBoolean = new Random();

    @BeforeEach
    public void setUp(){
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarUsuarioComSucesso(){

        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));



        pojo.Response response =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/usuarios")
        .then()
                .log().all()
                .statusCode(201)
                .extract().as(Response.class)
                ;

        Assertions.assertEquals("Cadastro realizado com sucesso", response.getMessage());
        Assertions.assertNotNull(response.getId());
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
