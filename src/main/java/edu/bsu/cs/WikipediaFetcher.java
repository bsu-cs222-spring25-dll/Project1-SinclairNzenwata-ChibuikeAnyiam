package edu.bsu.cs;

import edu.bsu.cs.controller.WikipediaController;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.service.WikipediaApiService;
import edu.bsu.cs.utils.RevisionBuilder;
import edu.bsu.cs.utils.RevisionParser;
import edu.bsu.cs.view.CLI.WikipediaCLI;
import edu.bsu.cs.view.GUI.WikipediaGUI;
import javafx.application.Application;

public class WikipediaFetcher {
    public static void main(String[] args) {
        WikipediaApiService apiService = new WikipediaApiService();
        RevisionParser parser = new RevisionParser();
        RevisionBuilder builder = new RevisionBuilder();
        RevisionService service = new RevisionService(parser, builder);
        if (args.length > 0 && args[0].equals("--gui")) {
            Application.launch(WikipediaGUI.class, args);
        } else {
            WikipediaCLI wikipediaCLI = new WikipediaCLI();
            WikipediaController controller = new WikipediaController(service, wikipediaCLI, apiService);
            controller.fetchAndDisplayRevisions();
        }

    }
}
