package teste;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class APITest {
    @Test
    public void testeFuncionalAPIEndpointProdutos(){
        given()
                .when()
                .get("http://localhost:3000/produtos")
                .then()
                .statusCode(200)
                .body("produtos.nome", hasItem("Logitech MX Vertical"));
    }
}
