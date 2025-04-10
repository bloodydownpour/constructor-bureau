package bureau.domain;

public class User extends Entity {

    private String username;
    private String email;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String username, String email, String role) {
        super(id);
        this.username = username;
        this.email = email;
        this.role = role;
    }
    public User() {}

}
