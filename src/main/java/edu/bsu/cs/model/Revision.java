package edu.bsu.cs.model;

public class Revision {
    private final String user;
    private final String timestamp;

    private final  String redirectText;
    private final boolean isMissing;

    public Revision(String user, String timestamp, String redirectText, boolean isMissing) {
        this.user = user;
        this.timestamp = timestamp;
        this.redirectText = redirectText;
        this.isMissing = isMissing;
    }

    public Revision(String user, String timestamp) {
        this(user, timestamp, "", false);
    }

    public Revision(String redirectText) {
        this("", "", redirectText, false);
    }

    public Revision(boolean isMissing) {
        this("", "", "", isMissing);
    }

    public String getUser() {
        return user;
    }

    public String getRedirectText() {
        return redirectText;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public boolean getIsMissing(){
        return isMissing;
    }
}
