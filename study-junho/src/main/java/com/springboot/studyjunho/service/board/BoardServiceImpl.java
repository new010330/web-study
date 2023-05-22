package com.springboot.studyjunho.service.board;

import org.springframework.stereotype.Service;

import com.springboot.studyjunho.web.dto.board.CreateBoardReqDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Override
	public boolean createBoard(CreateBoardReqDto createBoardReqDto) throws Exception {
		System.out.println(createBoardReqDto);
		return true;
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
