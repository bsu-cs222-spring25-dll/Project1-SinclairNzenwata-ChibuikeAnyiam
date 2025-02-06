package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class RevisionParserTest {

//    @BeforeEach
//    void setUp() throws IOException {
//        jsonResponse = new String(Files.readAllBytes(Paths.get("src/test/assets/sample.json")));
//    }

    @Test
    public void testExtractFirstUser() throws IOException {
        String jsonResponse = readSampleFileAsString();
        List<String> users = JsonPath.read(jsonResponse, "$..revisions[*].user");
        assertFalse(users.isEmpty());
        System.out.println("First editor: " + users.get(0));
        assertNotNull(users.get(0)); // Ensures the first user exists
    }

    private String readSampleFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("sample.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }catch (Exception error) {
            throw new RuntimeException(error);
        }
    }

//    private String hh() {
//        Object o = new JSONParser
//    }
}
