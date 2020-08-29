package com.n7.erp.controller;

import java.util.logging.FileHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.bean.hr.Member;
import com.n7.erp.service.HrMM;
import com.n7.erp.service.MemberMM;


@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	ModelAndView mav;
	
	@Autowired
	private MemberMM mm;
	@Autowired
	private HrMM hm;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("로그창으로 이동");
		return "/home/home";
	}
	@RequestMapping(value = "/introducecompany", method = RequestMethod.GET)
	public String introduceCompany() {
		logger.info("로그창으로 이동");
		return "/home/introducecompany";
	}
	@RequestMapping(value = "/erpboard", method = RequestMethod.GET)
	public String erpBoard() {
		logger.info("로그창으로 이동");
		return "/home/erpboard";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("로그창으로 이동");
		return "/home/login";
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.info("로그창으로 이동");
		return "/home/join";
	}
	@RequestMapping(value = "/erpapply", method = RequestMethod.GET)
	public String erpApply() {
		logger.info("로그창으로 이동");
		return "/home/erpapply";
	}
	
	
	@PostMapping(value="/access")
	public ModelAndView access(Member mb, HttpSession session) {
		mav = mm.access(mb, session);
		return mav;
	}
	@PostMapping(value="/join")
	public ModelAndView join(MultipartHttpServletRequest multi) {
		mav = mm.join(multi);
		return mav;
	}
	@PostMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/home/home";
	}
	
	@GetMapping(value="/main")
	public String main() {
		return "/hr/hrMain";
	}
	
}
