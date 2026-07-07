package com.shanzhu.st.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 允许跨域访问
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 可限制哪个请求可以通过跨域
                .allowedHeaders("*")  // 可限制固定请求头可以通过跨域
                .allowedMethods("*") // 可限制固定methods可以通过跨域
                // 添加多个允许的源
                .allowedOrigins(
                        "http://localhost:8081",           // 本地开发
                        "http://localhost:8080",           // 本地后端
                        "https://9d3914e.r12.vip.cpolar.cn",  // 前端公网地址
                        "http://9d3914e.r12.vip.cpolar.cn",   // 前端公网地址(HTTP)
                        "https://28de0a9.r16.cpolar.top",     // 后端公网地址
                        "http://28de0a9.r16.cpolar.top"       // 后端公网地址(HTTP)
                )
                .allowCredentials(true) // 是否允许发送cookie
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }
}