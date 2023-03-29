package com.study.project.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponse<T> {

//	private StatusEnum status ; // 상태 코드
//	private String message; // 상태 메세지
//	private Object data; //클라이언트에게 전달해줄 데이터
//	
//	public ApiResponse() {
//		this.status = StatusEnum.BAD_REQUEST;
//		this.message = null;
//		this.data = null;
//
//	}
	
	private static final String RET_OK = "OK";
    private static final String RET_FAILED = "FAILED";

    private String result;
    private String reason;
    private T data;
    
    private ApiResponse(String result , String reason , T data){
        this.result = result;
        this.reason = reason;
        this.data = data;
    }
    
    /* 성공 */
    public static<T> ApiResponse<T> OK(T data){
        return new ApiResponse<T>(RET_OK ,  null , data);
    }
    
    /* 실패 */
    public static<T> ApiResponse<T> ERROR(String reason){
        return new ApiResponse<T>(RET_FAILED ,  reason , null);
    }
}
