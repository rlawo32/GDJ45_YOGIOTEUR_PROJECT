package com.tp.yogioteur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileUploadConfig {

	// 파일 첨부할 때 필요한 Bean
	//파일 업로드용 bean 을 만들기 위해 만든 클래스
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSizePerFile(1024 * 1024 * 10);  // 하나당 최대 10MB (생략하면 -1 사용, 제한 없다는 뜻)
		multipartResolver.setMaxUploadSize(1024 * 1024 * 50);         // 전체 최대 50MB (생략하면 -1 사용, 제한 없다는 뜻)
		multipartResolver.setMaxUploadSizePerFile(1024 * 1024 * 10); // 하나당 최대 10MB(생략하면 -1 사용, 제한 없다는 뜻)
		multipartResolver.setMaxUploadSize(1024 * 1024 * 50); 		// 전체 최대 50MB
		return multipartResolver;
	}
	
}
