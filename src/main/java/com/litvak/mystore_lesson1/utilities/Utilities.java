package com.litvak.mystore_lesson1.utilities;

import com.litvak.mystore_lesson1.domain.NewsItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Component
public class Utilities {
    private static final String API_KEY = "9c9291df43684255a253c017d36561a3";
    private static final String newsQuery = "https://newsapi.org/v2/top-headlines?country=ru&apiKey=" + API_KEY;

    public static List<NewsItem> getNews() throws IOException {
        URL hh = new URL(newsQuery);
        URLConnection connection = hh.openConnection();
        String redirect = connection.getHeaderField("Location");
        if (redirect != null) {
            connection = new URL(redirect).openConnection();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        int flag = sb.indexOf("[");
        sb.delete(0, flag);
        sb.deleteCharAt(sb.length() - 1);
        JSONArray jsonArr = new JSONArray(sb.toString());
        List<NewsItem> news = new ArrayList<>();
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            NewsItem newsItem = new NewsItem();
            newsItem.setTitle(jsonObj.getString("title"));
            newsItem.setDescription(jsonObj.getString("description"));
            newsItem.setUrl(jsonObj.getString("url"));
            newsItem.setUrlToImage(jsonObj.getString("urlToImage"));
            news.add(newsItem);
        }
        return news;
    }
}
