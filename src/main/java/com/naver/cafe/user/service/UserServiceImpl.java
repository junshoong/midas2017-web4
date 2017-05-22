package com.naver.cafe.user.service;

import com.naver.cafe.user.biz.UserBiz;
import com.naver.cafe.user.vo.UserVO;

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
	public boolean isDuplicateUserId(String userId) {
		return userBiz.isDuplicateUserId(userId);
	}

	
	
}
