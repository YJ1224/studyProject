package com.study.project.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.common.ResponseMsg;
import com.study.project.dto.BoardDto;
import com.study.project.dto.BoardListDto;
import com.study.project.dto.BoardReqDto;
import com.study.project.mapper.BoardMapper;
import com.study.project.vo.ApiResponse;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	//게시판 등록
	public ApiResponse<String> write(BoardReqDto boardReqDto) {
		
		//user_id, title, content는 필수파라미터 이므로 누락되면 error
		if(boardReqDto.getUser_id() == null || boardReqDto.getTitle() == null || boardReqDto.getContent() == null) {
			return ApiResponse.ERROR(ResponseMsg.VALIDATION_CHECK);
		}
		
		boardMapper.write(boardReqDto);
		return ApiResponse.OK(null);
	}
	
	//게시판 리스트 조회
	public ApiResponse<List<BoardListDto>> list(Map<String, Object> params){
		List<BoardListDto> boardList = boardMapper.boardList(params);
		
		return ApiResponse.OK(boardList);
	}
	
	//게시판 상세조회
	public ApiResponse<BoardDto> detail(int boardId) {
		BoardDto boardDetail = boardMapper.boardDetail(boardId);
		if(boardDetail == null) {
			return ApiResponse.ERROR(ResponseMsg.BOARD_NO_DETAIL);
		}
		return ApiResponse.OK(boardDetail);
	}
}
