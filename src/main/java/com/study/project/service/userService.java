package com.study.project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.common.ResponseMsg;
import com.study.project.dto.JwtToken;
import com.study.project.dto.UserDto;
import com.study.project.mapper.UserMapper;
import com.study.project.vo.ApiResponse;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SecurityService securityService;
	
	//token 값으로 아이디 찾기
	public String getId(JwtToken jwtToken) {
		return null;
	}
	//로그인
	public ApiResponse<JwtToken> userLogin(Map<String,Object> params){
		
		//아이디 비밀번호 둘중에 하나라도 누락될 시 
		if(params.containsKey("user_id") == false || params.containsKey("password") == false) {
			return ApiResponse.ERROR(ResponseMsg.VALIDATION_CHECK);
		}
		
		Map<String, Object> userLogin = userMapper.userLogin(params);

		if(userLogin == null) { //회원 정보 없음
			return ApiResponse.ERROR(ResponseMsg.USER_LOGIN_FAIL);
		}else {
			String token = securityService.createToken((String) params.get("user_id"));
			return ApiResponse.OK(new JwtToken(token,token));
		}
		
	}
	
	//로그인한 회원 정보
	public ApiResponse<UserDto> userInfo(String token){
		String user_id = securityService.getSubject(token);
		
		if (user_id == null) return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		
		UserDto userDto = userMapper.userInfo(user_id);
		
		if(userDto == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO); 
		}
		return ApiResponse.OK(userDto);
	}
	
}
