package requests;

import br.automationtests.entity.ClientHttp;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

public class GET_Requests {

    public static void main(String[] args) {
        ClientHttp baseURl = new ClientHttp();

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, baseURl.baseUrl() + "/Bookstore/v1/Books/");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is: " + statusCode);
        Assertions.assertEquals(200, statusCode);
        Headers header = response.getHeaders();
        System.out.println("Headers for response are: " + header);
    }
}
