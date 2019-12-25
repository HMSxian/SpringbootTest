package com.hp.config;

import com.hp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginInt(){
        return  new LoginInterceptor();
    }
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInt()).addPathPatterns("/**");
    }
}
