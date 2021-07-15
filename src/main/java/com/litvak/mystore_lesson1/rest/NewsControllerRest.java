package com.litvak.mystore_lesson1.rest;


import com.litvak.mystore_lesson1.domain.NewsItem;
import com.litvak.mystore_lesson1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/randomNews")
public class NewsControllerRest {

    NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public NewsItem getRandomNews(){
        return newsService.getRandomNewsItem();
    }
}
