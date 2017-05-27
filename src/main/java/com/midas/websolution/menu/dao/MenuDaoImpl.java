package com.midas.websolution.menu.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.midas.websolution.menu.vo.MenuVO;


public class MenuDaoImpl extends SqlSessionDaoSupport implements MenuDao {

	@Override
	public MenuVO selectOneUser(String menu_number) {
		return getSqlSession().selectOne(MD + ".selectById", menu_number);
	}

}
