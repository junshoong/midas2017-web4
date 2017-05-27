package com.midas.websolution.menu.service;

import java.util.List;
import java.io.File;

import org.springframework.web.multipart.MultipartFile;
import com.midas.websolution.menu.dao.MenuDao;
import com.midas.websolution.menu.vo.MenuVO;

public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao;
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<MenuVO> getMenuListByIdAndMonth(int user_number, int month) {
		return menuDao.selectByIdAndMonth(user_number, month);
		
	}
		
	@Override
	public void uploadFile(MultipartFile file, String file_path) {
		// TODO Auto-generated method stub
		String file_name = file.getOriginalFilename();
		
		File new_file = new File("");
	}
	
}
