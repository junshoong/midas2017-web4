package com.midas.websolution.user.service;

import com.midas.websolution.user.vo.UserVO;

public interface UserService {
	public boolean registNewUser(UserVO newUserVO);
	public UserVO loginUser(UserVO userVO);
	public boolean isDuplicateUserId(String userId);
}
