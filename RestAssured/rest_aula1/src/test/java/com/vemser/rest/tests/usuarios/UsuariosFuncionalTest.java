package com.vemser.rest.tests.usuarios;

import com.vemser.rest.client.UsuarioClient;
import com.vemser.rest.data.factory.UsuarioDataFactory;
import com.vemser.rest.model.Usuario;
import io.restassured.http.ContentType;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.vemser.rest.tests.basic.pojo.pojo.UsuarioResponse;
import com.vemser.rest.tests.basic.pojo.pojo.UsuarioPojo;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

    private Faker faker = new Faker(new Locale("PT-BR"));
    private Random geradorBoolean = new Random();

    private UsuarioClient usuarioClient = new UsuarioClient();

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarUsuarioComSucesso() {
        UsuarioPojo usuario = novoUsuario();

        UsuarioResponse usuarioResponse =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(usuario)
                .when()
                        .post("/usuarios")
                .then()
                        .log().all()
                        .statusCode(201)
                        .extract().as(UsuarioResponse.class);

        Assertions.assertAll("usuarioResponse",
                () -> Assertions.assertEquals("Cadastro realizado com sucesso", usuarioResponse.getMessage()),
                () -> Assertions.assertNotNull(usuarioResponse.getId())
        );
    }

    @Test
    public void testCadastrarUsuarioComNomeEmBranco() {


        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.usuarioComNomeEmBranco())
        .when()
                .post("/usuarios")
        .then()
                .log().all()
                .statusCode(400)
                .body("nome", equalTo("nome não pode ficar em branco"))

        ;


    }


    @Test
    public void testCadastrarUsuarioComSucessoComClient() {


        Usuario usuario = UsuarioDataFactory.usuarioValido();

        usuarioClient.cadastrarUsuario(usuario)
        .then()
                .log().all()
                .statusCode(201)
        ;
    }

    /*@Test
    public void testCadastrarUsuarioComSucesso(){


        Usuario usuario = UsuarioDataFactory.usuarioValido();

        UsuarioResponse response =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(usuario)
        .when()
                .post("/usuarios")


        usuarioClient.cadastrarUsuario(usuario)
                .then()
                .log().all()
                .statusCode(201)
        ;
    }*/

    @Test
    public void testBuscarUsuariosComSucesso() {

        given()
                .log().all()
        .when()
                .get("/usuarios")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void testAtualizarUsuarioComSucesso() {

        UsuarioResponse usuarioAtualizar = cadastrarUsuario();
        UsuarioPojo usuarioAtualizado = novoUsuario();

        given()
                .log().all()
                .pathParams("_id", usuarioAtualizar.getId())
                .contentType(ContentType.JSON)
                .body(usuarioAtualizado)
        .when()
                .put("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"))
        ;

        excluirUsuario(usuarioAtualizar.getId());
    }

    @Test
    public void testDeletarUsuarioComSucesso() {
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

    private UsuarioResponse excluirUsuario(String isUsuario) {

        return
                given()
                        .pathParams("_id", isUsuario)
                .when()
                        .delete("usuarios/{_id}")
                .then()
                        .statusCode(200)
                        .extract().as(UsuarioResponse.class)
                ;
    }

    private UsuarioResponse cadastrarUsuario() {

        UsuarioPojo usuario = novoUsuario();

        return
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(usuario)
                .when()
                        .post("/usuarios")
                .then()
                        .log().all()
                        .statusCode(201)
                        .extract().as(UsuarioResponse.class)
                ;

    }

    private UsuarioPojo novoUsuario() {

        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        return usuario;
    }

}
