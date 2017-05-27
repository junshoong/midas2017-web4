package com.midas.websolution.menu.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.menu.vo.MenuVO;


public class MenuDaoImpl extends SqlSessionDaoSupport implements MenuDao {

	@Override
	public MenuVO selectById(String menu_number) {
		return getSqlSession().selectOne(MD + ".selectById", menu_number);
	}

	@Override
	public List<MenuVO> selectByIdAndMonth(int user_number, int month) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("user_number", user_number);
		hashMap.put("month", month);

		return getSqlSession().selectList(MD + ".selectByIdAndMonth", hashMap);
	}

}