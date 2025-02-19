package edu.bsu.cs.utils;

import edu.bsu.cs.model.Revision;

import java.util.ArrayList;
import java.util.List;

public class RevisionBuilder {
    public List<Revision> buildRevisions(List<String> users, List<String> timestamps, List<String> redirects, List<String> missingPages) {
        List<Revision> revisionList = new ArrayList<>();
        if (!redirects.isEmpty()) {
            revisionList.add(new Revision( redirects.get(0)));
        }
        if (!missingPages.isEmpty()) {
            revisionList.add(new Revision(true));
        }
        for (int i = 0; i < users.size(); i++) {
            String user = users.get(i);
            String timestamp = timestamps.get(i);
            revisionList.add(new Revision(user, timestamp));
        }
        return revisionList;
    }
}
