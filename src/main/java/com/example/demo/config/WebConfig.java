package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.example.demo.Interceptor.TokenInterceptor;

@Configuration
public class WebConfig
{

	/**
	 * 配置拦截器
	 */
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/login", "/static/**");;
	}
}