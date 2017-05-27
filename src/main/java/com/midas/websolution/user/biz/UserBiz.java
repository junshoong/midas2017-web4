package com.midas.websolution.user.biz;

import com.midas.websolution.user.vo.UserVO;

public interface UserBiz {
	public boolean registNewUser(UserVO newUserVO);
	public UserVO loginUser(UserVO userVO);;
	public boolean isDuplicateUserId(String user_id);
}
