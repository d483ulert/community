package com.my.page.board;
import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.my.page.board.BoardVO;
@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		return sqlSession.selectList("board.boardList"); 
	}
	
	@Override
	public void writerBoard(BoardVO bdto) throws Exception{
		sqlSession.insert("board.boardWriter",bdto);
	}
	
	@Override
	public BoardVO boardRead(int bno) throws Exception{
		return sqlSession.selectOne("board.boardRead",bno);
	}
	@Override
    public void boardUpdate(BoardVO bdto) throws Exception {
		sqlSession.update("board.boardUpdate",bdto);
	}
	
	@Override
	public void boardDelete(int bno) throws Exception{
		sqlSession.delete("board.boardDelete",bno);
	}
	
	@Override
	public void updateViewCnt(int bno) throws Exception{
		sqlSession.update("board.plusViewcnt",bno);
	}
	
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception{
		return sqlSession.selectList("board.selectBoard",scri);
	}
	@Override
	public int listCount(SearchCriteria scri) throws Exception{
		return sqlSession.selectOne("board.countBoard", scri);
	}
	
}

