package com.midas.websolution.board.service;

import java.util.List;

import com.midas.websolution.board.biz.BoardBiz;
import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	
	@Override
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
		return boardBiz.getAllArticles(boardSearchVO);
	}

	@Override
	public boolean addNewClub(BoardVO newClubVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReadCount(BoardVO club) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOneArticle(BoardVO boardVO) {
		return boardBiz.insertOneArticle(boardVO);
	}

	@Override
	public BoardVO getOneArticle(String articleId) {
		return boardBiz.getOneArticle(articleId);
	}

}
