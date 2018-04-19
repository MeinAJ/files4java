package com.aj.common.utils;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * 部署到tomcat时需要此类作启动类
 * @author rex
 * @version 1.0
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(CommonUtilsApplication.class);
    }

}
