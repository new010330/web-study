package com.springboot.studyjunho.web.dto.board;

import com.springboot.studyjunho.domain.board.Board;

import lombok.Data;

@Data
public class CreateBoardReqDto {
	private String title;
	private int usercode;
	private String content;
	
	public Board toEntity()	 { // 보드에 있는 값들을 필요한 것만 전달하기 위해서 Builder를 사용한다.
		return Board.builder()
				.title(title)
				.usercode(usercode)
				.content(content)
				.build();
	}
}
