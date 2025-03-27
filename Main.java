import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private int count = 0;

    @Override
    public void start(Stage primaryStage) {
        Text counterText = new Text("Count: " + count);
        Button clickButton = new Button("Click me");

        clickButton.setOnAction(e -> {
            count++;
            counterText.setText("Count: " + count);
        });

        VBox layout = new VBox(10, counterText, clickButton);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
