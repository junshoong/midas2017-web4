package com.midas.websolution.menu.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.midas.websolution.menu.vo.FoodSetVO;
import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuLogVO;
import com.midas.websolution.menu.vo.MenuMainRequestVO;
import com.midas.websolution.menu.vo.MenuResultVO;
import com.midas.websolution.menu.vo.MenuVO;

public interface MenuService {

	public MenuVO selectById(String menu_number);
	public List<MenuMainRequestVO> getOneWeekMenu(int menu_kind);
	public List<MenuLogVO> getMenuListByUserNumber(int user_number);
	public Map<String, int[]> getTimesOfMeal(int user_number);
	public List<MenuMainRequestVO> getTodayMenu();
	public void uploadFile(MultipartFile file, String file_path);
	public int insertOneMenu(MenuVO menuVO);
	public int updateOneFood(FoodVO foodVO);
	public void insertOneFoodSet(FoodSetVO foodSetVO);
	public int getFoodNoByFoodName(String food_name);
	public List<MenuResultVO> getMenuList();
	public void deleteFoodSetByMenuNo(int menu_no);
	public void deleteMenuByMenuNo(int menu_no);
	
}
