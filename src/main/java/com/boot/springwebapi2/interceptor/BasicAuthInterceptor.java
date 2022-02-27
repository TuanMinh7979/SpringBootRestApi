package com.boot.springwebapi2.interceptor;

import com.boot.springwebapi2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class BasicAuthInterceptor implements HandlerInterceptor {
    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String key1 = request.getHeader("key1");
//        System.out.println("key 1 la: " + key1);
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            String hash = authorization.replace("Basic ", "");

            byte[] bytes = Base64.getDecoder().decode(hash);
            String usernameandpass = new String(bytes);
            String[] uap = usernameandpass.split(":");
            String username = uap[0];
            String password = uap[1];
//            System.out.println("username: "+username+" password: "+password);
            if (accountService.check(username, password)) return true;

        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;


    }
}
