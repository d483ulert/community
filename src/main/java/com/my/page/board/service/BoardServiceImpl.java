package com.my.page.board.service;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.my.page.board.BoardDAO;
import com.my.page.board.BoardVO;
import com.my.page.board.Criteria;
import com.my.page.board.SearchCriteria;

@Transactional
@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO boardDao;
    
	@Override
    public List<BoardVO> boardList() throws Exception {
        return boardDao.boardList(); 
    }

	@Override
	public void writerBoard(BoardVO bdto) throws Exception{
		boardDao.writerBoard(bdto);
	}
	
    @Override
    public BoardVO boardRead(int bno) throws Exception {
    	boardDao.updateViewCnt(bno);
        return boardDao.boardRead(bno);
    }
    
    @Override
    public void updateBoard(BoardVO bdto) throws Exception{
    	boardDao.boardUpdate(bdto);
    }
    
    @Override
    public void deleteBoard(int bno) throws Exception{
    	boardDao.boardDelete(bno);
    }
    
    @Override
    public List<BoardVO> list(SearchCriteria scri) throws Exception{
    	return boardDao.list(scri);
    }
    @Override
    public int listCount(SearchCriteria scri) throws Exception{
    	return boardDao.listCount(scri);
    }
    

}

