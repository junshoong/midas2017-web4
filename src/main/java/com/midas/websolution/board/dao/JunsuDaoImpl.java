package com.midas.websolution.board.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.board.vo.BoardVO;

public class JunsuDaoImpl extends SqlSessionDaoSupport implements JunsuDao {
	
	@Override
	public BoardVO getSomething(int someId) {
		return getSqlSession().selectOne(JD+ ".getSomething", someId);
	}
	

}
