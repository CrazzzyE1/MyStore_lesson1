package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.NewsItem;
import com.litvak.mystore_lesson1.utilities.Utilities;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private List<NewsItem> news = Utilities.getNews();

    public NewsServiceImpl() throws IOException {
    }

    @Override
    public NewsItem getRandomNewsItem() {
        return news.get((int) (Math.random() * (news.size())));
    }

    @Override
    public List<NewsItem> getAllNews() {
        return news;
    }
}
