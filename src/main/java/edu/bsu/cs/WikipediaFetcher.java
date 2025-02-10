package edu.bsu.cs;

import edu.bsu.cs.controller.WikipediaController;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.service.WikipediaApiService;
import edu.bsu.cs.utils.RevisionBuilder;
import edu.bsu.cs.utils.RevisionParser;
import edu.bsu.cs.view.WikipediaMenu;

public class WikipediaFetcher {
    public static void main(String[] args) {
        WikipediaMenu menu = new WikipediaMenu();
        WikipediaApiService apiService = new WikipediaApiService();
        RevisionParser parser = new RevisionParser();
        RevisionBuilder builder = new RevisionBuilder();
        RevisionService service = new RevisionService(parser, builder);
        WikipediaController controller = new WikipediaController(service, menu, apiService);

        controller.fetchAndDisplayRevisions();
    }
}
