package com.midas.websolution.menu.vo;

public class MenuMainRequestVO {

	private int menu_number;
	private String menu_date;
	private int menu_kind;
	private String food_name;
	
	
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
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	@Override
	public String toString() {
		return "MenuMainRequestVO [menu_number=" + menu_number + ", menu_date=" + menu_date + ", menu_kind=" + menu_kind
				+ ", food_name=" + food_name + "]";
	}
	
}
