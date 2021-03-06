package com.my.page.board.service;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import com.my.page.board.BoardVO;
import com.my.page.board.Criteria;
import com.my.page.board.SearchCriteria;



public interface BoardService {

	//List
    public List<BoardVO> boardList() throws Exception;

	//C
	public void writerBoard(BoardVO bdto) throws Exception;
	
	//R
	public BoardVO boardRead(int bno) throws Exception;
	
	//U
	public void updateBoard(BoardVO bdto) throws Exception;
	
	//D
	public void deleteBoard(int bno) throws Exception;
	
	//게시글 목록
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	//게시글 총갯수
	public int listCount(SearchCriteria scri) throws Exception;
}
