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

	public void writerBoard(BoardVo bdto) throws Exception{
		sqlSession.insert("board.boardWriter",bdto);
	}
}
