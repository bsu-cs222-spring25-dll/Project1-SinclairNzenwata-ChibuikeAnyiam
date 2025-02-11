package edu.bsu.cs;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.service.RevisionService;
import edu.bsu.cs.utils.RevisionBuilder;
import edu.bsu.cs.utils.RevisionParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionServiceTest {
    private final RevisionParser parser = new RevisionParser();
    private final RevisionBuilder builder = new RevisionBuilder();
    RevisionService service = new RevisionService(parser, builder);

    @Test
    public void getRevisionsTest() throws IOException {
        String jsonData = new String(Files.readAllBytes(Paths.get("src/test/resources/sample.json")));
        List<Revision> revisions = service.getRevisions(jsonData);
        assertEquals(5, revisions.size());
    }
}
