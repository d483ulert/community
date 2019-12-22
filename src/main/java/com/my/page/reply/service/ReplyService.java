package com.my.page.reply.service;
import java.util.List;

import com.my.page.reply.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> readReply(int bno) throws Exception;
}
