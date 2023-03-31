package com.study.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.project.dto.JwtToken;
import com.study.project.dto.UserDto;
import com.study.project.service.UserService;
import com.study.project.vo.ApiResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ApiResponse<JwtToken> userLogin(@RequestBody Map<String, Object> params) {
		try {
			return userService.userLogin(params);
		} catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	}
	
	@GetMapping("/info")
	public ApiResponse<UserDto> userInfo(@RequestHeader HttpHeaders header){
		try {
			return userService.userInfo(header.getFirst("Authorization"));
		}catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
	}
}
