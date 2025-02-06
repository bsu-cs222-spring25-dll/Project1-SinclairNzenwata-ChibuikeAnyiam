package edu.bsu.cs;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionParser;

import java.io.IOException;
import java.util.List;

public class WikipediaFetcher {
    public static void main(String[] args) throws IOException {
        String jsonFilePath = "src/test/resources/sample.json";
        RevisionParser parser = new RevisionParser(jsonFilePath);

        List<Revision> revisions = parser.parseRevisions();
        revisions.forEach(System.out::println);
    }
}
