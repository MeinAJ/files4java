package com.foundao.es.service;

import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.junit.Test;
import static java.lang.System.currentTimeMillis;

@SuppressWarnings("static-access")
public class TestService {

    @Test
    public void search(){

        QueryBuilder queryBuilder=QueryBuilders.termsQuery("title","习近平");
        FunctionScoreQueryBuilder query = QueryBuilders.functionScoreQuery(queryBuilder,
                ScoreFunctionBuilders.fieldValueFactorFunction("time_stamp").factor((1000/ ((float)currentTimeMillis())))).boostMode(CombineFunction.MULTIPLY);
        query.query();
        System.out.println("查询完成");
    }


}
