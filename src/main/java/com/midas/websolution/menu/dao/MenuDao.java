package com.midas.websolution.menu.dao;

import java.util.List;

import com.midas.websolution.menu.vo.MenuVO;

public interface MenuDao {
	
	public static final String MD = "MenuDao";
	public MenuVO selectById(String menu_number);
	public List<MenuVO> getOneWeekMenu(int menu_kind);
	public List<MenuVO> selectByUserNumber(int user_number);
	public List<MenuVO> getTodayMenu();
	
}
