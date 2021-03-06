package com.my.page.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.my.page.member.service.Sha256;
import com.my.page.member.Member;
import com.my.page.member.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	// Join
	@RequestMapping("/joinForm")
	public String joinForm(Member member) {		
		return "/member/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(Member member ) {
		String encryPassword = Sha256.encrypt(member.getMemPw());
		member.setMemPw(encryPassword);
		System.out.println("두번째:" + member.getMemPw());


		service.memberRegister(member);	
		return "/member/joinOk";
	}
	
	// Login
	@RequestMapping("/loginForm")
	public String loginForm(Member member) {
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memLogin(Member member, HttpSession session) {
		
		Member mem = service.memberSearch(member);
		if(mem == null) 
			return "/member/loginForm";
		
		session.setAttribute("member", mem);
		
		return "/member/loginOk";
	}
	
	// Logout
	@RequestMapping("/logout")
	public String memLogout(Member member, HttpSession session) {
		
		session.invalidate();
		
		return "/member/logoutOk";
	}
	
	// Modify
	@RequestMapping(value = "/modifyForm")
	public ModelAndView modifyForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", service.memberSearch(member));
		
		mav.setViewName("/member/modifyForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(Member member, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member mem = service.memberModify(member);
		if(mem == null) {
			mav.setViewName("/member/modifyForm");
		} else { 
			session.setAttribute("member", mem);
			
			mav.addObject("memAft", mem);
			mav.setViewName("/member/modifyOk");
		}
		
		return mav;
	}
	
	// Remove
	@RequestMapping("/removeForm")
	public ModelAndView removeForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session =  request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		mav.addObject("member", member);
		mav.setViewName("/member/removeForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String memRemove(Member member, HttpServletRequest request) {
		
		int result = service.memberRemove(member);
		
		if(result == 0)
			return "/member/removeForm";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/member/removeOk";
	}	
}
