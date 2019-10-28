package com.my.page.board.service;
import java.util.List;
import com.my.page.board.BoardVo;


public interface BoardService {

	public List<BoardVo> boardList() throws Exception;
	
	//C
	public void writerBoard(BoardVo bdto) throws Exception;
	
	//R
	public BoardVo boardRead(int bno) throws Exception;
	
	//U
	public updateBoard(BoardVo bdto) throws Exception;
}
