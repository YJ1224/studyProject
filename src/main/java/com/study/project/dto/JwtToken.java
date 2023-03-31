package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtToken {
	private String ACCESS_TOKEN;
	private String REFRESH_TOKEN;
	
	
	public JwtToken (String ACCESS_TOKEN,String REFRESH_TOKEN) {
		this.ACCESS_TOKEN = ACCESS_TOKEN;
		this.REFRESH_TOKEN = REFRESH_TOKEN;
		
	}
	
	
}
