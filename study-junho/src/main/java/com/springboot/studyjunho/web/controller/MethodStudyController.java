package com.springboot.studyjunho.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MethodStudyController {
	
	@GetMapping({"/", "/index"})
	public String getMethod() {
		return "method/get";
	}

	@ResponseBody
	@GetMapping("/api/v1/username")
	public String getUsername() {
		return "gildong";
	}
	
	
}
