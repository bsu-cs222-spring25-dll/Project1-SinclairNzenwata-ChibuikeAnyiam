package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SampleJsonTest {
    private final String jsonResponse = loadJsonFromFile();
    SampleJsonTest() throws IOException {
    }
    @Test
    public void ExtractFirstUserTest() throws IOException {

        List<String> users = JsonPath.read(jsonResponse, "$..revisions[*].user");
        assertFalse(users.isEmpty());
        System.out.println("First editor: " + users.get(0));
        assertNotNull(users.get(0));
    }
    @Test
    void ExtractTimestampsFromJsonTest() {
        List<String> timestamps = JsonPath.read(jsonResponse, "$..revisions[*].timestamp");
        assertEquals(4, timestamps.size());
        assertEquals("2025-01-30T02:39:05Z", timestamps.get(0));
        assertEquals("2025-01-12T11:36:41Z", timestamps.get(1));
        assertEquals("2024-10-28T08:31:58Z", timestamps.get(2));
        assertEquals("2024-10-24T13:10:57Z", timestamps.get(3));
    }
    @Test
    void RedirectedArticleTest() {
        List<String> redirects = JsonPath.read(jsonResponse, "$..redirects[*].to");
        assertFalse(redirects.isEmpty());
        assertEquals("General officer", redirects.get(0));
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
