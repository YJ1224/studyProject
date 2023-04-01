package com.study.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {
	/* part 붙을 시 메뉴 미표시, jsp 붙을 시 메뉴 표시*/
	//로그인
	@GetMapping("/login")
	public String Login() {
		return "login.part";
	}
	
	//게시판 목록
	@GetMapping("/main")
	public String Main() {
		return "main.jsp";
	}
	
	//게시판 상세
	@PostMapping("/boardDetail")
	public String BoardDetail() {
		return "boardDetail.jsp";
	}
	
	//게시판 등록
	@GetMapping("/boardWrite")
	public String BoardWrite() {
		return "boardWrite.jsp";
	}
	
	//게시판 수정
	@PostMapping("/boardUpdate")
	public String BoardUpdate() {
		return "boardUpdate.jsp";
	}
	
	//게시판 삭제모달
	@PostMapping("/boardDeleteModal")
	public String BoardDelete() {
		return "boardDeleteModal";
	}
}
