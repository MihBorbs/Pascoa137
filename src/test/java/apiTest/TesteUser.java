// nome do pacote
package apiTest;

// bibliotecas


import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteUser {        // inicio da classe
    // atributos
    static String ct = "application/json"; // content type

    static String uriUser = "https://petstore.swagger.io/v2/user/";

    // funcões e métodos
    // funções de apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // funções de teste
    @Test
    @Order(1)
    public void testarIncluirUser() throws IOException {
        // carregar os dados do nosso Json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userId = "1373829940";

    // realizar o teste
    given()                                           // dado que
            .contentType("application/json")       // o tipo do conteúdo
            .log().all()                           // mostre tudo
            .body(jsonBody)                        // corpo da requisição

            .when()                                          // endpoint / onde
            .post("https://petstore.swagger.io/v2/user")   // endpoint / onde

    .then()                                                     // então
            .log().all()                                         // mostre tudo na volta
            .statusCode(200)                                 // comun. ida e volta ok
            .body("code", is(200))                      // tag code é 200
            .body("type", is("unknown"))                // tag type é "unknown"
            .body("message", is(userId))                          // message é userId
    ;

    } // fim do post

    @Test
    @Order(2)
    public void testarConsultarUser(){
        String username = "michael";

        // resultados esperados
        int userId = 1373829940; // código do usuário
        String email = "scott@teste.com";
        String senha = "123456";
        String telefone = "11999998888";


        given()
                .contentType(ct)
                .log().all()

        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone))
    ;

    } // fim do Get User

    @Test
    @Order(3)
    public void testarAlterarUser() throws IOException { // inicio do Put User
         String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userId = "1373829940";
        String username = "michael";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is (200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;


    } // fim do Put User

    @Test
    @Order(4)
    public void testarExcluirUser(){ // inicio do Delete User
        String username = "michael";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is (200))
                .body("type", is ("unknown"))
                .body("message", is(username))
        ;



    } // fim do Delete User

    @Test
    public void testarLogin(){ // inicio do login
        String username = "michael";
        String password = "abcdef";

       Response response = (Response) given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + "login?username=" + username +"&password=" + password)
        .then()
               .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
        .extract();

       // extração do token da resposta

        String token = response.jsonPath().getString("message").substring(23);
        System.out.println("Conteudo do Token: " + token);
    } // fim do login

    @ParameterizedTest
    public void testarIncluirUserCSV(){ // inicio Incluir CSV
        // carregar os dados no nosso json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userId = "1373829940";

        // realizar o teste
        given()                                           // dado que
                .contentType("application/json")       // o tipo do conteúdo
                .log().all()                           // mostre tudo
                .body(jsonBody)                        // corpo da requisição

                .when()                                          // endpoint / onde
                .post("https://petstore.swagger.io/v2/user")   // endpoint / onde

                .then()                                                     // então
                .log().all()                                         // mostre tudo na volta
                .statusCode(200)                                 // comun. ida e volta ok
                .body("code", is(200))                      // tag code é 200
                .body("type", is("unknown"))                // tag type é "unknown"
                .body("message", is(userId))                          // message é userId
        ;
    } // fim incluir CSV

} // fim da classe