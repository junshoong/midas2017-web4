package com.midas.websolution.menu.service;

import java.util.List;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import com.midas.websolution.menu.dao.MenuDao;
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
	public List<MenuVO> getOneWeekMenu(int menu_kind) {
		return menuDao.getOneWeekMenu(menu_kind);
	}
	
	@Override
	public List<MenuVO> getMenuListByIdAndMonth(int user_number, int month) {
		return menuDao.selectByUserNumber(user_number);
		
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
	
}
