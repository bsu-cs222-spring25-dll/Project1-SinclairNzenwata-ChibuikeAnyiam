package edu.bsu.cs.controller;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.service.WikipediaApiService;
import edu.bsu.cs.view.CLI.WikipediaCLI;
import edu.bsu.cs.view.GUI.WikipediaGUI;
import edu.bsu.cs.view.WikipediaView;

import java.io.IOException;
import java.util.List;

public class WikipediaController {
    private final RevisionService service;
//    private final WikipediaCLI menu;
    private final WikipediaApiService apiService;
//    private final WikipediaGUI wikipediaGUI;
    private final WikipediaView view;

    public WikipediaController(RevisionService service, WikipediaApiService apiService, WikipediaView view) {
        this.service = service;
        this.apiService = apiService;
        this.view = view;
//        this.wikipediaGUI = wikipediaGUI;
    }
//    public void startApplication(String[] args) {
//        if (args.length > 0 && args[0].equalsIgnoreCase("cli")) {
//            WikipediaCLI cli = new WikipediaCLI();
//            cli.start(apiService);
//        } else {
//            WikipediaGUI gui = new WikipediaGUI();
//            gui.start(apiService);
//        }
//    }
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

//    public void fetchAndDisplayRevisions() {
//        String article;
//        if (wikipediaGUI != null) {
//            article = wikipediaGUI.getGUIArticle();
//            if (article.isEmpty()) {
//                wikipediaGUI.displayGUIError("No article name provided");
//                return;
//            }
//            wikipediaGUI.disableSearch(true);
//        } else {
//            article = menu.getArticleName();
//            if (article.isEmpty()) {
//                menu.displayError("No article name provided");
//            }
//        }
//
//        try {
//            String jsonData = apiService.fetchWikipediaData(article);
//            List<Revision> revisions = service.getRevisions(jsonData);
//            if (revisions.get(0).getIsMissing()){
//                if(wikipediaGUI != null){
//                    wikipediaGUI.displayGUIError("No Wikipedia page found");
//                } else {
//                    menu.displayError("No Wikipedia page found");
//                }
//                return;
//            }
//            if (wikipediaGUI != null){
//                wikipediaGUI.displayGUIRevisions(revisions);
//            } else {
//                menu.displayRevisions(revisions);
//            }
//        } catch (IOException | InterruptedException e) {
//           if (wikipediaGUI != null) {
//               wikipediaGUI.displayGUIError("Failed to retrieve revisions. Try turning on your wifi or mobile data " + "\nError Message: " +e.getMessage());
//           } else {
//               menu.displayError("Failed to retrieve revisions. Try turning on your wifi or mobile data " + "\nError Message: " +e.getMessage());
//           }
//        } finally {
//            if (wikipediaGUI != null) {
//                wikipediaGUI.disableSearch(false);
//            }
//        }
//    }
}
