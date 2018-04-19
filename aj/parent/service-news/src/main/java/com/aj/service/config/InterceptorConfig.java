package com.aj.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * this is a tesy
 *
 * @author Administrator
 * @create 2018-02-20 22:15
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * TODO 添加拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截请求，检测用户是否登录
        registry.addInterceptor(new ProcessInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
