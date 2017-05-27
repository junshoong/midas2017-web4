package com.midas.websolution.menu.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MenuMainRequestVO {
	private MenuVO MenuVO;
	private MultipartFile image_file;
	
	private List<FoodVO> foodVO;

	
	public MenuVO getMenuVO() {
		return MenuVO;
	}

	public void setMenuVO(MenuVO menuVO) {
		MenuVO = menuVO;
	}

	public MultipartFile getImage_file() {
		return image_file;
	}

	public void setImage_file(MultipartFile image_file) {
		this.image_file = image_file;
	}

	public List<FoodVO> getFoodVO() {
		return foodVO;
	}

	public void setFoodVO(List<FoodVO> foodVO) {
		this.foodVO = foodVO;
	}
	
	
	@Override
	public String toString() {
		return "MenuRegistRequestVO [MenuVO=" + MenuVO + ", image_file=" + image_file + ", foodVO=" + foodVO + "]";
	}
	
	
}
