package inventory;

import java.io.*;
import java.util.ArrayList;

public class UserFileHandler {

    private static final String FILE_NAME = "users.txt";

    public static void saveUsers(ArrayList<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User u : users) {
                if (u instanceof Admin) {
                    bw.write(u.getUserId() + "," +
                            u.getUsername() + "," +
                            "1234" + "," +
                            "ADMIN,,");
                } else if (u instanceof Client) {
                    Client c = (Client) u;
                    bw.write(u.getUserId() + "," +
                            u.getUsername() + "," +
                            "1234" + "," +
                            "CLIENT," +
                            c.getName() + "," +
                            c.getEmail());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String username = data[1];
                String password = data[2];
                String role = data[3];

                if (role.equals("ADMIN")) {
                    users.add(new Admin(id, username, password));
                } else if (role.equals("CLIENT")) {
                    String name = data[4];
                    String email = data[5];
                    users.add(new Client(id, username, password, name, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}

