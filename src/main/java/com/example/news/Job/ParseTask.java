package com.example.news.Job;

import com.example.news.Models.News;
import com.example.news.Repositories.NewsRepository;
import com.example.news.Service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseNewNews() throws IOException {
        String url = "https://news.ycombinator.com/";

        Document doc = Jsoup.connect(url).userAgent("Ya").timeout(5000)
                .referrer("https://ya.ru/").get();

        Elements news =  doc.getElementsByClass("titleline");
        for (Element el: news){
            String title  = el.select("a").first().text();
            String link = el.select("a").attr("href");
            if (!newsService.isExist(title)){
                News obj = new News();
                obj.setLink(link);
                obj.setTitle(title);
                newsService.save(obj);
            }
        }

    }
}
