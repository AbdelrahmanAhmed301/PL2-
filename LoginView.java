package inventory;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {

    private AuthService authService = new AuthService();

    public LoginView() {
        authService.registerUser(new Admin(1, "admin", "1234"));
        authService.registerUser(new Client(2, "client", "1111", "Client", "c@mail.com"));
    }

    public void show(Stage stage) {

        Label title = new Label("Login");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Label msg = new Label();

        loginBtn.setOnAction(e -> {
            User user = authService.login(username.getText(), password.getText());
            if (user == null) {
                msg.setText("Invalid login");
            } else {
                new MainMenuView().show(stage);
            }
        });

        VBox root = new VBox(15, title, username, password, loginBtn, msg);
        root.setPadding(new Insets(30));

        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Login");
        stage.setMaximized(true);
        stage.show();
    }
}
