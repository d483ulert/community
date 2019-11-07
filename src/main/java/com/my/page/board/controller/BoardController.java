package com.my.page.board.controller;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.my.page.board.PagingVo;
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
	public String boardList(PagingVo vo, Model model
			,@RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception{
		int total = boardService.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		vo = new PagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", boardService.selectBoard(vo));
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