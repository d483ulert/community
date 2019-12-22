package com.my.page.reply.service;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.my.page.reply.ReplyDao;
import com.my.page.reply.ReplyVO;


@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDao dao;
	
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return dao.readReply(bno); 
	}
	@Override
	public void writeReply(ReplyVO vo) throws Exception{
		dao.writeReply(vo);
	}

}
