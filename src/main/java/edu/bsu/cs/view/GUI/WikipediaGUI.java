package edu.bsu.cs.view.GUI;

import edu.bsu.cs.controller.WikipediaController;
import edu.bsu.cs.model.Revision;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.service.WikipediaApiService;
import edu.bsu.cs.utils.RevisionBuilder;
import edu.bsu.cs.utils.RevisionFormatter;
import edu.bsu.cs.utils.RevisionParser;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class WikipediaGUI extends Application {
    private TextField textField;
    private final ListView<String> listView = new ListView<>();
    private Button searchButton;
    private WikipediaController wikipediaController;
    @Override
    public void start(Stage stage) {
        WikipediaApiService apiService = new WikipediaApiService();
        RevisionParser parser = new RevisionParser();
        RevisionBuilder builder = new RevisionBuilder();
        RevisionService service = new RevisionService(parser, builder);
        wikipediaController = new WikipediaController(service, null, apiService, this);

        Label titleLabel = new Label("Welcome to Wiki Search");
        titleLabel.setAlignment(Pos.CENTER);

        textField = new TextField();
        textField.setPromptText("Enter article name...");
        searchButton = new Button("Search");

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(titleLabel, textField, searchButton, listView);
        layout.getStyleClass().add("vbox");

        textField.setMaxWidth(400);
        layout.setMinWidth(400);
        listView.setMinHeight(300);

        Scene scene = new Scene(layout, 640, 480);

        // Links to the CSS file in the resources directory
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        stage.setMinWidth(500);
        stage.setMinHeight(400);
        stage.setScene(scene);
        stage.setTitle("Wiki Search");
        stage.show();

        searchButton.setOnAction(e -> wikipediaController.fetchAndDisplayRevisions());
    }

    public void displayGUIRevisions(List<Revision> revisions) {
        listView.getItems().clear();
        int counter = 1;
        for (Revision revision : revisions) {
            String formattedOutput = RevisionFormatter.format(revision, counter);
            if (!formattedOutput.startsWith("Redirected to:")) {
                counter++;
            }
            listView.getItems().add(formattedOutput);
        }
    }

    public String getGUIArticle() {
        return textField.getText();
    }

    public void displayGUIError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        searchButton.setDisable(false);
    }

//    public void display

    public void disableSearchButton(boolean disable) {
        searchButton.setDisable(disable);
        textField.setDisable(disable);
    }
}