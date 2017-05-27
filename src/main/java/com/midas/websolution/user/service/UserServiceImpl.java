package com.midas.websolution.user.service;

import com.midas.websolution.user.biz.UserBiz;
import com.midas.websolution.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public boolean registNewUser(UserVO newUserVO) {
		return userBiz.registNewUser(newUserVO);
	}

	@Override
	public UserVO loginUser(UserVO userVO) {
		return userBiz.loginUser(userVO);
	}



	@Override
	public boolean isDuplicateUserId(String user_id) {
		return userBiz.isDuplicateUserId(user_id);
	}

	
	
}
