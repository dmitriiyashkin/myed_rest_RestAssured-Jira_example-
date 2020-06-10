package pettest_v2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.*;
import pojo.User;
import utils.api.Authorization;
import utils.data.PetshopPOJOHelper;

import static io.restassured.RestAssured.given;

public class PetWithPOJOTest {
    private static ValidatableResponse response;
    static {
        RestAssured.baseURI = Authorization.BASE_URL;
    }

    @BeforeClass
    public static void createUser() {
        User newUser = PetshopPOJOHelper.generateJSONForNewUser();
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
                get("/user/login?username="+Authorization.username+"&password=" + Authorization.password).
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
                delete("/user/"+Authorization.username).
                then().
                statusCode(200).contentType(ContentType.JSON);
    }
}
