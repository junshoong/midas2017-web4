package com.naver.cafe.user.service;

import com.naver.cafe.user.vo.UserVO;

public interface UserService {
	public boolean registNewUser(UserVO newUserVO);
	public UserVO loginUser(UserVO userVO);
	public boolean isDuplicateUserId(String userId);
}
