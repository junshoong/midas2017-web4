package com.naver.cafe.menu.biz;

import java.util.List;

import com.naver.cafe.menu.dao.MenuDao;
import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.menu.vo.MenuVO;

public class MenuBizImpl implements MenuBiz{
	
	private MenuDao menuDao;

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<MenuVO> getAllMenu(MenuSearchVO menuSearchVO) {
		return menuDao.selectAllMenu(menuSearchVO);
	}
	
	
	
}
