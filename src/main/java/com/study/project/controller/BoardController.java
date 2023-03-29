package com.study.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.project.dto.BoardDto;
import com.study.project.dto.BoardListDto;
import com.study.project.dto.BoardReqDto;
import com.study.project.service.BoardService;
import com.study.project.vo.ApiResponse;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/* 게시판 작성 */
	@PostMapping("/wirte")
	public ApiResponse<String> wirte(@RequestBody BoardReqDto boardReqDto) {
		
		try {
			return boardService.write(boardReqDto);
		}catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	}
	
	/* 게시판 리스트 조회 */
	@PostMapping("/list")
	public  ApiResponse<List<BoardListDto>> boardList(@RequestBody Map<String, Object> params) {
		
		try {
			return boardService.list(params);
		}catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	}
	
	/* 게시판 상세 조회 */
	 @GetMapping("/detail/{boardId}")
	 public ApiResponse<BoardDto> test(@PathVariable(name = "boardId") int boardId) {
		 try {
			 return boardService.detail(boardId);
		 }catch (Exception e) {
			 return ApiResponse.ERROR(e.getMessage());
		}
	 }
	
}
