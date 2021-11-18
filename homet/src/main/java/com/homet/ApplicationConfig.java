package com.homet;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ApplicationConfig implements WebMvcConfigurer {
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		List<String> patterns= Arrays.asList("/community/*","/community/*");
//		List<String> excludes=Arrays.asList("/community/list","/community/detail","/customer/join");
//		registry.addInterceptor(new LoginInterceptor())
//		.addPathPatterns(patterns).excludePathPatterns(excludes);
//	}
}
