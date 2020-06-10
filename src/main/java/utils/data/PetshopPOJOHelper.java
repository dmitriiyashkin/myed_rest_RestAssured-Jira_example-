package utils.data;

import pojo.User;
import utils.api.Authorization;

public class PetshopPOJOHelper {
    public static User generateJSONForNewUser(){
        return new User()
                .setId(Authorization.id)
                .setUsername(Authorization.username)
                .setEmail(Authorization.email)
                .setPhone(Authorization.phone)
                .setFirstName(Authorization.firstName)
                .setLastName(Authorization.lastName)
                .setPassword(Authorization.password)
                .setUserStatus(Authorization.userStatus);
    }
}
