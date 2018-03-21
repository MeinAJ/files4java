package com.aj.service.news.service;

import com.aj.service.news.api.INewsService;
import com.aj.service.news.dao.impl.NewsDaoImpl;
import com.aj.service.news.model.AJResult;
import com.aj.service.news.model.News;
import com.aj.service.news.utils.ResultUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("newsServiceImpl")
@SuppressWarnings("static-access")
public class NewsServiceImpl extends BaseService implements INewsService{

    //引入新闻dao
    @Resource(name = "newsDaoImpl")
    private NewsDaoImpl newsDaoImpl;

    //添加新闻
    @Override
    public String addNewsV100(String newsJson) {
        AJResult ajResult = new AJResult();
        try {
            News news = json.parseObject(newsJson, News.class);
            news.setId(getLongID());
            newsDaoImpl.addNews(news);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("addNewsV100,添加新闻失败,参数="+newsJson+",e="+e);
            ajResult.setCode(ResultUtil.CODE_FAIL);
            ajResult.setMsg("添加新闻失败");
        }
        return json.toJSONString(ajResult);
    }
}
