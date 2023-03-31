package com.study.project.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardListDto {
	private int board_id; //게시글 번호
	private String name; //작성자 이름
	private String title; //게시판 제목
	private String create_date; //게시판 등록일자
	private String use_YN; //내가 작성한 게시물인가
	public BoardListDto(int board_id,String name, String title,String create_date, String use_YN) {
		this.board_id = board_id;
		this.name = name;
		this.title = title;
		this.create_date = create_date;
		this.use_YN = use_YN;
	}
}
