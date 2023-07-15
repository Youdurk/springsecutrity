package com.congwu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptorconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/api/ss/**","/api/user/**");
    }
    @Bean
    public  JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }
}
