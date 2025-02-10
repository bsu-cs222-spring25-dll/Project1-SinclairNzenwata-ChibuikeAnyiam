package edu.bsu.cs.controller;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.service.WikipediaApiService;
import edu.bsu.cs.view.WikipediaMenu;
import java.io.IOException;
import java.util.List;

public class WikipediaController {
    private final RevisionService service;
    private final WikipediaMenu menu;
    private final WikipediaApiService apiService;

    public WikipediaController(RevisionService service, WikipediaMenu view, WikipediaApiService apiService) {
        this.service = service;
        this.menu = view;
        this.apiService = apiService;
    }

    public void fetchAndDisplayRevisions() {
        String article = menu.getArticleName();
        try {
            String jsonData = apiService.fetchWikipediaData(article);
            List<Revision> revisions = service.getRevisions(jsonData);
            menu.displayRevisions(revisions);
        } catch (IOException | InterruptedException e) {
            menu.displayError("Failed to retrieve revisions." + e.getMessage());
        }
    }
}
