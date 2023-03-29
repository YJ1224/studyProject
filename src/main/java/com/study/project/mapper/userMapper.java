package com.study.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.project.dto.userDto;

@Mapper
public interface userMapper {
	/* 테스트용도 회원정보 조회 */
	userDto selectUserList();
}
