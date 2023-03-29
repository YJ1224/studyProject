package com.study.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.project.dto.BoardDto;
import com.study.project.dto.userDto;

@Mapper
public interface BoardMapper {
	/* 게시판 등록 */
	void write(BoardDto boardDto); 
}
