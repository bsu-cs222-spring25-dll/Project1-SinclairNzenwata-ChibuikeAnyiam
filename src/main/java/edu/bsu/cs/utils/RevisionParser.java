package edu.bsu.cs.utils;

import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs.model.Revision;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RevisionParser {
    private final String jsonFilePath;
    public RevisionParser(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    private String readJsonFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(jsonFilePath)));
    }

    public List<String> extractUsers() throws IOException {
        return JsonPath.read(readJsonFile(), "$..revisions[*].user");
    }

    public List<String> extractTimestamps() throws IOException {
        return JsonPath.read(readJsonFile(), "$..revisions[*].timestamp");
    }

    public List<String> extractRedirects() throws IOException {
        return JsonPath.read(readJsonFile(), "$..redirects[*].to");
    }

    public List<String> extractMissingPages() throws IOException {
        return JsonPath.read(readJsonFile(), "$..missing");
    }
}
