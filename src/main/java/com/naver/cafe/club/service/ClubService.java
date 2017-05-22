package com.naver.cafe.club.service;

import java.util.Map;

import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public interface ClubService {
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO);
	public boolean addNewClub(ClubVO newClubVO);
	public Map<String, Object> selectOneClub(ClubSearchVO clubSearchVO);
	public boolean updateReadCount(ClubVO club);
	public boolean deleteOneClub(String menuId);
}
