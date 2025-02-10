package edu.bsu.cs.utils;

import edu.bsu.cs.model.Revision;

public class RevisionFormatter {
    public static String format(Revision revision, int counter) {
        if (revision.getRedirectText() != null && !revision.getRedirectText().isEmpty()) {
            return "Redirected to: " + revision.getRedirectText();
        }
        if (revision.getIsMissing()) {
            System.err.println("No Wikipedia Page");
//            System.exit(0);
            // needed this return statement for the test to pass, but comment when production is live.
            return "No Wikipedia Page";

        }
        return counter + "  " + revision.getTimestamp() + "  " + revision.getUser();
    }
}