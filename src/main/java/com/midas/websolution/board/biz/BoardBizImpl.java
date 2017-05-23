package com.midas.websolution.board.biz;

import java.util.ArrayList;
import java.util.List;

import com.midas.websolution.board.dao.BoardDao;
import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
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
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
		
		int totalCount = boardDao.getAllArticlesCount(boardSearchVO);
		
		boardSearchVO.getPager().setPageNumber(boardSearchVO.getPageNo());
		boardSearchVO.getPager().setTotalArticleCount(totalCount);
		
		boardSearchVO.setEndArticleNumber(boardSearchVO.getPager().getEndArticleNumber());
		boardSearchVO.setStartArticleNumber(boardSearchVO.getPager().getStartArticleNumber());
		
		
		if(totalCount == 0) {
			return new ArrayList<BoardVO>();
		}
		
		return boardDao.getAllArticles(boardSearchVO);
	}


	@Override
	public boolean insertOneArticle(BoardVO boardVO) {
		return boardDao.insertOneArticle(boardVO) > 0;
	}


	@Override
	public BoardVO getOneArticle(String articleId) {
		return boardDao.getOneArticle(articleId);
	}

}
