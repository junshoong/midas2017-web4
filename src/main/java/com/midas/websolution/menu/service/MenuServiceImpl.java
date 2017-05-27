package com.midas.websolution.menu.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.midas.websolution.menu.dao.MenuDao;
import com.midas.websolution.menu.vo.FoodSetVO;
import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuMainRequestVO;
import com.midas.websolution.menu.vo.MenuRegistRequestVO;
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
	public List<MenuMainRequestVO> getOneWeekMenu(int menu_kind) {
		return menuDao.getOneWeekMenu(menu_kind);
	}
	
	@Override
	public List<MenuVO> getMenuListByUserNumber(int user_number) {
		return menuDao.selectByUserNumber(user_number);
	}
	
	@Override
	public Map<String, int[]> getTimesOfMeal(int user_number) {
		List<MenuVO> menus = menuDao.selectByUserNumber(user_number);
		Map<String, int[]> map = new HashMap<String, int[]>();
		int meals[][] = new int[3][3];
		Date now = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

		for(MenuVO menu: menus) {
			String from = menu.getMenu_date();
			if (menu.getMenu_kind() == 10)
				meals[0][0]++;
			else if (menu.getMenu_kind() == 20)
				meals[0][1]++;
			else if (menu.getMenu_kind() == 30)
				meals[0][2]++;
			map.put("all", meals[0]);
			try {
				Date date = transFormat.parse(from);
				if (yearFormat.format(now).equals(yearFormat.format(date))) {
					if (menu.getMenu_kind() == 10)
						meals[1][0]++;
					else if (menu.getMenu_kind() == 20)
						meals[1][1]++;
					else if (menu.getMenu_kind() == 30)
						meals[1][2]++;
					map.put("year", meals[1]);
					if (monthFormat.format(now).equals(monthFormat.format(date))) {
						if (menu.getMenu_kind() == 10)
							meals[2][0]++;
						else if (menu.getMenu_kind() == 20)
							meals[2][1]++;
						else if (menu.getMenu_kind() == 30)
							meals[2][2]++;
						map.put("month", meals[2]);
					}
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
		
	@Override
	public void uploadFile(MultipartFile file, String file_path) {
		// TODO Auto-generated method stub
		String origin_file_name = file.getOriginalFilename();
		String file_name = UUID.randomUUID().toString() + origin_file_name;
		
		File new_file = new File(file_path + file_name);
		
		if(new_file.exists() == false){
			new_file.mkdirs();
	    }
		
		try {
			file.transferTo(new_file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	@Override
	public int insertOneMenu(MenuVO menuVO) {
		menuDao.insertOneMenu(menuVO);
		return menuVO.getMenu_number();
	}

	@Override
	public int updateOneFood(FoodVO foodVO) {
		menuDao.updateOneFood(foodVO);
		return foodVO.getFood_no();
	}

	@Override
	public List<MenuMainRequestVO> getTodayMenu() {
		return menuDao.getTodayMenu();
	}


	public void insertOneFoodSet(FoodSetVO foodSetVO) {
		menuDao.insertOneFoodSet(foodSetVO);
	}

	public int getFoodNoByFoodName(String food_name) {
		return menuDao.getFoodNoByFoodName(food_name);
	}

	@Override
	public List<MenuRegistRequestVO> getMenuList() {
		return menuDao.getMenuList();
	}
	

}
