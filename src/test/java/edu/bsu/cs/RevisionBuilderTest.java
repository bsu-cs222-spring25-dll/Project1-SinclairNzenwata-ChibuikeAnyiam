package edu.bsu.cs;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionBuilder;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RevisionBuilderTest {
    final RevisionBuilder revisionBuilder = new RevisionBuilder();

    @Test
    public void buildRevisionsRedirectTest() {
        List<Revision> revisionsList = revisionBuilder.buildRevisions(Collections.emptyList(), Collections.emptyList(), List.of("Sinclair Stark"), Collections.emptyList());
        assertEquals("Sinclair Stark", revisionsList.get(0).getRedirectText());
    }

    @Test
    public void buildRevisionsMissingTest() {
        List<Revision> revisionsList = revisionBuilder.buildRevisions(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), List.of(""));
        assertTrue(revisionsList.get(0).getIsMissing());
    }
}
