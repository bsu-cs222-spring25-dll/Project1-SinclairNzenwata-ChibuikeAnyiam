package edu.bsu.cs.view.GUI;

import edu.bsu.cs.controller.WikipediaController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Objects;

public class WikipediaGUI extends Application {
    private final ListView<String> listView = new ListView<>();
    private TextField textField
    private Button searchButton;
    private WikipediaController wikipediaController;

    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Welcome to Wiki Search");
        titleLabel.setAlignment(Pos.CENTER);

        textField = new TextField();
        textField.setPromptText("Enter article name...");
        searchButton = new Button("Search");

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(titleLabel, textField, searchButton, listView);
        layout.getStyle().add("vbox");

        textField.setMaxWidth(400);
        layout.setMinWidth(400);
        listView.setMinHeight(300);

        Scene scene = new Scene(layout, 640, 400);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        stage.setMinWidth(500);
        stage.setMinHeight(400);
        stage.setScene(scene);
        stage.setTitle("Wiki Search");
        stage.show();

    }
}
