package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class RevisionProcessor {
    public List<Revision> processRevisions(List<String> users, List<String> timestamps, List<String> redirects, List<String> missingPages) {
        List<Revision> revisionList = new ArrayList<>();

        // Handle redirects
        if (!redirects.isEmpty()) {
            revisionList.add(new Revision("Redirected to: " + redirects.get(0), "N/A"));
        }

        // Handle missing pages
        if (!missingPages.isEmpty()) {
            revisionList.add(new Revision("Error: Page does not exist", "N/A"));
        }

        // Add all revisions to the list
        for (int i = 0; i < users.size(); i++) {
            String user = users.get(i);
            String timestamp = timestamps.get(i);
            revisionList.add(new Revision(user, timestamp));
        }

        return revisionList;
    }
}
