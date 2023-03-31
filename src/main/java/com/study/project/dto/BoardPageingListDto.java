package com.study.project.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class BoardPageingListDto {
	@Getter
	@NoArgsConstructor
	private class BoardPageingDto{
		private int board_id; //게시글 번호
		private String name; //작성자 이름
		private String title; //게시판 제목
		private String create_date; //게시판 등록일자
		private String use_YN; //내가 작성한 글인가에 따라 수정, 삭제 해야함
	
		public BoardPageingDto(BoardListDto blDto) {
			this.board_id = blDto.getBoard_id();
			this.name = blDto.getName();
			this.title = blDto.getTitle();
			this.create_date = blDto.getCreate_date();
			this.use_YN  = blDto.getUse_YN();
		}
	}
	
	private int totalCount; //총 게시글 수
	private List<BoardPageingDto> boardList = new ArrayList<BoardPageingDto>(); //DB에서 가져온 DTO LIST boardList에 for문으로 담음
	
	public BoardPageingListDto(int totalCount, List<BoardListDto> bpDto) {
		this.totalCount = totalCount;
		
		for(int i=0; i<bpDto.size(); i++) {
			boardList.add(new BoardPageingDto(bpDto.get(i)));
		}
		
	}
}
