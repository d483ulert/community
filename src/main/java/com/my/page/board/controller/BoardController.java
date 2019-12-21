package com.my.page.board.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.my.page.board.BoardDAO;
import com.my.page.board.BoardVo;
import com.my.page.board.Criteria;
import com.my.page.board.PageMaker;
import com.my.page.board.SearchCriteria;
import com.my.page.board.service.BoardServiceImpl;

import ch.qos.logback.classic.Logger;

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

	
	@RequestMapping(value="/boardList", method = RequestMethod.GET)
	public String boardList( Model model,SearchCriteria scri) throws Exception{
		
		model.addAttribute("list", boardService.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);



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
    
    @RequestMapping(value="boardRead", method=RequestMethod.GET)
    public String boardRead(@RequestParam int bno, Model model) throws Exception{
    	BoardVo data = boardService.boardRead(bno);
    	model.addAttribute("data",data);
    	return"/board/boardRead";	
    }
    
    @RequestMapping(value="updatepage", method=RequestMethod.GET)
    public String boardUpdate(@RequestParam int bno, Model model) throws Exception{
    	BoardVo data = boardService.boardRead(bno);
    	model.addAttribute("data",data);
    	return "/board/boardUpdate";
    	
    }
    
    @RequestMapping(value="boardUpdate", method=RequestMethod.POST)
    public String boardUpdatedo(BoardVo bdto) throws Exception {
    	boardService.updateBoard(bdto);
    	return "redirect:/board/boardList"; 
    }
    @RequestMapping(value="delete",method=RequestMethod.GET)
    public String boardDelete(@RequestParam int bno) throws Exception{
    	boardService.deleteBoard(bno);
    	return "redirect:/board/boardList"; 
    }
}