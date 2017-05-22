package com.naver.cafe.club.biz;


import com.naver.cafe.club.dao.ClubDao;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public class ClubBizImpl implements ClubBiz {

	
	private ClubDao clubDao;
	
	public void setClubDao(ClubDao clubDao) {
		this.clubDao = clubDao;
	}
	
	@Override
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO) {
		
		int totalCount = clubDao.selectAllClubCount(clubSearchVO);
		
		ClubListVO clubListVO = new ClubListVO();
		clubListVO.getPager().setPageNumber(clubSearchVO.getPageNo());
		clubListVO.getPager().setTotalArticleCount(totalCount);
		
		clubSearchVO.setEndArticleNumber(clubListVO.getPager().getEndArticleNumber() * 3);
		clubSearchVO.setStartArticleNumber(clubListVO.getPager().getStartArticleNumber());
		
		if(totalCount > 0 ) {
			clubListVO.setClubList(clubDao.selectAllClub(clubSearchVO));
		}
		
		return clubListVO;
	}

	@Override
	public boolean addNewClub(ClubVO newClubVO) {
		return clubDao.insertNewClub(newClubVO) > 0;
	}
	
	public ClubVO selectOneClub(ClubSearchVO clubSearchVO) {
		return clubDao.selectOneClub(clubSearchVO);
	}

	@Override
	public boolean updateReadCount(ClubVO club) {
		return clubDao.updateReadCount(club) > 0;
	}

	@Override
	public boolean deleteOneClub(String menuId) {
		return clubDao.deleteOneClub(menuId) > 0;
	}

}
