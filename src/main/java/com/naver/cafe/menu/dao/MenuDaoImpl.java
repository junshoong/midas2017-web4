package com.naver.cafe.menu.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.menu.vo.MenuVO;

public class MenuDaoImpl extends SqlSessionDaoSupport implements MenuDao{

	@Override
	public List<MenuVO> selectAllMenu(MenuSearchVO menuSearchVO) {
		return getSqlSession().selectList("MenuDao.selectAllMenu", menuSearchVO);
	}

}
