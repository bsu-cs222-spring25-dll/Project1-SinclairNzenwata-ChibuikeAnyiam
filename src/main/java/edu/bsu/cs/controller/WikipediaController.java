package edu.bsu.cs.controller;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.service.WikipediaApiService;
import edu.bsu.cs.utils.RevisionBuilder;
import edu.bsu.cs.utils.RevisionParser;
import edu.bsu.cs.view.CLI.WikipediaCLI;
import edu.bsu.cs.view.GUI.WikipediaGUI;
import edu.bsu.cs.view.WikipediaView;
import javafx.application.Application;
import java.io.IOException;
import java.util.List;

public class WikipediaController {
    private final RevisionService service;
    private final WikipediaApiService apiService;
    private final WikipediaView view;
    public WikipediaController(RevisionService service, WikipediaApiService apiService, WikipediaView view) {
        this.service = service;
        this.apiService = apiService;
        this.view = view;
    }
    public static void startApplication(String[] args) {
        WikipediaApiService apiService = new WikipediaApiService();
        RevisionParser parser = new RevisionParser();
        RevisionBuilder builder = new RevisionBuilder();
        RevisionService service = new RevisionService(parser, builder);

        // Launch GUI
        if (args.length > 0 && args[0].equals("--gui")) {
            Application.launch(WikipediaGUI.class, args);
            return;
        }
        // Default to CLI if no --gui flag is passed
        WikipediaView view = new WikipediaCLI();
        WikipediaController controller = new WikipediaController(service, apiService, view);
        controller.fetchAndDisplayRevisions();
    }
    public void fetchAndDisplayRevisions() {
        String article = view.getArticleName();
        if (article.isEmpty()) {
            view.displayError("No article name provided");
            return;
        }
        try {
            String jsonData = apiService.fetchWikipediaData(article);
            List<Revision> revisions = service.getRevisions(jsonData);

            if (revisions.isEmpty() || revisions.get(0).getIsMissing()) {
                view.displayError("No Wikipedia page found");
                return;
            }

            view.displayRevisions(revisions);
        } catch (IOException | InterruptedException e) {
            view.displayError("Failed to retrieve revisions: " + e.getMessage());
        }
    }
}
