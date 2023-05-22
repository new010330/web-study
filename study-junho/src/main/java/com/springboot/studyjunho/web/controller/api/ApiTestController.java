package com.springboot.studyjunho.web.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studyjunho.web.dto.TestRespDto;
import com.springboot.studyjunho.web.dto.User;

@RestController
@RequestMapping("/api/v1")
public class ApiTestController {
	
//	@GetMapping("/test")
//	public String getTest() {
//		return "test data";
//	}
	
	@PostMapping("/test")
	public String postTest() {
		return "test data(post)";
	}
	
	@GetMapping("/test")
	public Object getTest() {
		return TestRespDto.builder().username("hong").password("1234").build();
	}
	
	@PostMapping("/user")
	public Object getUser() {
		return User.builder()
				.username("hong")
				.password("1234")
				.name("gildong")
				.email("hong@")
				.build();
	}
}
