package com.midas.websolution.menu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuVO;

public interface MenuService {

	public MenuVO selectById(String menu_number);
	public List<MenuVO> getOneWeekMenu(int menu_kind);
	public List<MenuVO> getMenuListByIdAndMonth(int user_number, int month);
	public List<MenuVO> getTodayMenu();
	public void uploadFile(MultipartFile file, String file_path);
	public int insertOneMenu(MenuVO menuVO);
	public int updateOneFood(FoodVO foodVO);
}
