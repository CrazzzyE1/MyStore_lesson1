package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.NewsItem;
import com.litvak.mystore_lesson1.utilities.Utilities;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private List<NewsItem> news;

    public NewsServiceImpl() throws IOException {
    }

    @Override
    public NewsItem getRandomNewsItem() {
        try {
            news = Utilities.getNews();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return news.get((int) (Math.random() * (news.size())));
    }

    @Override
    public List<NewsItem> getAllNews() {
        try {
            news = Utilities.getNews();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return news;
    }
}
