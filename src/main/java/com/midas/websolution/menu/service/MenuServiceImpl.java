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
	public MenuVO selectById(String menu_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuVO> getOneWeekMenu(int menu_kind) {
		return menuDao.getOneWeekMenu(menu_kind);
	}
	
}
