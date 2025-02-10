package edu.bsu.cs.service;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionBuilder;
import edu.bsu.cs.utils.RevisionParser;
import java.io.IOException;
import java.util.List;

public class RevisionService {
    private final RevisionParser parser;
    private final RevisionBuilder builder;

    public RevisionService(RevisionParser parser, RevisionBuilder builder) {
        this.parser = parser;
        this.builder = builder;
    }

    public List<Revision> getRevisions(String article) throws IOException {
        return builder.buildRevisions(
                parser.extractUsers(),
                parser.extractTimestamps(),
                parser.extractRedirects(),
                parser.extractMissingPages()
        );
    }
}
