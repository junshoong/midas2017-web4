package com.naver.cafe.user.biz;

import com.naver.cafe.user.vo.UserVO;

public interface UserBiz {
	public boolean registNewUser(UserVO newUserVO);
	public UserVO loginUser(UserVO userVO);;
	public boolean isDuplicateUserId(String userId);
}
