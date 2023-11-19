package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackerNews {

    private HackerNews() {
    }

    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/";
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final int SUCCESS_STATUS = 200;
    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("MultipleStringLiterals")
    public static long[] hackerNewsTopStories() {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI(TOP_STORIES_URL))
                .GET()
                .build();
            var response = HTTP_CLIENT
                .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == SUCCESS_STATUS) {
                String responseBody = response.body();
                String[] idsStringArray = responseBody.replaceAll("[\\[\\]]", "").split(",");
                int idsNumber = idsStringArray.length;
                long[] ids = new long[idsNumber];

                for (int idIndex = 0; idIndex < idsNumber; idIndex++) {
                    ids[idIndex] = Long.parseLong(idsStringArray[idIndex].trim());
                }

                return ids;
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            LOGGER.error("Error in client request: " + e.getMessage());
        }

        return new long[0];
    }

    public static String news(long id) {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI(ITEM_URL + id + ".json"))
                .GET()
                .build();
            var response = HTTP_CLIENT
                .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == SUCCESS_STATUS) {
                String responseBody = response.body();

                String regex = "\"title\":\"([^\"]*)\"";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(responseBody);
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            LOGGER.error("Error in client request: " + e.getMessage());
        }

        return "";
    }
}
