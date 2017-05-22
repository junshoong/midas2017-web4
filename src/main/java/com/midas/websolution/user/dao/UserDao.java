package com.midas.websolution.user.dao;

import com.midas.websolution.user.vo.UserVO;

public interface UserDao {
	
	public int insertNewUser(UserVO userVO);
	public UserVO selectOneUser(UserVO userVO);


}
