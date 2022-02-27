package com.boot.springwebapi2.conf;

import com.boot.springwebapi2.interceptor.BasicAuthInterceptor;
import com.boot.springwebapi2.interceptor.Log1Interceptor;
import com.boot.springwebapi2.interceptor.Log2Interceptor;
import com.boot.springwebapi2.interceptor.Log3Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConf implements WebMvcConfigurer {
    @Autowired
    private Log1Interceptor log1Interceptor;
    @Autowired
    private Log2Interceptor log2Interceptor;

    @Autowired
    private Log3Interceptor log3Interceptor;

    @Autowired
    private BasicAuthInterceptor basicAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(log1Interceptor);
        registry.addInterceptor(log2Interceptor);
        registry.addInterceptor(log3Interceptor);
        registry.addInterceptor(basicAuthInterceptor);
    }
}
