package edu.bsu.cs.utils;

import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs.model.RevisionProcessor;
import edu.bsu.cs.model.Revision;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RevisionParser {
    private final String jsonFilePath;
    private final RevisionProcessor revisionProcessor;

    public RevisionParser(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        this.revisionProcessor = new RevisionProcessor();
    }

//    public List<Revision> parseFirstUser() throws IOException {
//        String jsonResponse = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
//        List<String> users = JsonPath.read(jsonResponse, "$..revisions[*].user");
////        List<String> users = JsonPath.read(jsonResponse, "$..revisions[*].user");
//        List<String> timestamps = JsonPath.read(jsonResponse, "$..revisions[*].timestamp");
//        List<String> to = JsonPath.read(jsonResponse, "$..redirects[*].to");
//        List<String> missing = JsonPath.read(jsonResponse, "$..missing");
//        List<Revision> revisionList = new ArrayList<>();
//        revisionList.add(new Revision())
//        return users.isEmpty() ? null : users.get(0);
//    }

    public List<Revision> parseRevisions() throws IOException {
        String jsonResponse = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        List<String> users = JsonPath.read(jsonResponse, "$..revisions[*].user");
        List<String> timestamps = JsonPath.read(jsonResponse, "$..revisions[*].timestamp");
        List<String> redirects = JsonPath.read(jsonResponse, "$..redirects[*].to");
        List<String> missingPages = JsonPath.read(jsonResponse, "$..missing");

        // Delegate processing to the new class
        return revisionProcessor.processRevisions(users, timestamps, redirects, missingPages);

    }
}
