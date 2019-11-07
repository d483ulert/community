package com.my.page.board.service;
import java.util.List;
import com.my.page.board.BoardVo;
import com.my.page.board.PagingVo;


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
	
	// 게시물 총 갯수
	public int countBoard() throws Exception;

	// 페이징 처리 게시글 조회
	public List<BoardVo> selectBoard(PagingVo vo) throws Exception;
}
