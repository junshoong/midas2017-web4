package com.midas.websolution.menu.dao;

import java.util.List;

import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuVO;

public interface MenuDao {
	
	public static final String MD = "MenuDao";
	public MenuVO selectById(String menu_number);
	public List<MenuVO> getOneWeekMenu(int menu_kind);
	public List<MenuVO> selectByUserNumber(int user_number);
<<<<<<< HEAD
	public List<MenuVO> getTodayMenu();
=======
	public int insertOneMenu(MenuVO menuVO);
	public int updateOneFood(FoodVO foodVO);
>>>>>>> dc8a32c0c632782bda0f14e0ba2bd2f22aeb4748
	
}
