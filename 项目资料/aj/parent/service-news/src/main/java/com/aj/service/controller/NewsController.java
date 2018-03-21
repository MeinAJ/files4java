package com.aj.service.controller;

import com.aj.service.model.MNews;
import com.aj.service.service.NewsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class NewsController {

    @Resource(name = "newsService")
    private NewsService newsService;

    @SuppressWarnings("static-access")
    @RequestMapping(value = "/login", headers = "Accept=*/*", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getMOrderTracking(HttpServletRequest request) {
        MNews mNews = new MNews();
        mNews.setId(0L);
        return null;
    }
}
