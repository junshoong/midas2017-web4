package com.naver.cafe.club.dao;

import java.util.List;

import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public interface ClubDao {
	
	public static final String NS = "ClubDao";
	
	public int selectAllClubCount(ClubSearchVO clubSearchVO);
	public List<ClubVO> selectAllClub(ClubSearchVO clubSearchVO);
	public int insertNewClub(ClubVO newClub);
	public ClubVO selectOneClub(ClubSearchVO clubSearchVO);
	public int updateReadCount(ClubVO club);
	public int deleteOneClub(String menuId);
}
