package edu.bsu.cs.view.CLI;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionFormatter;
import edu.bsu.cs.view.WikipediaView;

import java.util.List;
import java.util.Scanner;

public class WikipediaCLI implements WikipediaView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String getArticleName() {
        System.out.println("*".repeat(15) + " Welcome to Wiki search " + "*".repeat(15));
        System.out.print("\nPut in the article's name: ");
        return scanner.nextLine().trim();
    }
    @Override
    public void displayRevisions(List<Revision> revisions) {
        int counter = 1;
        for (Revision revision : revisions) {
            String formattedOutput = RevisionFormatter.format(revision, counter);
            if (!formattedOutput.startsWith("Redirected to:")) {
                counter++;
            }
            System.out.println(formattedOutput);
        }
    }

    @Override
    public void displayError(String message) {
        System.err.println("Error: " + message);
        System.exit(0);
    }
}
