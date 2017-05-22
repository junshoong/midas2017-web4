package com.naver.cafe.reply.vo;

import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.member.vo.MemberVO;

public class ReplyVO {

	private int level;
	private String replyId;
	private String articleId;
	private String subject;
	private String content;
	private String memberId;
	private String createdDate;
	private String modifiedDate;
	private int recommendCount;
	private String parentReplyId;
	
	private ClubVO clubVO;
	private MemberVO memberVO;
	private ReplyVO parentReplyVO;
	
	public String getReplyId() {
		return replyId;
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
	public int getRecommendCount() {
		return recommendCount;
	}
	
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getArticleId() {
		return articleId;
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
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ClubVO getClubVO() {
		return clubVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public ReplyVO getParentReplyVO() {
		return parentReplyVO;
	}
	public void setClubVO(ClubVO clubVO) {
		this.clubVO = clubVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public void setParentReplyVO(ReplyVO parentReplyVO) {
		this.parentReplyVO = parentReplyVO;
	}
	public String getParentReplyId() {
		return parentReplyId;
	}
	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
