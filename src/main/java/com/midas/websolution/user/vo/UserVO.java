package com.midas.websolution.user.vo;


public class UserVO {
	
	//PK
	private int user_no;

	private String user_id;
	private String user_password;
	private String user_name;
	private int user_permission;
	private String user_join_date;
	
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_permission() {
		return user_permission;
	}
	public void setUser_permission(int user_permission) {
		this.user_permission = user_permission;
	}
	public String getUser_join_date() {
		return user_join_date;
	}
	public void setUser_join_date(String user_join_date) {
		this.user_join_date = user_join_date;
	}


	@Override
	public String toString() {
		return "UserVO [user_no=" + user_no + ", user_id=" + user_id + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", user_permission=" + user_permission + ", user_join_date="
				+ user_join_date + "]";
	}

}
