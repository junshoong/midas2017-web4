package com.naver.cafe.club.vo;

import java.util.List;

import com.naver.cafe.member.vo.MemberVO;
import com.naver.cafe.menu.vo.MenuVO;
import com.naver.cafe.reply.vo.ReplyVO;

public class ClubVO {
	
	private String articleId;
	private String subject;
	private String content;
	private String memberId;
	private String createdDate;
	private String modifiedDate;
	private int readCount;
	private String menuId;
	
	private MemberVO memberVO;
	private MenuVO menuVO;
	
	private int repliesCount;
	private List<ReplyVO> replyVO;
	
	public String getArticleId() {
		return articleId;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public String getMenuId() {
		return menuId;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public MenuVO getMenuVO() {
		return menuVO;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public void setMenuVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}
	public List<ReplyVO> getReplyVO() {
		return replyVO;
	}
	public void setReplyVO(List<ReplyVO> replyVO) {
		this.replyVO = replyVO;
	}
	public int getRepliesCount() {
		return repliesCount;
	}
	public void setRepliesCount(int repliesCount) {
		this.repliesCount = repliesCount;
	}
}
