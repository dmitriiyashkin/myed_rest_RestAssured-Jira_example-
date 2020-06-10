package pettest_v2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.*;
import utils.api.Authorization;
import utils.data.PetshopJSONHelper;

import static io.restassured.RestAssured.given;

public class PetWithJSONObjectTest {
    private static ValidatableResponse response;
    static {
        RestAssured.baseURI = Authorization.BASE_URL;
    }

    @BeforeClass
    public static void createUser() {
        String newUser = PetshopJSONHelper.generateJSONForCreateNewUser();
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


    @Test
    public void someTest(){

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
