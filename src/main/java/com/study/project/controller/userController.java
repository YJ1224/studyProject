package com.study.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.project.dto.userDto;
import com.study.project.service.userService;
import com.study.project.vo.ApiResponse;
import com.study.project.vo.StatusEnum;


@RestController
@RequestMapping(value = "/user")
public class userController {
	@Autowired
	private userService UserService;

	@GetMapping("/info")
	public ApiResponse<userDto> test(){
        try {
        	return UserService.selectUserList();
        }catch (Exception e) {
			return ApiResponse.ERROR(e.getMessage());
		}
        
	}
	
	//유저 로그
//	@PostMapping("/login")
//	public String login(@ResponseBody Map<String, Object> user) {
//		
//	}
}
