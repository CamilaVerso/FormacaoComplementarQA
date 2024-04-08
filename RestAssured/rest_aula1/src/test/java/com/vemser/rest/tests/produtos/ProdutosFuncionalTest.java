package com.vemser.rest.tests.produtos;

import com.vemser.rest.tests.basic.pojo.pojo.ProdutoPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.everyItem;


public class ProdutosFuncionalTest {


    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    private Autenticacao autenticacao = new Autenticacao();
    private Faker faker =new Faker();

    public class Autenticacao {
        public String getToken() {

            Response response =
            given()
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
                  .extract().response();

            //return response.jsonPath().getString("Authorization");

            String tokenWithBearer = response.jsonPath().getString("authorization");
            String[] parts = tokenWithBearer.split(" ");
            return parts[1];
        }

    }


    @Test
    public void testCadastrarProdutoComSucesso() {
       // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhbWlsYWdvbmNhbHZlc0BxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNzEyNjEzMjYwLCJleHAiOjE3MTI2MTM4NjB9.To-68ygJjQ3HXC__g4DAYtNovpqsWU-c5ocg6qLaluU";
    String token = autenticacao.getToken();

        ProdutoPojo produto = new ProdutoPojo();
        produto.setNome(faker.commerce().productName());
        produto.setPreco(faker.random().nextInt(10, 1000));
        produto.setDescricao(faker.lorem().sentence());
        produto.setQuantidade(faker.number().numberBetween(1, 1000));


        given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(produto)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(201)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue())
        ;
    }

    @Test
    public void testBuscarUmProdutoComSucesso() {

        given()
                .log().all()
        .when()
                .get("/produtos")
        .then()
                .log().all()
                .statusCode(200)
                .body("produtos", not(empty()))
                .body("produtos._id", everyItem(notNullValue()))
                .body("produtos.nome", everyItem(notNullValue()))
                .body("produtos.descricao", everyItem(notNullValue()))
                .body("produtos.quantidade", everyItem(notNullValue()));


    }

    @Test
    public void testEditarProdutoComSucesso() {
        String idProduto = "iWd9UbBYjFCi4K3q";
        // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhbWlsYWdvbmNhbHZlc0BxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNzEyMjQ3MTU5LCJleHAiOjE3MTIyNDc3NTl9.e6YmOBmkF7c2fcu1PaIQ-fr6hNbW23hGKAp-lmc1A3I";
        String token = autenticacao.getToken();
        given()
                .log().all()
                .pathParams("_id", idProduto)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(
                        """
                                {
                                "nome": "Impressora Matricial editada",
                                "preco": 470,
                                "descricao": "Impressora Matricial",
                                "quantidade": 381
                                }
                                       
                                """
                )
                .when()
                .put("/produtos/{_id}")
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"))
        ;
    }

    @Test
    public void testDeletarUmProdutoComSucesso() {
        String idProduto = "shtolh9OHbhYEkdH";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhbWlsYWdvbmNhbHZlc0BxYS5jb20uYnIiLCJwYXNzd29yZCI6InRlc3RlIiwiaWF0IjoxNzEyMjQ3MTU5LCJleHAiOjE3MTIyNDc3NTl9.e6YmOBmkF7c2fcu1PaIQ-fr6hNbW23hGKAp-lmc1A3I";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .pathParams("_id", idProduto)
                .when()
                .delete("/produtos/{_id}")
                .then()
                .log().all()
                .extract()
                .response();
        response.then().statusCode(200);
        response.then().body("message", containsString("Registro excluído com sucesso"));
    }


}
