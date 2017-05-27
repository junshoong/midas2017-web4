package com.midas.websolution.menu.vo;

import java.util.List;

public class MenuResultVO {
	private int menu_no;
	private String menu_date;
	private int menu_kind;
	private String menu_file_name;
	
	private int food_no;
	
	private List<FoodVO> foodVO;

	
	public int getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
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

	public int getFood_no() {
		return food_no;
	}

	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}

	public List<FoodVO> getFoodVO() {
		return foodVO;
	}

	public void setFoodVO(List<FoodVO> foodVO) {
		this.foodVO = foodVO;
	}

	
	@Override
	public String toString() {
		return "MenuResultVO [menu_no=" + menu_no + ", menu_date=" + menu_date + ", menu_kind=" + menu_kind
				+ ", menu_file_name=" + menu_file_name + ", food_no=" + food_no + ", foodVO=" + foodVO + "]";
	}
	
	
}
