package edu.bsu.cs.utils;

import edu.bsu.cs.model.Revision;

public class RevisionFormatter {
    public static String format(Revision revision, int counter) {
        if (revision.getRedirectText() != null && !revision.getRedirectText().isEmpty()) {
            return "Redirected to: " + revision.getRedirectText();
        }
        if (revision.getIsMissing()) {
            return "No Wikipedia Page";
        }
        return counter + "  " + revision.getTimestamp() + "  " + revision.getUser();
    }
}
