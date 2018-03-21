package com.aj.service.news.dao.impl;

import com.aj.service.news.dao.BaseDao;
import com.aj.service.news.dao.INewsDao;
import com.aj.service.news.model.News;
import org.springframework.stereotype.Component;


@SuppressWarnings("static-access")
@Component(value = "newsDaoImpl")
public class NewsDaoImpl extends BaseDao implements INewsDao{

    //添加新闻
    @Override
    public boolean addNews(News news) {
        return this.ajDbSqlSessionTemplate.insert("NewsMapper.addNews",news) > 0;
    }

}
