package com.midas.websolution.food.vo;

public class FoodVO {
	
	// PK
	private int food_no;
	private String food_name;
	private int food_calory;
	private int food_kind;
	
	
	public int getFood_no() {
		return food_no;
	}
	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getFood_calory() {
		return food_calory;
	}
	public void setFood_calory(int food_calory) {
		this.food_calory = food_calory;
	}
	public int getFood_kind() {
		return food_kind;
	}
	public void setFood_kind(int food_kind) {
		this.food_kind = food_kind;
	}
	
	
	@Override
	public String toString() {
		return "FoodVO [food_no=" + food_no + ", food_name=" + food_name + ", food_calory=" + food_calory
				+ ", food_kind=" + food_kind + "]";
	}

	
}
