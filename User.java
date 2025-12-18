package inventory;

public abstract class User {

    protected int userId;
    protected String username;
    protected String password;

    public User() {}

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract String getRole();
}

