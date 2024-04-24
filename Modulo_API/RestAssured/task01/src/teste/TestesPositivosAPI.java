package teste;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.Test;

public class TestesPositivosAPI {

    @Test
    public void testStatusCodeIs200() {
        given()
                .log().all()
                .when()
                .get("http://localhost:3000/produtos")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testListarProdutosComSucesso() {
        given()
                .log().all()
        .when()
                .get("http://localhost:3000/produtos")
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
    public void testBuscarProdutoPorId() {
        given()
                .pathParams("id", "09KYZUVSa4gZs4ay")
        .when()
                .get("http://localhost:3000/produtos/{id}")
        .then()
                .statusCode(200)
                .body("nome", equalTo("Impressora"))
                .body("descricao", equalTo("Et quia delectus veniam perspiciatis ipsam ipsa reiciendis sequi. Qui corrupti ut omnis hic et aut. Possimus pariatur aut incidunt sit omnis dolore. Ullam veritatis repellendus natus. Sunt autem dolores doloremque. Odio enim expedita provident aperiam neque."))
                .body("preco", equalTo(534));

    }


    @Test //Para este teste passar novamente precisa de um novo token e um novo nome de produto
    public void testAtualizarProduto(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVtYWlsQHFhLmNvbS5iciIsInBhc3N3b3JkIjoidGVzdGUiLCJpYXQiOjE3MTIxNTA2NjUsImV4cCI6MTcxMjE1MTI2NX0.KVrTzhLfL7vAalTXoHG7p3427iu44nMK6AFJFf4WCCw";
        String novoNome = "Smartphone New 2";
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
                    .statusCode(200);
    }

    @Test //Para este teste passar novamente precisa de um novo token e um novo nome de produto
    public void testPostProduto(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVtYWlsQHFhLmNvbS5iciIsInBhc3N3b3JkIjoidGVzdGUiLCJpYXQiOjE3MTIxNTE1MjQsImV4cCI6MTcxMjE1MjEyNH0.EEVWtmPt5QY8-xZ7AfpZ09TX6TWxn--9mguQ_QIOaN0";
        String requestBody = "{\"nome\": \"mouse 23\",\"preco\": 470, \"descricao\": \"Mouse\", \"quantidade\": 381 }";

               given()
                       .contentType(ContentType.JSON)
                       .header("Authorization", "Bearer " + token)
                       .body(requestBody)
               .when()
                       .post("http://localhost:3000/produtos")
               .then()
                       .statusCode(201)
                       .body("message", equalTo("Cadastro realizado com sucesso"))
                       .body("_id", notNullValue());
    }

    @Test // Para este teste passar novamente se faz necessário alterar o token e o id
    public void testDeletarProduto(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImVtYWlsQHFhLmNvbS5iciIsInBhc3N3b3JkIjoidGVzdGUiLCJpYXQiOjE3MTIxNTIzMzMsImV4cCI6MTcxMjE1MjkzM30.KYCL6uqDyiDgD2_HQu0GojUXy9Mehd2jcNcTl4K6NXY";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .pathParams("id", "si6Ooc8JQUaKnLLH")
                .when()
                .delete("http://localhost:3000/produtos/{id}")
                .then()
                .extract()
                .response();

        response.then().statusCode(200);
        response.then().body("message", containsString("Registro excluído com sucesso"));

    }


}


