package inventory;

import java.util.ArrayList;

public class AuthService {

    private ArrayList<User> users = new ArrayList<>();

    public void registerUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
                    && u.login(username, password)) {
                return u;
            }
        }
        return null;
    }
}
