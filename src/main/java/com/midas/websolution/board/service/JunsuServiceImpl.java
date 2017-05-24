package com.midas.websolution.board.service;

import com.midas.websolution.board.dao.JunsuDao;
import com.midas.websolution.board.vo.BoardVO;

public class JunsuServiceImpl implements JunsuService {

	private JunsuDao junsuDao;
	
	public void setJunsuDao(JunsuDao junsuDao) {
		this.junsuDao = junsuDao;
	}

	@Override
	public BoardVO getSomething() {
		return junsuDao.getSomething(100);
	}

}
