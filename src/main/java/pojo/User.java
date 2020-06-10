package pojo;

public class User implements Pojo {
    public String id ;
    public String username ;
    public String email;
    public String phone;
    public String firstName;
    public String lastName;
    public Integer password;
    public Integer userStatus;

    public User(){};

    public User(String id, String username, String email, String phone, String firstName, String lastName, Integer password, Integer userStatus) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userStatus = userStatus;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setPassword(Integer password) {
        this.password = password;
        return this;
    }

    public User setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
        return this;
    }
}
