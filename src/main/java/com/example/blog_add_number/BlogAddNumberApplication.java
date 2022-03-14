package com.example.blog_add_number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开
@EnableScheduling
@SpringBootApplication
public class BlogAddNumberApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogAddNumberApplication.class, args);
    }

}
