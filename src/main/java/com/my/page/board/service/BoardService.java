package com.my.page.board.service;
import java.util.List;
import com.my.page.board.BoardVo;


public interface BoardService {

	public List<BoardVo> boardList() throws Exception;
}
