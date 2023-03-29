package com.study.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.common.ResponseMsg;
import com.study.project.dto.userDto;
import com.study.project.mapper.userMapper;
import com.study.project.vo.ApiResponse;

@Service
public class userService {
	@Autowired
	private userMapper UserMapper;

	public ApiResponse<userDto> selectUserList() {
		userDto info = UserMapper.selectUserList();
		if(info == null) {
			return ApiResponse.ERROR(ResponseMsg.USER_NO_INFO);
		}
		return ApiResponse.OK(info);
	}
}
