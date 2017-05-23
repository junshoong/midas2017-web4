package com.midas.websolution.board.vo;

import java.util.List;

import com.midas.websolution.common.pager.Pager;
import com.midas.websolution.common.pager.PagerFactory;

public class BoardSearchVO {
	
	private List<BoardVO> boardList;
	private Pager pager;
	
	private int pageNo;
	


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	private int endArticleNumber;
	private int startArticleNumber;
	
	public int getPageNo() {
		return pageNo;
	}
	
	public int getEndArticleNumber() {
		return endArticleNumber;
	}

	public void setEndArticleNumber(int endArticleNumber) {
		this.endArticleNumber = endArticleNumber;
	}

	public int getStartArticleNumber() {
		return startArticleNumber;
	}

	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}


	
	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Pager getPager() {
		
		if(pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		
		return pager;
	}
	
}
