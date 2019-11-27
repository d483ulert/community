package com.my.page.board;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.my.page.board.BoardVo;


@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardVo> boardList() throws Exception{
		return sqlSession.selectList("board.boardList");
	}

	@Override
	public void writerBoard(BoardVo bdto) throws Exception{
		sqlSession.insert("board.boardWriter",bdto);
	}
	
	@Override
	public BoardVo boardRead(int bno) throws Exception{
		return sqlSession.selectOne("board.boardRead",bno);
	}
	@Override
    public void boardUpdate(BoardVo bdto) throws Exception {
		sqlSession.update("board.boardUpdate",bdto);
	}
	
	@Override
	public void boardDelete(int bno) throws Exception{
		sqlSession.delete("board.boardDelete",bno);
	}
	
	@Override
	public int countBoard() throws Exception{
		 return sqlSession.selectOne("board.countBoard");
	}
	@Override
	public void updateViewCnt(int bno)throws Exception{
		sqlSession.update("board.plusViewcnt",bno);
	}
	



}
