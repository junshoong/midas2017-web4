package com.naver.cafe.club.vo;

public class ClubSearchVO {
	
	private String pageNo;
	private int endArticleNumber;
	private int startArticleNumber;
	
	private String menuId;
	private String articleId;
	private String searchKeyword;
	private String searchType;
	
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}	
	public String getPageNo() {
		return pageNo;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public int getEndArticleNumber() {
		return endArticleNumber;
	}
	public int getStartArticleNumber() {
		return startArticleNumber;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public void setEndArticleNumber(int endArticleNumber) {
		this.endArticleNumber = endArticleNumber;
	}
	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

}
