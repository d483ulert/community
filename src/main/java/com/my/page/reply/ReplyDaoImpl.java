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
}
