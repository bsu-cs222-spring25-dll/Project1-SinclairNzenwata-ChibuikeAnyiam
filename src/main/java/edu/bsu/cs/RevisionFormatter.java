package edu.bsu.cs;

public class RevisionFormatter {
    public static String format(Revision revision, int counter) {
        return counter + "  " + revision.getTimestamp() + "  " + revision.getUser();
    }
}
