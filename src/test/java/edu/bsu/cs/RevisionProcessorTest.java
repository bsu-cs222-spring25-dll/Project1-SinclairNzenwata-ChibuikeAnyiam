package edu.bsu.cs;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionProcessor;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionProcessorTest {
    final RevisionProcessor revisionProcessor = new RevisionProcessor();

    @Test
    public void ProcessRedirectTest() {
        List<Revision> revisionsList = revisionProcessor.processRevisions(Collections.emptyList(), Collections.emptyList(), List.of("Sinclair Stark"), Collections.emptyList());
        assertEquals("Redirected to: Sinclair Stark", revisionsList.get(0).getRedirectText());
    }

    @Test
    public void ProcessMissingTest() {
//        List<Revision> revisionsList = revisionProcessor.processRevisions();

    }
}
