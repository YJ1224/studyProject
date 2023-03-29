package com.study.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.dto.userDto;
import com.study.project.mapper.userMapper;

@Service
public class userService {
	@Autowired
	private userMapper UserMapper;

	public List<userDto> selectUserList() {
		List<userDto> list = UserMapper.selectUserList();
		return list;
	}
}
