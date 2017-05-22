package com.midas.websolution.user.biz;

import com.midas.websolution.user.dao.UserDao;
import com.midas.websolution.user.vo.UserVO;

public class UserBizImpl implements UserBiz{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean registNewUser(UserVO newUserVO) {
		return userDao.insertNewUser(newUserVO) > 0;
	}

	@Override
	public UserVO loginUser(UserVO userVO) {
		UserVO loginUserVO = userDao.selectOneUser(userVO);
		return loginUserVO;
	}


	@Override
	public boolean isDuplicateUserId(String userId) {
		return false;
	}
		
		


}
