package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SampleJsonTest {
    private final String jsonResponse = loadJsonFromFile();
    SampleJsonTest() throws IOException {
    }
    @Test
    public void ExtractFirstUserTest() {
        List<String> users = JsonPath.read(jsonResponse, "$..revisions[*].user");
        assertFalse(users.isEmpty());
        System.out.println("First editor: " + users.get(0));
        assertNotNull(users.get(0));
    }
    @Test
    void ExtractTimestampsFromJsonTest() {
        List<String> timestamps = JsonPath.read(jsonResponse, "$..revisions[*].timestamp");
        assertEquals("2025-01-30T02:39:05Z", timestamps.get(0));
    }
    @Test
    void RedirectedArticleTest() {
        List<String> redirects = JsonPath.read(jsonResponse, "$..redirects[*].to");
        assertFalse(redirects.isEmpty());
    }
    @Test
    void MissingPageTest() {
        List<String> missing = JsonPath.read(jsonResponse, "$..missing");
        assertTrue(missing.isEmpty());
    }
    @Test
    void RevisionsUsersSizeTest() {
        List<String> revisionSize = JsonPath.read(jsonResponse, "$..user");
        assertEquals(4, revisionSize.size());
    }
    public String loadJsonFromFile() throws NullPointerException, IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/sample.json")));
    }

}
