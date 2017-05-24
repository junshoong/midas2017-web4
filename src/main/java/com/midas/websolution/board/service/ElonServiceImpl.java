package com.midas.websolution.board.service;

import com.midas.websolution.board.dao.ElonDao;
import com.midas.websolution.board.vo.BoardVO;

public class ElonServiceImpl implements ElonService {

	private ElonDao elonDao;
	
	public void setElonDao(ElonDao elonDao) {
		this.elonDao = elonDao;
	}
	
	@Override
	public BoardVO ElonTest() {
		// TODO Auto-generated method stub
		
		return elonDao.getOneArticleElon(100);
	}

}
