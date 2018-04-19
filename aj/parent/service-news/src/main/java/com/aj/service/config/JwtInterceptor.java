package com.aj.service.config;

import com.aj.service.service.JwtService;
import com.aj.service.utils.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this is a interceptor
 *
 * @author Administrator
 * @create 2018-02-19 21:10
 */

public class JwtInterceptor implements HandlerInterceptor {

    @Resource(name = "jwtService")
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = StringUtils.validString(request.getHeader("Authorization"));
        //解析jwt,取出id
        String userId = jwtService.authJwt(jwt);
        String addBy = "";
        request.setAttribute("addBy",addBy);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
