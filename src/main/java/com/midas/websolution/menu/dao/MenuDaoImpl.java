package com.midas.websolution.menu.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.menu.vo.FoodSetVO;
import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuLogVO;
import com.midas.websolution.menu.vo.MenuMainRequestVO;
import com.midas.websolution.menu.vo.MenuResultVO;
import com.midas.websolution.menu.vo.MenuVO;


public class MenuDaoImpl extends SqlSessionDaoSupport implements MenuDao {

	@Override
	public MenuVO selectById(String menu_number) {
		return getSqlSession().selectOne(MD + ".selectById", menu_number);
	}

	@Override
	public List<MenuMainRequestVO> getOneWeekMenu(int menu_kind) {
		return getSqlSession().selectList(MD + ".getOneWeekMenu", menu_kind);
	}

	@Override
	public List<MenuLogVO> selectByUserNumber(int user_number) {
		return getSqlSession().selectList(MD + ".selectByUserNumber", user_number);
	}

	@Override
	public List<MenuMainRequestVO> getTodayMenu() {
		return getSqlSession().selectList(MD + ".getTodayMenu");
	}


	@Override
	public int insertOneMenu(MenuVO menuVO) {
		return getSqlSession().insert(MD + ".insertOneMenu", menuVO);
	}

	@Override
	public int updateOneFood(FoodVO foodVO) {
		return getSqlSession().insert(MD + ".updateOneFood", foodVO);
	}

	@Override
	public int insertOneFoodSet(FoodSetVO foodSetVO) {
		return getSqlSession().insert(MD + ".insertOneFoodSet", foodSetVO);
	}

	@Override
	public int getFoodNoByFoodName(String food_name) {
		return getSqlSession().selectOne(MD + ".getFoodNoByFoodName", food_name);
	}

	@Override
	public List<MenuResultVO> getMenuList() {
		return getSqlSession().selectList(MD + ".getMenuList");
	}

	@Override
	public void deleteFoodSetByMenuNo(int menu_no) {
		getSqlSession().delete(MD + ".deleteFoodSetByMenuNo", menu_no);
	}

	@Override
	public void deleteMenuByMenuNo(int menu_no) {
		getSqlSession().delete(MD + ".deleteMenuByMenuNo", menu_no);
	}

}