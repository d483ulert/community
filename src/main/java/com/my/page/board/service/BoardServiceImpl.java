package com.my.page.board.service;
import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.my.page.board.BoardDAO;
import com.my.page.board.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO boardDao;

	@Override
	public List<BoardVo> boardList() throws Exception{
		return boardDao.boardList();
	}
	@Override
	public void writerBoard(BoardVo bdto) throws Exception{
		boardDao.writerBoard(bdto);
	}
	
    @Override
    public BoardVo boardRead(int bno) throws Exception {
        return boardDao.boardRead(bno);
    }
    @Override
    public void updateBoard(BoardVo bdto) throws Exception{
    	boardDao.boardUpdate(bdto);
    }
}
