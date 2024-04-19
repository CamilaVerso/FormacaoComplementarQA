package com.vemser.rest.client;

import com.vemser.rest.model.Usuario;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsuarioClient {

    public UsuarioClient(){}

    public Response cadastrarUsuario(Usuario usuario){

        return
            given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(usuario)
            .when()
                    .post("/usuarios")
            ;

    }
}
