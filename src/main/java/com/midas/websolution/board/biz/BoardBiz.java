package com.midas.websolution.board.biz;

import java.util.List;

import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;

public interface BoardBiz {
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO);
	public boolean addNewClub(BoardVO newClubVO);
	public BoardVO getOneArticle(String articleId);
	boolean updateReadCount(BoardVO club);
	public boolean insertOneArticle(BoardVO boardVO);
}
