package com.midas.websolution.menu.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuRegistRequestVO;
import com.midas.websolution.menu.vo.MenuVO;


public class MenuDaoImpl extends SqlSessionDaoSupport implements MenuDao {

	@Override
	public MenuVO selectById(String menu_number) {
		return getSqlSession().selectOne(MD + ".selectById", menu_number);
	}

	@Override
	public List<MenuVO> getOneWeekMenu(int menu_kind) {
		return getSqlSession().selectList(MD + ".getOneWeekMenu", menu_kind);
	}

	@Override
	public List<MenuVO> selectByUserNumber(int user_number) {
		return getSqlSession().selectList(MD + ".selectByUserNumber", user_number);
	}

	@Override
	public int insertOneMenu(MenuVO menuVO) {
		return getSqlSession().insert(MD + ".insertOneMenu", menuVO);
	}

	@Override
	public int updateOneFood(FoodVO foodVO) {
		return getSqlSession().insert(MD + ".updateOneFood", foodVO);
	}

}