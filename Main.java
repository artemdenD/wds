import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Todo List");

        ObservableList<String> tasks = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(tasks);

        TextField taskInput = new TextField();
        taskInput.setPromptText("Add a new task");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskInput.clear();
            }
        });

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
            String selectedTask = listView.getSelectionModel().getSelectedItem();
            tasks.remove(selectedTask);
        });

        HBox inputBox = new HBox(10, taskInput, addButton, removeButton);
        VBox layout = new VBox(10, listView, inputBox);
        layout.setStyle("-fx-padding: 10;");

        primaryStage.setScene(new Scene(layout, 300, 400));
        primaryStage.show();
    }
}
