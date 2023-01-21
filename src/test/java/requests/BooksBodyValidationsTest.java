package requests;

import br.automationtests.entity.ClientHttp;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class BooksBodyValidationsTest {

    public static void main(String[] args) {
        ClientHttp baseURl = new ClientHttp();

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, baseURl.baseUrl() + "/Bookstore/v1/Books/");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is: " + statusCode);

        Assertions.assertEquals(200, statusCode);
        Headers header = response.getHeaders();
        int countOfHeaders = header.asList().size();
        Assertions.assertEquals(7, countOfHeaders);
        String headerValue = response.getHeader("Content-Type");
        Assertions.assertEquals("application/json; charset=utf-8", headerValue);

        String responseBOdyAsString = response.getBody().asString();
        Assertions.assertTrue(responseBOdyAsString.contains("Git Pocket Guide"));

    }
}
