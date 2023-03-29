package com.study.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
	private int board_id; //게시판 번호
	private String user_id; //작성자 아이디
	private String title; //게시판 제목
	private String content; //게시판 내용
	private String create_date; //게시판 등록일자
	private String update_date; //게시판 수정일자
	private String delete_date; //게시판 삭제일자

	public BoardDto(int board_id, String user_id, String title, String content, String create_date, String update_date,
			String delete_date) {
		this.board_id = board_id;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.create_date = create_date;
		this.update_date = update_date;
		this.delete_date = delete_date;
	}
}
