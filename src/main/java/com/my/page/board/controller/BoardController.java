package com.my.page.board.controller;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.page.board.BoardDAO;
import com.my.page.board.BoardVo;
import com.my.page.board.service.BoardServiceImpl;
import com.my.page.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController{
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@Inject
	BoardService boardService;

	@RequestMapping("/boardList")
	public String boardList(Model model) throws Exception{
		List<BoardVo> list = boardService.boardList();
		model.addAttribute("list",list);
		return "/board/boardList";
	}

	@RequestMapping("/boardWrite")
	public String boardWrite(Model model)throws Exception {
		return "/board/boardWrite";
	}

    @RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWriter(BoardVo bdto) throws Exception{
		boardService.writerBoard(bdto);
		return "redirect:/board/boardList";
		
	}
}
