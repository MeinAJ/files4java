package com.aj.service.controller;

import com.aj.service.model.AJResult;
import com.aj.service.model.MNews;
import com.aj.service.service.NewsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/news")
public class NewsController extends BaseController{

    @Resource(name = "newsService")
    private NewsService newsService;

    @SuppressWarnings("static-access")
    @RequestMapping(value = "/admin/add", headers = "Accept=*/*", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addMNews(HttpServletRequest request, @RequestBody String mNewsInfo) {
        String resultInfo = "";
        AJResult ajResult = new AJResult();
        try {
            MNews mNews = json.parseObject(mNewsInfo, MNews.class);
            newsService.addMNews();
        }catch(Exception e){
            e.printStackTrace();
            logger.error("addMNews,添加新闻出错,参数="+mNewsInfo+",e="+e);
            ajResult.setCode("400");
            ajResult.setMsg("添加新闻出错");
            return json.toJSONString(ajResult);
        }
        return resultInfo;
    }
}
