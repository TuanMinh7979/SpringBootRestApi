package com.boot.springwebapi2.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class Log1Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("date: "+sf.format(new Date()));

        return true;
    }
}
