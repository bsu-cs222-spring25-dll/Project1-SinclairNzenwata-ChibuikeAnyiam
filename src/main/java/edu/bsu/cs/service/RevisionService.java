package edu.bsu.cs.service;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionParser;
import edu.bsu.cs.utils.RevisionProcessor;
import java.io.IOException;
import java.util.List;

public class RevisionService {
    private final RevisionParser parser;
    private final RevisionProcessor processor;

    public RevisionService(RevisionParser parser, RevisionProcessor processor) {
        this.parser = parser;
        this.processor = processor;
    }

    public List<Revision> getRevisions(String article) throws IOException {
        return processor.processRevisions(
                parser.extractUsers(),
                parser.extractTimestamps(),
                parser.extractRedirects(),
                parser.extractMissingPages()
        );
    }
}
