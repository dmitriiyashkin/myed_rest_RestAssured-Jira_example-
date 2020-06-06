package pettest_v1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class RawPetTest {
    private static ValidatableResponse response;

    @BeforeClass
    public static void createUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String newUser = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"YaName\",\n" +
                "  \"firstName\": \"YaFirstName\",\n" +
                "  \"lastName\": \"YaLastName\",\n" +
                "  \"email\": \"ya@gmail.com\",\n" +
                "  \"password\": \"12345\",\n" +
                "  \"phone\": \"8800\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(newUser).
                when().
                post("/user").
                then().
                statusCode(200).contentType(ContentType.JSON);
    }

    @BeforeTest
    public void login() {
        response = given().
                header("Content-Type", "application/json").
                when().
                get("/user/login?username=YaName&password=12345").
                then().
                statusCode(200).contentType(ContentType.JSON);
    }
    

    @AfterTest
    public void logout() {
        response = given().
                header("Content-Type", "application/json").
                when().
                get("/user/logout").
                then().
                statusCode(200).contentType(ContentType.JSON);
    }

    @AfterClass
    public static void deleteUser() {
        response = given().
                header("Content-Type", "application/json").
                when().
                delete("/user/YaName").
                then().
                statusCode(200).contentType(ContentType.JSON);
    }
}
