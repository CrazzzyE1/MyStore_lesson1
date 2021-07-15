package com.litvak.mystore_lesson1.controllers;
import com.litvak.mystore_lesson1.domain.NewsItem;
import com.litvak.mystore_lesson1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public String getAllNews(Model model){
        List<NewsItem> news = newsService.getAllNews();
        model.addAttribute("news", news);
        return "news";
    }

    @GetMapping("/random")
    public String getRandomNews(Model model){
        List<NewsItem> news = new ArrayList<>();
        news.add(newsService.getRandomNewsItem());
        model.addAttribute("news", news);
        return "news";
    }
}
