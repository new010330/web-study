package com.springboot.studyjunho.service.board;

import org.springframework.stereotype.Service;

import com.springboot.studyjunho.domain.board.Board;
import com.springboot.studyjunho.domain.board.BoardRepository;
import com.springboot.studyjunho.web.dto.board.CreateBoardReqDto;
import com.springboot.studyjunho.web.dto.board.CreateBoardRespDto;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepository;

	@Override
	public CreateBoardRespDto createBoard(CreateBoardReqDto createBoardReqDto) throws Exception {
		System.out.println(createBoardReqDto);
		
		Board boardEntity = createBoardReqDto.toEntity();
		
		System.out.println("DB 다녀오기 전: " + boardEntity);
		int result = boardRepository.save(boardEntity);
		System.out.println("DB 다녀온 후: " + boardEntity);
		
		boolean insertStatus = boardRepository.save(createBoardReqDto.toEntity()) > 0;
		
		return boardEntity.toCreateBoardDto(insertStatus);
	}

	@Override
	public boolean updateBoard(int boardcode, CreateBoardReqDto createBoardReqDto) throws Exception {
		return false;
	}

	@Override
	public boolean deleteBoard(int boardcode) throws Exception {
		return false;
	}

	
	
	
	
}
