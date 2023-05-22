package com.springboot.studyjunho.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestRespDto {
	private String username;
	private String password;
}
