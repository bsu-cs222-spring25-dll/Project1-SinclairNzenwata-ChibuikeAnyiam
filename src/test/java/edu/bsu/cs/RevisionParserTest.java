package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs.utils.RevisionParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionParserTest {
    RevisionParser revisionParser = new RevisionParser("src/test/resources/sample.json");
    @Test
    public void ExtractFirstUserTest() throws IOException {
        List<String> users = revisionParser.extractUsers();
        assertFalse(users.isEmpty());
        System.out.println("First editor: " + users.get(0));
        assertNotNull(users.get(0));
    }
    @Test
    void ExtractTimestampsFromJsonTest() throws IOException {
        List<String> timestamps = revisionParser.extractTimestamps();
        assertEquals("2025-01-30T02:39:05Z", timestamps.get(0));
    }
    @Test
    void RedirectedArticleTest() throws IOException {
        List<String> redirects = revisionParser.extractRedirects();
        assertFalse(redirects.isEmpty());
    }
    @Test
    void MissingPageTest() throws IOException {
        List<String> missing = revisionParser.extractMissingPages();
        assertTrue(missing.isEmpty());
    }


}
