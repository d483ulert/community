package com.my.page.board.service;
import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.my.page.board.BoardDAO;
import com.my.page.board.BoardVo;

@Repository
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO boardDao;

	@Override
	public List<BoardVo> boardList() throws Exception{
		return boardDao.boardList();
	}
}
