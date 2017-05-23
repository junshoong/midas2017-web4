package com.midas.websolution.board.dao;

import java.util.List;

import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;

public interface BoardDao {
	
	public static final String BD = "BoardDao";
	
	public int getAllArticlesCount(BoardSearchVO boardSearchVO);
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO);
	public int insertOneArticle(BoardVO boardVO);
	public BoardVO getOneArticle(String articleId);
	public int updateReadCount(BoardVO club);
	
}	
	