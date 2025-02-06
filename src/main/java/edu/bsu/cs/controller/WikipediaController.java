package edu.bsu.cs.controller;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.routes.RevisionAPI;
import edu.bsu.cs.view.WikipediaMenu;
import java.io.IOException;
import java.util.List;

public class WikipediaController {
    private final RevisionAPI service;
    private final WikipediaMenu view;

    public WikipediaController(RevisionAPI service, WikipediaMenu view) {
        this.service = service;
        this.view = view;
    }

    public void fetchAndDisplayRevisions() {
        String article = view.getArticleName();
        try {
            List<Revision> revisions = service.getRevisions(article);
            view.displayRevisions(revisions);
        } catch (IOException e) {
            view.displayError("Failed to retrieve revisions.");
        }
    }
}
