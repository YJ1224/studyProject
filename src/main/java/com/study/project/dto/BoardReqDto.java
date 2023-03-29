package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardReqDto {
	private String user_id; //작성자 아이디
	private String title; //게시판 제목
	private String content; //게시판 내용

	public BoardReqDto(String user_id, String title, String content) {
		this.user_id = user_id;
		this.title = title;
		this.content = content;
	}
}
