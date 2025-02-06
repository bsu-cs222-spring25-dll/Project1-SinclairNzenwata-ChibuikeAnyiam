package edu.bsu.cs.utils;

import edu.bsu.cs.model.Revision;

public class RevisionFormatter {
    public static String format(Revision revision, int counter) {
        return counter + "  " + revision.getTimestamp() + "  " + revision.getUser();
    }
}
