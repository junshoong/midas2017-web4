package com.midas.websolution.menu.vo;

public class FoodSetVO {
	private int menu_no;
	private int food_no;
	
	
	public int getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}
	public int getFood_no() {
		return food_no;
	}
	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}
	
	
	@Override
	public String toString() {
		return "FoodSetVO [menu_no=" + menu_no + ", food_no=" + food_no + "]";
	}
	
	
}
