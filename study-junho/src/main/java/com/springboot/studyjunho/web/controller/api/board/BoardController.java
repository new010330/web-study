package com.springboot.studyjunho.web.controller.api.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studyjunho.service.board.BoardService;
import com.springboot.studyjunho.web.dto.board.CreateBoardReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;

	//게시글 작성
//	@PostMapping("/content")
//	public ResponseEntity<?> addBoard(String title, int usercode, String content) {
//		System.out.println("게시글 작성요청");
//		System.out.println("title: " + title);
//		System.out.println("usercode: " + usercode);
//		System.out.println("content: " + content);
//		return new ResponseEntity<>(title + "게시글 작성 성공", HttpStatus.OK);
//	}
	
	@PostMapping("/content")
	public ResponseEntity<?> addBoard(@RequestBody CreateBoardReqDto createBoardReqDto) {
		System.out.println("게시글 작성요청");
		System.out.println("title: " + createBoardReqDto.getTitle());
		System.out.println("usercode: " + createBoardReqDto.getUsercode());
		System.out.println("content: " + createBoardReqDto.getContent());
		Boolean result = false;
		
		try {
			result = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body(result);
	}
}
