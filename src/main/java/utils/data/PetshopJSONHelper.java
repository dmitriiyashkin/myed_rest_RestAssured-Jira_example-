package utils.data;


import org.json.simple.JSONObject;
import utils.api.Authorization;

public class PetshopJSONHelper {
    public static String generateJSONForCreateNewUser() {
        JSONObject credentials = new JSONObject();
        credentials.put("id", "0");
        credentials.put("username", Authorization.username);
        credentials.put("firstName", Authorization.firstName);
        credentials.put("lastName", Authorization.lastName);
        credentials.put("email", Authorization.email);
        credentials.put("password", Authorization.password);
        credentials.put("phone", Authorization.phone);
        credentials.put("userStatus", "0");
        return credentials.toJSONString();
    }
}
