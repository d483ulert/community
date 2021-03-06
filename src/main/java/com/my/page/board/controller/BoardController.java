package com.my.page.board.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.page.board.BoardDAO;
import com.my.page.board.BoardVO;
import com.my.page.board.Criteria;
import com.my.page.board.PageMaker;
import com.my.page.board.SearchCriteria;
import com.my.page.board.service.BoardServiceImpl;
import com.my.page.reply.ReplyVO;
import com.my.page.reply.service.ReplyService;

import com.my.page.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController{
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@Inject
	BoardService boardService;
	@Inject
	ReplyService replyService;

	
	//게시판 목록
	@RequestMapping(value="/boardList", method = RequestMethod.GET)
	public String boardList(Model model,@ModelAttribute("scri")SearchCriteria scri) throws Exception{
		
		model.addAttribute("list", boardService.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);



		return "/board/boardList";
	}

    // 게시글 쓰기	
	@RequestMapping("/boardWrite")
	public String boardWrite(Model model)throws Exception {
		return "/board/boardWrite";
	}

    @RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWriter(BoardVO bdto) throws Exception{
		boardService.writerBoard(bdto);
		return "redirect:/board/boardList";
	}
    
    // 게시글 읽기
    @RequestMapping(value="boardRead", method=RequestMethod.GET)
    public String boardRead(BoardVO boardVO,@RequestParam int bno, Model model,
    		@ModelAttribute("scri") SearchCriteria scri) throws Exception{
    	BoardVO data = boardService.boardRead(bno);
    	model.addAttribute("data",data);
		model.addAttribute("scri", scri);

    	List<ReplyVO> replyList = replyService.readReply(boardVO.getBno());

    	model.addAttribute("replyList",replyList);

    	return "/board/boardRead";	
    }
    
    //게시글 수정
    @RequestMapping(value="updatepage", method=RequestMethod.GET)
    public String boardUpdate(@RequestParam int bno, Model model,
    		@ModelAttribute("scri") SearchCriteria scri,RedirectAttributes rttr) throws Exception{
    	BoardVO data = boardService.boardRead(bno);
    	model.addAttribute("data",data);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

    	return "/board/boardUpdate";
    	
    }
    
    @RequestMapping(value="boardUpdate", method=RequestMethod.POST)
    public String boardUpdatedo(BoardVO bdto) throws Exception {
    	boardService.updateBoard(bdto);
    	return "redirect:/board/boardList"; 
    }
    
    //게시판 삭제
    @RequestMapping(value="delete",method=RequestMethod.GET)
    public String boardDelete(@RequestParam int bno,
    		@ModelAttribute("scri")SearchCriteria scri,RedirectAttributes rttr ) throws Exception{
    	boardService.deleteBoard(bno);
    	
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

    	return "redirect:/board/boardList"; 
    }
    
    //댓글 쓰기
	@RequestMapping(value="/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVO vo, @ModelAttribute("scri")SearchCriteria scri,RedirectAttributes rttr) throws Exception {
		logger.info("reply Write");
		replyService.writeReply(vo);

		
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
    	return "redirect:/board/boardRead";
	}
	
	//댓글 수정 GET
	@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
	public String replyUpdateView( ReplyVO vo, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		
		model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
		model.addAttribute("scri", scri);
		
		return "/board/replyUpdateView";
	}
	
	//댓글 수정 POST
	@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(ReplyVO vo,@ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		
		replyService.updateReply(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
    	return "redirect:/board/boardRead";
	}
	
		//댓글 삭제 GET
		@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(ReplyVO vo,@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
			
			model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			

			return "/board/replyDeleteView";
		}
		
		//댓글 삭제
		@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
		public String replyDelete(ReplyVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			replyService.deleteReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/boardRead";
		}

}