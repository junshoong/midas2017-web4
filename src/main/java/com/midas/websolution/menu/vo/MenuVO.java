package com.midas.websolution.menu.vo;


public class MenuVO {
	
	private int menu_number;
	private String menu_date;
	private int menu_kind;
	private String menu_file_name;
	
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
	
	
	@Override
	public String toString() {
		return "MenuVO [menu_number=" + menu_number + ", menu_date=" + menu_date + ", menu_kind=" + menu_kind
				+ ", menu_file_name=" + menu_file_name + "]";
	}
	
}
