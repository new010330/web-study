package com.springboot.studyjunho.web.controller.api.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studyjunho.service.board.BoardService;
import com.springboot.studyjunho.web.dto.CMRespDto;
import com.springboot.studyjunho.web.dto.board.CreateBoardReqDto;
import com.springboot.studyjunho.web.dto.board.CreateBoardRespDto;
import com.springboot.studyjunho.web.dto.board.ReadBoardRespDto;

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
		
		CreateBoardRespDto createBoardRespDto = null;
		try {
			createBoardRespDto = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 등록 실패", createBoardRespDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 등록 성공", createBoardRespDto));
	}
	
	@GetMapping("/content/{boardcode}")
	public ResponseEntity<?> getBoard(@PathVariable int boardcode) {
		ReadBoardRespDto readBoardRespDto = null;
		
		try {
			readBoardRespDto = boardService.readBoard(boardcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 조회 실패", readBoardRespDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 조회 성공", readBoardRespDto));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getBoardList(@RequestParam int page) {
		List<ReadBoardRespDto> boardDtoList = null;
		
		try {
			boardDtoList = boardService.readBoardList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 리스트" + page + "페이지 불러오기 실패", boardDtoList));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 리스트" + page + "페이지 불러오기 성공", boardDtoList));
	}
	
	
}
