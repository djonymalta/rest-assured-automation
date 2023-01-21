package requests;

import br.automationtests.entity.ClientHttp;
import br.automationtests.utils.Login;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class EventRegistrationTest {
    ClientHttp baseUrl = new ClientHttp();

    @Test
    public void createUserTest(){

        String payload = "{\n" +
                "  \"userName\": \"djony_malta\",\n" +
                "  \"password\": \"Bridah@2032\"\n" +
                "}";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");


        Response response = httpRequest.body(payload).post(baseUrl.baseUrl() + "/Account/v1/User");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

    }
}
