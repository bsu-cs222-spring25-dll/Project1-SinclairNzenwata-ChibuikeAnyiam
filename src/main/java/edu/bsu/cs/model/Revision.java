package edu.bsu.cs.model;

public class Revision {
    private final String user;
    private final String timestamp;

    private final  String other;

    public Revision(String user, String timestamp, String other) {
        this.user = user;
        this.timestamp = timestamp;
        this.other = other;
    }

    public String getUser() {
        return user;
    }

    public String getOther() {
        return other;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
