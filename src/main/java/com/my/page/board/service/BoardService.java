package com.my.page.board.service;
import java.util.List;
import com.my.page.board.BoardVo;
import com.my.page.board.Criteria;

public interface BoardService {

	public List<BoardVo> boardList() throws Exception;
	
	//C
	public void writerBoard(BoardVo bdto) throws Exception;
	
	//R
	public BoardVo boardRead(int bno) throws Exception;
	
	//U
	public void updateBoard(BoardVo bdto) throws Exception;
	
	//D
	public void deleteBoard(int bno) throws Exception;
	
	//페이징
	public List<BoardVo> list(Criteria cri) throws Exception;
	public int listCount() throws Exception;
		

}
