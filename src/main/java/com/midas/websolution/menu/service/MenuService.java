package com.midas.websolution.menu.service;

import java.util.List;

import com.midas.websolution.menu.vo.MenuVO;

public interface MenuService {

	public List<MenuVO> getMenuListByIdAndMonth(int user_number, int month);
}
