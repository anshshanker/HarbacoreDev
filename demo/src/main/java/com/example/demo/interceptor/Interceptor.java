package com.example.demo.interceptor;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        if(request.getRequestURI().equals("/cart"))
        {
            Cookie cookie[]=request.getCookies();
            for(int i=0;i<cookie.length;i++)
            {
                if(cookie[i].getName().equals("Hbc"))
                {
                    String jwt=cookie[i].getValue();
                    if(jwt.equals(" "))return false;
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
