package edu.bsu.cs;

import edu.bsu.cs.service.WikipediaApiService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaApiServiceTest {
    WikipediaApiService apiService = new WikipediaApiService();

    @Test
    // this test will fail if a new user updates the article on wikipedia live site because it was compared
    // with data gotten from the response at the time of development.
    public void fetchRevisionsTest() throws IOException, InterruptedException {
        String expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/sample_response.json")));
        String actualJson = apiService.fetchWikipediaData("iran");
        assertEquals(expectedJson, actualJson);
    }
}
