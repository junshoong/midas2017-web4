package com.midas.websolution.menu.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MenuRegistRequestVO {
	private int menu_number;
	private String menu_date;
	private int menu_kind;
	private String menu_file_name;
	
	private MultipartFile image_file;
	
	private List<FoodVO> foodVO;
	

	public List<FoodVO> getFoodVO() {
		return foodVO;
	}

	public void setFoodVO(List<FoodVO> foodVO) {
		this.foodVO = foodVO;
	}

	public int getMenu_number() {
		return menu_number;
	}

	public void setMenu_number(int menu_number) {
		this.menu_number = menu_number;
	}

	public String getMenu_date() {
		return menu_date;
	}

	public void setMenu_date(String menu_date) {
		this.menu_date = menu_date;
	}

	public int getMenu_kind() {
		return menu_kind;
	}

	public void setMenu_kind(int menu_kind) {
		this.menu_kind = menu_kind;
	}

	public String getMenu_file_name() {
		return menu_file_name;
	}

	public void setMenu_file_name(String menu_file_name) {
		this.menu_file_name = menu_file_name;
	}

	public MultipartFile getImage_file() {
		return image_file;
	}

	public void setImage_file(MultipartFile image_file) {
		this.image_file = image_file;
	}

	@Override
	public String toString() {
		return "MenuRegistRequestVO [menu_number=" + menu_number + ", menu_date=" + menu_date + ", menu_kind="
				+ menu_kind + ", menu_file_name=" + menu_file_name + ", image_file=" + image_file + ", foodVO=" + foodVO
				+ "]";
	}

	
	
//	for(int i=0; i<foodVO.size();)

	
}
