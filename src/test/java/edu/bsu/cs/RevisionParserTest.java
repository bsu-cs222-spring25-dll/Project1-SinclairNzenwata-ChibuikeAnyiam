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
        assertEquals(4, timestamps.size());
        assertEquals("2025-01-30T02:39:05Z", timestamps.get(0));
        assertEquals("2025-01-12T11:36:41Z", timestamps.get(1));
        assertEquals("2024-10-28T08:31:58Z", timestamps.get(2));
        assertEquals("2024-10-24T13:10:57Z", timestamps.get(3));
    }
    @Test
    void RedirectedArticleTest() throws IOException {
        List<String> redirects = revisionParser.extractRedirects();
        assertFalse(redirects.isEmpty());
        assertEquals("General officer", redirects.get(0));
    }
    @Test
    void MissingPageTest() throws IOException {
        List<String> missing = revisionParser.extractMissingPages();
        assertTrue(missing.isEmpty());
    }


}
