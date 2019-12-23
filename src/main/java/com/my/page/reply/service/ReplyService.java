package com.my.page.reply.service;
import java.util.List;

import com.my.page.reply.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
}
