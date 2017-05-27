package com.midas.websolution.menu.service;

import java.util.List;

import com.midas.websolution.menu.dao.MenuDao;
import com.midas.websolution.menu.vo.MenuVO;

public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao;
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<MenuVO> getMenuListByIdAndMonth(int user_number, int month) {
		return menuDao.selectByIdAndMonth(user_number, month);
	}
	
}
