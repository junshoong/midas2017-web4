package com.midas.websolution.board.dao;

import com.midas.websolution.board.vo.BoardVO;

public interface JunsuDao {
	public static final String JD = "JunsuDao";
	
	public BoardVO getSomething(int someId);

}
