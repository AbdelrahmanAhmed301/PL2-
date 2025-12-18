package inventory;

public class Client extends User {

    private String name;
    private String email;

    public Client() {}

    public Client(int userId, String username, String password,
                  String name, String email) {
        super(userId, username, password);
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getRole() {
        return "CLIENT";
    }
}

