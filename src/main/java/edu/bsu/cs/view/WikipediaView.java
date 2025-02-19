package edu.bsu.cs.view;

import edu.bsu.cs.model.Revision;

import java.util.List;

public interface WikipediaView {
    void displayRevisions(List<Revision> revisions);
    void displayError(String message);
    String  getArticleName();
}
