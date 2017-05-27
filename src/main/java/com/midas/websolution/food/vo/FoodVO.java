package com.midas.websolution.food.vo;

public class FoodVO {
	
	// PK
	private int foodNo;
	private String foodName;
	private int foodCalory;
	private int foodKind;
	
	
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodCalory() {
		return foodCalory;
	}
	public void setFoodCalory(int foodCalory) {
		this.foodCalory = foodCalory;
	}
	public int getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(int foodKind) {
		this.foodKind = foodKind;
	}


	@Override
	public String toString() {
		return "FoodVO [foodNo=" + foodNo + ", foodName=" + foodName + ", foodCalory=" + foodCalory + ", foodKind="
				+ foodKind + "]";
	}


	
}
