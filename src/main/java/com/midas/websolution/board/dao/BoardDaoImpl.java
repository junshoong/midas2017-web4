package com.midas.websolution.board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{

	@Override
	public int insertOneArticle(BoardVO boardVO) {
		return getSqlSession().insert(BD + ".insertOneArticle", boardVO);
	}

	@Override
	public BoardVO getOneArticle(String articleId) {
		return getSqlSession().selectOne(BD + ".getOneArticle", articleId);
	}

	@Override
	public int updateReadCount(BoardVO club) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
		return getSqlSession().selectList(BD + ".getAllArticles", boardSearchVO);
	}

	@Override
	public int getAllArticlesCount(BoardSearchVO boardSearchVO) {
		return getSqlSession().selectOne(BD + ".getAllArticlesCount", boardSearchVO);
	}

}
