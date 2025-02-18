package edu.bsu.cs;
import edu.bsu.cs.utils.RevisionParser;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionParserTest {
    RevisionParser revisionParser = new RevisionParser();
    private final String jsonData =  new String(Files.readAllBytes(Paths.get("src/test/resources/sample.json")));
    public RevisionParserTest() throws IOException {
    }
    @Test
    public void ExtractFirstUserTest() {
        List<String> users = revisionParser.extractUsers(jsonData);
        assertFalse(users.isEmpty());
    }
    @Test
    void ExtractTimestampsFromJsonTest() {
        List<String> timestamps = revisionParser.extractTimestamps(jsonData);
        assertEquals("2025-01-30T02:39:05Z", timestamps.get(0));
    }
    @Test
    void RedirectedArticleTest() {
        List<String> redirects = revisionParser.extractRedirects(jsonData);
        assertFalse(redirects.isEmpty());
    }
    @Test
    void MissingPageTest() {
        List<String> missing = revisionParser.extractMissingPages(jsonData);
        assertTrue(missing.isEmpty());
    }
}
