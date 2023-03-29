package com.study.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.project.dto.BoardDto;
import com.study.project.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	public Map<String, String> write(Map<String, String> param) {
		Map<String, String> map = new HashMap<>();
		if(param.containsKey("user_id") == false || param.containsKey("title") == false || 
				param.containsKey("content") == false) {
			map.put("reulst","fail");
			map.put("message","필수 파라미터 누락");
			return map;
		}
		
		BoardDto boardDto = new BoardDto();
		boardDto.setUser_id(param.get("user_id"));
		boardDto.setTitle(param.get("title"));
		boardDto.setContent(param.get("content"));
		boardMapper.write(boardDto);
		map.put("reulst","OK");
		return map;
	}
}
