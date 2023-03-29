package com.study.project.provider;

import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.project.service.userService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	private String secrekey = "aasjjkjaskjdl1k2naskjkdakj34c8sa"; //jwt 시크릿 키(임ㅅ)
			
	private long tokenValidTime = 180 * 60 * 1000L; //유효시간 3시간
	
	@Autowired
	private userService UserService;
	
	@PostConstruct //객체 초기화 
	protected void init() {
		secrekey = Base64.getEncoder().encodeToString(secrekey.getBytes());
	}
	
	//jwt토큰 생성
	
	
	
}
