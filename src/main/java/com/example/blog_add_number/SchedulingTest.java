package com.example.blog_add_number;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.example.blog_add_number.Tool.*;


@Component
public class SchedulingTest {
    private int i = 0;

    // 具体时间间隔，60*1000也就是1分钟执行一次
    @Scheduled(fixedRate = 80 * 1000)
    void doSomethingWith() {
        String url = "https://blog.csdn.net/qq_41346910/article/details/109813201?spm=1001.2014.3001.5502";
        String body = doGet(url);
        Elements elements = parse(body);
        for (Element ele : elements) {
            String urlEle = ele.attr("href");
            System.out.println("urlEle:" + urlEle);
            doGet2(urlEle);
        }
        i++;
        System.out.println("第" + i + "次访问");
    }
}
