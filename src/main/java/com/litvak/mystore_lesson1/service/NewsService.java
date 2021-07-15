package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.NewsItem;

import java.util.List;

public interface NewsService {
    NewsItem getRandomNewsItem();
    List<NewsItem> getAllNews();

}
