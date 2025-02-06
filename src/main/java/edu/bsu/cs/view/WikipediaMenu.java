package edu.bsu.cs.view;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionFormatter;
import java.util.List;
import java.util.Scanner;

public class WikipediaMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {


        System.out.println("*".repeat(15) + " Welcome to Wikisearch " + "*".repeat(15));
        System.out.println("\nPut in the article's name: ");
        String articleName = scanner.nextLine();


    }
    public String getArticleName() {
        System.out.println("*".repeat(15) + " Welcome to Wiki search " + "*".repeat(15));
        System.out.println("\nPut in the article's name: ");
        return scanner.nextLine().trim();
    }

    public void displayRevisions(List<Revision> revisions) {
        int counter = 1;
        for (Revision revision : revisions) {
            System.out.println(RevisionFormatter.format(revision, counter++));
        }
    }

    public void displayError(String message) {
        System.err.println("Error: " + message);
    }


}
