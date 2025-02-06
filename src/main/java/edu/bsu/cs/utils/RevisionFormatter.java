package edu.bsu.cs.utils;

import edu.bsu.cs.model.Revision;

public class RevisionFormatter {
    public static String format(Revision revision, int counter) {
        if (revision.getOther() != null && !revision.getOther().isEmpty()) {
            return revision.getOther();
        }
        return counter + "  " + revision.getTimestamp() + "  " + revision.getUser();
    }
}