package com.example.news.Controllers;

import com.example.news.Models.News;
import com.example.news.Service.NewsService;
import com.example.news.Service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }
}
