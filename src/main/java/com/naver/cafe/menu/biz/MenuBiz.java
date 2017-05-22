package com.naver.cafe.menu.biz;

import java.util.List;

import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.menu.vo.MenuVO;

public interface MenuBiz {
	public List<MenuVO> getAllMenu(MenuSearchVO menuSearchVO);
}
