package inventory;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductsView {

    private ProductManager productManager = new ProductManager();

    public void show(Stage stage) {

        Label title = new Label("Products");

        Button showBtn = new Button("Show Products");
        Button backBtn = new Button("Back");

        TextArea output = new TextArea();
        output.setEditable(false);

        showBtn.setOnAction(e -> {
            output.clear();
            for (Product p : productManager.getAllProducts()) {
                output.appendText(p.toString() + "\n");
            }
        });

        backBtn.setOnAction(e -> {
            new MainMenuView().show(stage);
        });

        VBox root = new VBox(20, title, showBtn, backBtn, output);
        root.setStyle("-fx-padding: 30;");

        stage.setScene(new Scene(root, 900, 600));
        stage.setTitle("Products");
        stage.setMaximized(true);
        stage.show();
    }
}
