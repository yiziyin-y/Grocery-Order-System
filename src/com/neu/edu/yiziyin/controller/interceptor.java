package com.neu.edu.yiziyin.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Enumeration<String> paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements()){
                String key = paramNames.nextElement();
                String val = request.getParameter(key);

                if(check(val)){
                    request.setAttribute("unsafe_request", "true");
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    private boolean check(String value) {
        if (value != null) {
            return (value.matches("<script>(.*?)</script>") || value.matches("\"<script(.*?)>\""));
        }
        return false;
    }
}
