package com.springboot.studyjunho.domain.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	public int save(Board board);
}
