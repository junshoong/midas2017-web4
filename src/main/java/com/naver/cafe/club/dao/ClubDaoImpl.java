package com.naver.cafe.club.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public class ClubDaoImpl extends SqlSessionDaoSupport implements ClubDao{

	@Override
	public int selectAllClubCount(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectOne(NS + ".selectAllClubCount", clubSearchVO);
	}

	@Override
	public List<ClubVO> selectAllClub(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectList(NS + ".selectAllClub", clubSearchVO);
	}

	@Override
	public int insertNewClub(ClubVO newClub) {
		return getSqlSession().insert(NS + ".insertNewClub", newClub);
	}

	@Override
	public ClubVO selectOneClub(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectOne(NS + ".selectOneClub", clubSearchVO);
	}

	@Override
	public int updateReadCount(ClubVO club) {
		return getSqlSession().update(NS + ".updateReadCount", club);
	}

	@Override
	public int deleteOneClub(String menuId) {
		return getSqlSession().delete(NS + ".deleteOneClub", menuId);
	}

}
