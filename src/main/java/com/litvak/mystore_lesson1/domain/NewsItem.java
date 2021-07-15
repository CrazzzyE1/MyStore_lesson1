package com.litvak.mystore_lesson1.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NewsItem {

    private String title;
    private String description;
    private String url;
    private String urlToImage;

}
