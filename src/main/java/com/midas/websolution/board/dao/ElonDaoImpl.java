package com.midas.websolution.board.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.board.vo.BoardVO;

public class ElonDaoImpl extends SqlSessionDaoSupport implements ElonDao {

	@Override
	public BoardVO getOneArticleElon(int articleId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(ED + ".getOneArticleElon", articleId);
	}

}
