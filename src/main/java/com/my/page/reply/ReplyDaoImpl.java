package com.my.page.reply;
import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception{
		return sqlSession.selectList("reply.readreply",bno);
	}
	
	@Override
	public void writeReply(ReplyVO vo) throws Exception{
		sqlSession.insert("reply.writerreply",vo);
	}
	
	@Override
	public void updateReply(ReplyVO vo) throws Exception{
		sqlSession.update("reply.updateReply",vo);
	}
	
	@Override
	public void deleteReply(ReplyVO vo) throws Exception{
		sqlSession.delete("reply.deleteReply",vo);
	}
	
	public ReplyVO selectReply(int rno) throws Exception{
		return sqlSession.selectOne("reply.selectReply",rno);
	}
	
}
