package com.springboot.studyjunho.service.board;

import com.springboot.studyjunho.web.dto.board.CreateBoardReqDto;

public interface BoardService {
	public boolean createBoard(CreateBoardReqDto createBoardReqDto) throws Exception;
//	public boolean readBoard(CreateBoardReqDto boardReqDto) throws Exception;
	public boolean updateBoard(int boardcode, CreateBoardReqDto createBoardReqDto) throws Exception;
	public boolean deleteBoard(int boardcode) throws Exception;
	
}
