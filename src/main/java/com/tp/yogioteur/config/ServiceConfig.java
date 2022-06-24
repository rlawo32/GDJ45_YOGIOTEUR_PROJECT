package com.tp.yogioteur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tp.yogioteur.service.MemberService;
import com.tp.yogioteur.service.MemberServiceImpl;
import com.tp.yogioteur.service.RoomService;
import com.tp.yogioteur.service.RoomServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
	@Bean
	public RoomService roomService() {
		return new RoomServiceImpl();
	}
	
}
