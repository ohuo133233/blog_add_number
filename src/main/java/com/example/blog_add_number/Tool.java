package com.example.blog_add_number;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 1.创建HttpUtil类来写一个简单的http请求方法，访问地址
 */
public class Tool {
    // 获取页面数据
    // 这个是获取博客的列表的url
    public static String doGet(String url) {
        String body = "";
        // 连接
        HttpClient httpClient = HttpClientBuilder.create().build();
        //  HttpClientParams.setCookiePolicy(httpClient.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        // 请求
        HttpGet httpGet = new HttpGet(url);
        // 设置浏览器代理
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        try {
            // 响应
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity, Consts.UTF_8);
            // System.out.println("body:"+body);
            // parse(body);
            // 释放连接
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    // 获取页面数据
    // 这个跟前面的doGet是一样的，只是输出内容过多，debug测试加的
    // 我把他加进来容易修改点，若不需要可以删掉，并在第三步将doget2（）改为doget（）
    public static String doGet2(String url) {
        String body = "";
        // 连接
        HttpClient httpClient = HttpClientBuilder.create().build();
        // HttpClientParams.setCookiePolicy(httpClient.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        // 请求
        HttpGet httpGet = new HttpGet(url);
        // 设置浏览器代理
        // httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        // 设置头部信息进行模拟登录（添加登录后的Cookie）
        httpGet.setHeader("Accept", "");
        httpGet.setHeader("Accept-Encoding", "");
        httpGet.setHeader("Accept-Language", "");
        httpGet.setHeader("Cookie", "");
        httpGet.setHeader("User-Agent", "");
        try {
            //响应
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity, Consts.UTF_8);
            // System.out.println("body:"+body);
            // parse(body);
            // 释放连接
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    // 获取a标签
    public static Elements parse(String html) {
        // 解析html获取Document
        Document doc = Jsoup.parse(html);
        // 获取spu
        Elements eles = doc.select("h4>a");
        return eles;
    }
}
