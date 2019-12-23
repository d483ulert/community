package com.my.page.reply;
import java.util.List;

public interface ReplyDao {
	
	
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
}
