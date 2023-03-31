package com.study.project.common;

public class ResponseMsg {
	public static String VALIDATION_CHECK = "필수 파라미터가 누락되었습니다.";
	public static String USER_NO_INFO = "해당 유저의 정보가 없습니다.";
	public static String BOARD_NO_DETAIL = "해당 게시물이 존재하지 않습니다.";
	public static String BOARD_UPDATE_FAIL = "게시물 수정이 실패하였습니다.";
	public static String BOARD_DELETE_FATL = "게시물 삭제가 실패하였습니다.";

	public static String USER_LOGIN_FAIL = "아이디 및 비밀번호가 틀렸습니다.";
	public static String JWT_TOKEN_EXPIRATION = "토큰이 만료 되었습니다.";
}
