package com.naver.cafe.member.vo;

public class MemberVO {
	private String memberId;
	private String nickName;
	private String memberPassword;
	private String auth;
	
	
	public String getMemberId() {
		return memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public String getAuth() {
		return auth;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
