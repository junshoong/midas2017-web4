package com.naver.cafe.user.dao;

import com.naver.cafe.user.vo.UserVO;

public interface UserDao {
	
	public int insertNewUser(UserVO userVO);
	public UserVO selectOneUser(UserVO userVO);


}
