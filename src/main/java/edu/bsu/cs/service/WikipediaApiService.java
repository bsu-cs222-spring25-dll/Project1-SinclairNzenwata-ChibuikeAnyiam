package edu.bsu.cs.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WikipediaApiService {
    private static final String BASE_URL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=21&redirects";
    private static final String USER_AGENT = "Revision Reporter/0.1 (sinclair.nzenwata@bsu.edu)";

    public String fetchWikipediaData(String article) throws IOException, InterruptedException {
        String encodedArticle = URLEncoder.encode(article, StandardCharsets.UTF_8);
        String url = String.format(BASE_URL, encodedArticle).replace("|", "%7C");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .setHeader("User-Agent", USER_AGENT)
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("Error: Wikipedia API returned HTTP status " + response.statusCode());
        }
        return response.body();
    }
}
