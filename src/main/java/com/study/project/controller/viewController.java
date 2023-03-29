package com.study.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {

	@GetMapping("/login")
	public String Login() {
		return "login";
	}
}
