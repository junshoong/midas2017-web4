package com.midas.websolution.menu.service;

import com.midas.websolution.menu.dao.MenuDao;

public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao;
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
}
