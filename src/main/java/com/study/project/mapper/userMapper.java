package com.study.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.study.project.dto.BoardDto;
import com.study.project.dto.BoardListDto;
import com.study.project.dto.BoardReqDto;
import com.study.project.dto.UserDto;

@Mapper
public interface UserMapper {
	//유저 로그인
	Map<String, Object> userLogin(Map<String, Object>  params);
	
	//로그인한 유저 정보
	UserDto userInfo(String user_id);

}
