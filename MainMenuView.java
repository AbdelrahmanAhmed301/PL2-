package inventory;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    public void show(Stage stage) {

        Button productsBtn = new Button("Products");
        Button exitBtn = new Button("Exit");

        productsBtn.setOnAction(e -> {
            new ProductsView().show(stage);
        });

        exitBtn.setOnAction(e -> stage.close());

        VBox root = new VBox(20, productsBtn, exitBtn);
        root.setStyle("-fx-padding: 30;");

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Main Menu");

        stage.setMaximized(true);

        stage.show();
    }
}
