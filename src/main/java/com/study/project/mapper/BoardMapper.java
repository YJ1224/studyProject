package com.study.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.study.project.dto.BoardDto;
import com.study.project.dto.BoardListDto;
import com.study.project.dto.BoardReqDto;

@Mapper
public interface BoardMapper {
	/* 게시판 등록 */
	void write(BoardReqDto boardReqDto); 
	
	/* 게시판 리스트 조회 */
	List<BoardListDto> boardList(Map<String, Object> params);
	/* 게시판 상세 조회 */
	BoardDto boardDetail(int boardId);
}
