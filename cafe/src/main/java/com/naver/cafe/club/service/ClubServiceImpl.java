package com.naver.cafe.club.service;

import java.util.HashMap;
import java.util.Map;

import com.naver.cafe.club.biz.ClubBiz;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.menu.biz.MenuBiz;
import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.reply.biz.ReplyBiz;

public class ClubServiceImpl implements ClubService{

	private MenuBiz menuBiz;
	private ClubBiz clubBiz;
	private ReplyBiz replyBiz;
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}
	
	public void setClubBiz(ClubBiz clubBiz) {
		this.clubBiz = clubBiz;
	}
	
	@Override
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO) {
	
		ClubListVO clubListVO = clubBiz.getAllClub(clubSearchVO);
		
		
		MenuSearchVO menuSearchVO = new MenuSearchVO();
		menuSearchVO.setMenuId(clubSearchVO.getMenuId());
		
		clubListVO.setMenuList(menuBiz.getAllMenu(menuSearchVO));
		
		menuSearchVO.setMenuId(clubSearchVO.getMenuId());
		clubListVO.setCurrentMenu(menuBiz.getAllMenu(menuSearchVO));
		
		return clubListVO;
	}

	@Override
	public boolean addNewClub(ClubVO newClubVO) {
		return clubBiz.addNewClub(newClubVO);
	}

	@Override
	public Map<String, Object> selectOneClub(ClubSearchVO clubSearchVO) {
		
		ClubVO clubVO = clubBiz.selectOneClub(clubSearchVO);
		clubVO.setReplyVO(replyBiz.getAllReplies(clubSearchVO.getArticleId()));
		
		Map<String, Object> club = new HashMap<String, Object>();
		club.put("club", clubVO);
		
		MenuSearchVO menuSearchVO = new MenuSearchVO();
		menuSearchVO.setAuth("ADM");
		club.put("menu", menuBiz.getAllMenu(menuSearchVO));
		
		menuSearchVO.setMenuId(clubSearchVO.getMenuId());
		club.put("currentMenu", menuBiz.getAllMenu(menuSearchVO));
		
		
		return club;
	}

	@Override
	public boolean updateReadCount(ClubVO club) {
		return clubBiz.updateReadCount(club);
	}

	@Override
	public boolean deleteOneClub(String menuId) {
		return clubBiz.deleteOneClub(menuId);
	}
	
	

}
