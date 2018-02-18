package com.aj.service.news.controller;

import com.aj.service.news.api.INewsService;
import com.aj.service.news.model.AJResult;
import com.aj.service.news.model.News;
import com.aj.service.news.service.NewsServiceImpl;
import com.aj.service.news.utils.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@SuppressWarnings("static-access")
@RequestMapping("/news")
public class NewsController extends BaseController{

    //引入news服务
    @Resource(name = "newsServiceImpl")
    private NewsServiceImpl newsService;

    //添加新闻
    @RequestMapping(value = "/admin/add",headers = "Accept=*/*",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String addNews(HttpServletRequest request, @RequestBody String newsJson){
        String resultInfo = "";
        AJResult ajResult = new AJResult();
        try {
            News news = json.parseObject(newsJson, News.class);
            resultInfo = newsService.addNewsV100(json.toJSONString(news));
        }catch (Exception e){
            logger.error("addMNews,添加新闻失败,参数="+newsJson+",e="+e);
            e.printStackTrace();
            ajResult.setCode(ResultUtil.CODE_FAIL);
            ajResult.setMsg(ResultUtil.MSG_FAIL);
            return json.toJSONString(ajResult);
        }
        return resultInfo;
    }
}
