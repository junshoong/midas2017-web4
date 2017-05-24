package com.midas.websolution.board.dao;

import com.midas.websolution.board.vo.BoardVO;

public interface ElonDao {
	public static final String ED = "ElonDao";
	
	public BoardVO getOneArticleElon(int articleId);
}
