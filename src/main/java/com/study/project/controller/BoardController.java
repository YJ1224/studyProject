package com.study.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.project.dto.BoardDto;
import com.study.project.dto.BoardListDto;
import com.study.project.dto.BoardReqDto;
import com.study.project.service.BoardService;
import com.study.project.vo.ApiResponse;
import com.study.project.dto.BoardPageingListDto;
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/* 게시판 작성 */
	@PostMapping("/wirte")
	public ApiResponse<String> boardWirte(@RequestBody BoardReqDto boardReqDto, @RequestHeader HttpHeaders header) {
		
		try {
			return boardService.write(boardReqDto,header.getFirst("Authorization"));
		}catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	}
	
	/* 게시판 리스트 조회 */
	@PostMapping("/list")
	public  ApiResponse<BoardPageingListDto> boardList(@RequestBody Map<String, Object> params, @RequestHeader HttpHeaders header) {
		
		try {
			return boardService.list(params,header.getFirst("Authorization"));
		}catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	}
	
	/* 게시판 상세 조회 */
	 @PostMapping("/detail")
	 public ApiResponse<BoardDto> boardDetail(@RequestBody Map<String, Object> params,@RequestHeader HttpHeaders header) {
		 try {
			 return boardService.detail(params,header.getFirst("Authorization"));
		 }catch (Exception e) {
			 return ApiResponse.ERROR(e.getMessage());
		}
	 }
	 
	 /* 게시판 수정 */
	 @PutMapping("/update")
	 public ApiResponse<String> boardUpdate(@RequestBody BoardReqDto boardReqDto,@RequestHeader HttpHeaders header){
		 try {
			 return boardService.update(boardReqDto,header.getFirst("Authorization"));
		 }catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	 }
	 
	 /* 게시판 삭제 */
	 @DeleteMapping("/delete")
	 public ApiResponse<String> boardDelete(@RequestBody Map<String,Object> params,@RequestHeader HttpHeaders header) {
		 try {
			 return boardService.delete(params,header.getFirst("Authorization"));
		 }catch (Exception e) {
			 return ApiResponse.ERROR(e.getMessage());
		}
	 }
	
}
