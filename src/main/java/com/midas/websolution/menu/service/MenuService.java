package com.midas.websolution.menu.service;

import java.util.List;

import com.midas.websolution.menu.vo.MenuVO;

public interface MenuService {
	public MenuVO selectById(String menu_number);
	public List<MenuVO> getOneWeekMenu(int menu_kind);
}
