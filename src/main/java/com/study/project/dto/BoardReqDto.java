package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardReqDto {
	private String user_id; //유저 아이디
	private String board_id; //게시판 번호
	private String title; //게시판 제목
	private String content; //게시판 내용

	public BoardReqDto(String user_id,String board_id,String title, String content) {
		this.user_id = user_id;
		this.board_id = board_id;
		this.title = title;
		this.content = content;
	}
}
