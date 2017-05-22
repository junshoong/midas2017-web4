package com.naver.cafe.reply.dao;

import java.util.List;

import com.naver.cafe.reply.vo.ReplyVO;

public interface ReplyDao  {
	
	public static final String RP = "ReplyDao";
	public List<ReplyVO> selectAllReplies(String articleId);
	public int insertOneReply(ReplyVO replyVO);
	public int updateCountReply(String replyId);
}
