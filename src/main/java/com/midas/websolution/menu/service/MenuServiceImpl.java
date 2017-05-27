package com.midas.websolution.menu.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import com.midas.websolution.menu.dao.MenuDao;
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
	public int[] getTimesOfMeal(int user_number) {
		List<MenuVO> menus = menuDao.selectByUserNumber(user_number);
		int breakfast = 0;
		int lunch = 0;
		int dinner = 0;
		Date now = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = transFormat.format(now);
		System.out.println(nowDate);

//		int month = cal.get(Calendar.MONTH) + 1;
	

//		for(MenuVO menu: menus) {
//			if(menu.getMenu_kind() == 10) {

				
				
//			}
//		}

//		int meal[] = [];
		// TODO Auto-generated method stub
		return null;
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

}
