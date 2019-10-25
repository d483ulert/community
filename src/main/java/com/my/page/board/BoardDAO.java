package com.my.page.board;
import java.util.List;
import com.my.page.board.BoardVo;

public interface BoardDAO {

	public List<BoardVo> boardList() throws Exception;
	
	public void writerBoard(BoardVo bdto) throws Exception;
	
	public BoardVo boardRead(int bno) throws Exception;
}
