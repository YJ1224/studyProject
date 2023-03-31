package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
	private String name; //작성자 이름
	private String title; //게시판 제목
	private String content; //게시판 내용
	private String create_date; //게시판 등록일자
	private String use_YN;

	public BoardDto(String name, String title, String content, String create_date,String use_YN) {
		this.name = name;
		this.title = title;
		this.content = content;
		this.create_date = create_date;
		this.use_YN = use_YN;
	}
}
