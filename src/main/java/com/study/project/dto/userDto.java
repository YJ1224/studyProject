package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class userDto {
	private int seq;
	private String user_id;
	private String password;
	private String name;
	private String birthday;
	private String phone;
	private String gender;
	
	public userDto(int seq,String user_id, String password, String name, String birthday, String phone, String gender) {
		this.seq = seq;
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.gender = gender;
		
	}
}
