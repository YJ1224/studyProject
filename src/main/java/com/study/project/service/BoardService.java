package com.study.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.common.ResponseMsg;
import com.study.project.dto.BoardDto;
import com.study.project.dto.BoardListDto;
import com.study.project.dto.BoardPageingListDto;
import com.study.project.dto.BoardReqDto;
import com.study.project.mapper.BoardMapper;
import com.study.project.vo.ApiResponse;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private SecurityService securityService;

	// 게시판 등록
	public ApiResponse<String> write(BoardReqDto boardReqDto, String token) {
		String user_id = securityService.getSubject(token);

		if (user_id == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		} else {
			boardReqDto.setUser_id(user_id);
		}

		// title, content는 필수파라미터 이므로 누락되면 error
		if (boardReqDto.getTitle() == null || boardReqDto.getContent() == null) {
			return ApiResponse.ERROR(ResponseMsg.VALIDATION_CHECK);
		}

		boardMapper.write(boardReqDto);
		return ApiResponse.OK(null);
	}

	// 게시판 리스트 조회
	public ApiResponse<BoardPageingListDto> list(Map<String, Object> params,String token) {
		String user_id = securityService.getSubject(token);

		if (user_id == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		} else {
			params.put("user_id", user_id);
		}
		List<BoardListDto> boardList = boardMapper.boardList(params);
		int totalCount = boardMapper.boardTotalCount();
		return ApiResponse.OK(new BoardPageingListDto(totalCount, boardList));
	}

	// 게시판 상세조회
	public ApiResponse<BoardDto> detail(Map<String, Object> params,String token) {
		String user_id = securityService.getSubject(token);		
		if (user_id == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		} else {
			params.put("user_id", user_id);
		}
		
		BoardDto boardDetail = boardMapper.boardDetail(params);
		if (boardDetail == null) {
			return ApiResponse.ERROR(ResponseMsg.BOARD_NO_DETAIL);
		}
		return ApiResponse.OK(boardDetail);
	}

	// 게시판 수정
	public ApiResponse<String> update(BoardReqDto boardReqDto, String token) {

		String user_id = securityService.getSubject(token);

		if (user_id == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		} else {
			boardReqDto.setUser_id(user_id);
		}

		// board_id,title, content는 필수파라미터 이므로 누락되면 error
		if (boardReqDto.getTitle() == null || boardReqDto.getContent() == null || boardReqDto.getBoard_id() == null) {
			return ApiResponse.ERROR(ResponseMsg.VALIDATION_CHECK);
		}
		// 0: 업데이트 성공한 row 갯수
		int result = boardMapper.boardUpdate(boardReqDto);

		if (result == 0) {
			return ApiResponse.ERROR(ResponseMsg.BOARD_UPDATE_FAIL);
		} else {
			return ApiResponse.OK(null);
		}
	}

	// 게시판 삭제
	public ApiResponse<String> delete(Map<String, Object> params, String token) {

		String user_id = securityService.getSubject(token);

		if (user_id == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		} else {
			params.put("user_id",user_id);
		}

		int row = boardMapper.boardDelete(params);
		if (row == 0) {
			return ApiResponse.ERROR(ResponseMsg.BOARD_DELETE_FATL);
		} else {
			return ApiResponse.OK(null);
		}
//		if(boardDetail == null) {
//			return ApiResponse.ERROR(ResponseMsg.BOARD_NO_DETAIL);
//		}

	}

}
