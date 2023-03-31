package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	private String name; //이름
	private String birthday; //생년월일
	private String phone; //핸드폰 번호
	private String gender; //성별
	
	public UserDto(String name, String birthday, String phone, String gender) {
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.gender = gender;
		
	}
	
	
}
