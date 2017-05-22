package com.naver.cafe.club.vo;

import java.util.List;

import com.naver.cafe.common.pager.Pager;
import com.naver.cafe.common.pager.PagerFactory;
import com.naver.cafe.menu.vo.MenuVO;

public class ClubListVO {
	
	private List<ClubVO> clubList;
	
	private List<MenuVO> menuList;
	private List<MenuVO> currentMenu;
	
	private Pager pager;

	public Pager getPager() {
		
		if(pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		
		return pager;
	}
	
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public List<ClubVO> getClubList() {
		return clubList;
	}
	public List<MenuVO> getMenuList() {
		return menuList;
	}
	public void setClubList(List<ClubVO> clubList) {
		this.clubList = clubList;
	}
	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}

	public List<MenuVO> getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(List<MenuVO> currentMenu) {
		this.currentMenu = currentMenu;
	}
	
}
