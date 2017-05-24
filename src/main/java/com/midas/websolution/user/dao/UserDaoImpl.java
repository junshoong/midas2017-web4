package com.midas.websolution.user.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.user.vo.UserVO;




public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	
	@Override
	public int insertNewUser(UserVO userVO) {
		return getSqlSession().insert("UserDao.insertNewUser", userVO);
	}

	@Override
	public UserVO selectOneUser(UserVO userVO) {
		return getSqlSession().selectOne("UserDao.selectOneUser", userVO);
	}

	@Override
	public UserVO selectOneUser(String userId) {
		return getSqlSession().selectOne("UserDao.selectById", userId);
	}




}
