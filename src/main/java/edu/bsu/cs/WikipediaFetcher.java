package edu.bsu.cs;

import edu.bsu.cs.controller.WikipediaController;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.utils.RevisionParser;
import edu.bsu.cs.utils.RevisionProcessor;
import edu.bsu.cs.view.WikipediaMenu;

public class WikipediaFetcher {
    public static void main(String[] args) {
        WikipediaMenu view = new WikipediaMenu();
        RevisionParser parser = new RevisionParser("src/test/resources/sample.json");
        RevisionProcessor processor = new RevisionProcessor();
        RevisionService service = new RevisionService(parser, processor);
        WikipediaController controller = new WikipediaController(service, view);

        controller.fetchAndDisplayRevisions();
    }
}
