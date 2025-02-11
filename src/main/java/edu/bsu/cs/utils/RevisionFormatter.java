package edu.bsu.cs.utils;

import edu.bsu.cs.model.Revision;

public class RevisionFormatter {
    public static String format(Revision revision, int counter) {
        if (revision.getRedirectText() != null && !revision.getRedirectText().isEmpty()) {
            return "Redirected to: " + revision.getRedirectText();
        }
        return counter + "  " + revision.getTimestamp() + "  " + revision.getUser();
    }
}
