package com.study.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.project.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/* 게시판 작성 */
	@PostMapping("/wirte")
	public Map<String, String> wirte(@RequestBody Map<String, String> param) {
		Map<String, String> map = new HashMap<>();
		
		try {
			return boardService.write(param);
		}catch (Exception e) {
			System.out.println(e);
			map.put("result","error");
			return map;
		}
		
	}
	
}
