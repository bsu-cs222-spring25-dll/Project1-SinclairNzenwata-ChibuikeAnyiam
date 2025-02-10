package edu.bsu.cs.utils;
import com.jayway.jsonpath.JsonPath;
import java.util.List;

public class RevisionParser {
    public List<String> extractUsers(String jsonData) {
        return JsonPath.read(jsonData, "$..revisions[*].user");
    }

    public List<String> extractTimestamps(String jsonData){
        return JsonPath.read(jsonData, "$..revisions[*].timestamp");
    }

    public List<String> extractRedirects(String jsonData) {
        return JsonPath.read(jsonData, "$..redirects[*].to");
    }

    public List<String> extractMissingPages(String jsonData)  {
        return JsonPath.read(jsonData, "$..missing");
    }
}
