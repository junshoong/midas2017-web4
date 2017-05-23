package com.midas.websolution.board.service;

import java.util.List;


import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO);
	public boolean addNewClub(BoardVO newClubVO);
	public boolean updateReadCount(BoardVO club);
	boolean insertOneArticle(BoardVO boardVO);
	public BoardVO getOneArticle(String articleId);
}
