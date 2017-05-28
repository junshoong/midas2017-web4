package com.midas.websolution.menu.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.midas.websolution.menu.dao.MenuDao;
import com.midas.websolution.menu.vo.FoodSetVO;
import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuLikeRequestVO;
import com.midas.websolution.menu.vo.MenuLogVO;
import com.midas.websolution.menu.vo.MenuMainRequestVO;
import com.midas.websolution.menu.vo.MenuResultVO;
import com.midas.websolution.menu.vo.MenuVO;

public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao;
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
	private String temp_path = "C:\\Users\\ElonBusiness\\Documents\\midas2017-web4\\src\\main\\webapp\\WEB-INF\\resources\\upload\\";

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
	public List<MenuLogVO> getMenuListByUserNumber(int user_number) {
		return menuDao.selectByUserNumber(user_number);
	}
	
	@Override
	public Map<String, int[][]> getTimesOfMeal(int user_number) {
		List<MenuLogVO> menus = menuDao.selectByUserNumber(user_number);
		Map<String, int[][]> map = new HashMap<String, int[][]>();
		int meals[][][] = new int[3][3][2];
		Date now = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

		for(MenuLogVO menu: menus) {
			String from = menu.getMenu_date();
			if(menu.getLog_like())
				meals[0][(menu.getMenu_kind()/10)-1][0]++;
			else
				meals[0][(menu.getMenu_kind()/10)-1][1]++;
			try {
				Date date = transFormat.parse(from);
				if (yearFormat.format(now).equals(yearFormat.format(date))) {
					if(menu.getLog_like())
						meals[1][(menu.getMenu_kind()/10)-1][0]++;
					else
						meals[1][(menu.getMenu_kind()/10)-1][1]++;
					if (monthFormat.format(now).equals(monthFormat.format(date))) {
						if(menu.getLog_like())
							meals[2][(menu.getMenu_kind()/10)-1][0]++;
						else
							meals[2][(menu.getMenu_kind()/10)-1][1]++;
					}
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}
			map.put("all", meals[0]);
			map.put("year", meals[1]);
			map.put("month", meals[2]);
		}
		return map;
	}
		
	@Override
	public Map<String, int[][]> getTimesOfMealAll() {
		List<MenuLogVO> menus = menuDao.selectLogAll();
		Map<String, int[][]> map = new HashMap<String, int[][]>();
		int meals[][][] = new int[3][3][2];
		Date now = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

		for(MenuLogVO menu: menus) {
			String from = menu.getMenu_date();
			if(menu.getLog_like())
				meals[0][(menu.getMenu_kind()/10)-1][0]++;
			else
				meals[0][(menu.getMenu_kind()/10)-1][1]++;
			try {
				Date date = transFormat.parse(from);
				if (yearFormat.format(now).equals(yearFormat.format(date))) {
					if(menu.getLog_like())
						meals[1][(menu.getMenu_kind()/10)-1][0]++;
					else
						meals[1][(menu.getMenu_kind()/10)-1][1]++;
					if (monthFormat.format(now).equals(monthFormat.format(date))) {
						if(menu.getLog_like())
							meals[2][(menu.getMenu_kind()/10)-1][0]++;
						else
							meals[2][(menu.getMenu_kind()/10)-1][1]++;
					}
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}
			map.put("all", meals[0]);
			map.put("year", meals[1]);
			map.put("month", meals[2]);
		}
		return map;
	}
	
	@Override
	public String uploadFile(MultipartFile file, String root_path) {
		// TODO Auto-generated method stub
		String origin_file_name = file.getOriginalFilename();
		
		String file_name = UUID.randomUUID().toString() + origin_file_name;
		
		File new_file = new File(temp_path + file_name);
		
		if(new_file.exists() == false){
			new_file.mkdirs();
	    }
		
		try {
			file.transferTo(new_file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file_name;

	}
	
	public String updateFile(MultipartFile image_file, String file_name, String root_path) {
		// TODO Auto-generated method stub
		
		File new_file = new File(temp_path + file_name);
		
		if(new_file.exists() == false){
			new_file.mkdirs();
	    }
		
		try {
			image_file.transferTo(new_file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file_name;
		
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


	@Override
	public void insertOneFoodSet(FoodSetVO foodSetVO) {
		menuDao.insertOneFoodSet(foodSetVO);
	}

	@Override
	public int getFoodNoByFoodName(String food_name) {
		return menuDao.getFoodNoByFoodName(food_name);
	}

	@Override
	public List<MenuResultVO> getMenuList() {
		return menuDao.getMenuList();
	}

	@Override
	public List<MenuResultVO> getMenuListByFoodName(String food_name) {
		List<MenuResultVO> list = menuDao.getMenuList();
		List<MenuResultVO> result = new ArrayList<MenuResultVO>();
		for(MenuResultVO mr : list) {
			for(FoodVO food : mr.getFoodVO()) {
				if(food.getFood_name().equals(food_name)) {
					result.add(mr);
					break;
				}
				
			}
		}
		return result;
	}

	@Override
	public List<MenuResultVO> getMenuListByDate(String menu_date) {
		List<MenuResultVO> list = menuDao.getMenuList();
		List<MenuResultVO> result = new ArrayList<MenuResultVO>();
		for(MenuResultVO mr : list)
			if(mr.getMenu_date().equals(menu_date))
				result.add(mr);
		return result;
	}

	@Override
	public void deleteFoodSetByMenuNo(int menu_no) {
		menuDao.deleteFoodSetByMenuNo(menu_no);
	}

	@Override
	public void deleteMenuByMenuNo(int menu_no) {
		menuDao.deleteMenuByMenuNo(menu_no);
	}

	@Override
	public boolean insertLike(MenuLikeRequestVO menuLikeRequestVO) {
		return menuDao.insertLike(menuLikeRequestVO) > 0;
	}

	@Override
	public MenuResultVO getOneMenu(int menu_no) {
		return menuDao.getOneMenu(menu_no);
	}

	@Override
	public boolean updateOneMenu(MenuVO menuVO) {
		return menuDao.updateOneMenu(menuVO) > 0;
		
	}

	@Override
	public MenuLikeRequestVO checkLike(MenuLikeRequestVO menuLikeRequestVO) {
		return menuDao.checkLike(menuLikeRequestVO);
	}
	
}
