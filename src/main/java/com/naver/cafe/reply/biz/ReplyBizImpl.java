package com.naver.cafe.reply.biz;

import java.util.List;

import com.naver.cafe.reply.dao.ReplyDao;
import com.naver.cafe.reply.vo.ReplyVO;

public class ReplyBizImpl implements ReplyBiz {
	
	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<ReplyVO> getAllReplies(String articleId) {
		return replyDao.selectAllReplies(articleId);
	}

	@Override
	public boolean insertOneReply(ReplyVO replyVO) {
		return replyDao.insertOneReply(replyVO) > 0;
	}

	@Override
	public boolean updateCountReply(String replyId) {
		return replyDao.updateCountReply(replyId) > 0;
	}

}
