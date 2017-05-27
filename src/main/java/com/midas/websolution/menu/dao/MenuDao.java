package com.midas.websolution.menu.dao;

import com.midas.websolution.menu.vo.MenuVO;

public interface MenuDao {
	
	public static final String MD = "MenuDao";
	public MenuVO selectOneUser(String menu_number);
	
}
