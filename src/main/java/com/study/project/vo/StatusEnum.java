package com.study.project.vo;

public enum StatusEnum {
	OK("OK","OK"),
	BAD_REQUEST("FAIL", "필수 파라미터가 누락되었습니다."),
	NOT_FOUND("FAIL","요청하는 정보가 없습니다."),
	SEVER_ERROR("ERROR", "서버 에러입니다.");
	
	String code;
	String message;
	
	StatusEnum(String code,String message) {
		this.code = code;
		this.message = message;
		
	}
}
