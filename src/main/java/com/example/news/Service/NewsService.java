package com.example.news.Service;

import com.example.news.Models.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    public void save(News news);
    public boolean isExist(String newsTitle);
    public List<News> getAllNews();
}
