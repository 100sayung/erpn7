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

import com.n7.erp.bean.ConsultingBoard;
import com.n7.erp.bean.Member;
import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.service.ConsultingBoardMM;
import com.n7.erp.service.HrMM;
import com.n7.erp.service.MemberMM;

//전부 이동관련
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	ModelAndView mav;
	
	@Autowired
	private MemberMM mm;
	@Autowired
	private ConsultingBoardMM cbm;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("");
		return "/home/home";
	}
	@RequestMapping(value = "/managermode/managermode", method = RequestMethod.GET)
	public String managermode() {

		return "/managermode/managermode";
	}
	@RequestMapping(value = "/managermode/Company", method = RequestMethod.GET)
	public String Company() {
		
		return "/managermode/Company";
	}
	@RequestMapping(value = "/introducecompany", method = RequestMethod.GET)
	public String introduceCompany() {
		logger.info("");
		return "/home/introducecompany";
	}
	@RequestMapping(value = "/home/erpboard", method = RequestMethod.GET)
	public ModelAndView erpBoard() {
		logger.info("");
		mav=cbm.moveBoardList();
		return mav;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("");
		return "/home/login";
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.info("");
		return "/home/join";
	}
	@RequestMapping(value = "/erpapply", method = RequestMethod.GET)
	public String erpApply() {
		logger.info("");
		return "/home/erpapply";
	}
	@GetMapping(value="/adminpage")
	public String moveAdminPage() {
		return "/home/adminpage";
	}
	@GetMapping(value="/companymanager")
	public String moveCompanyManager() {
		return "/home/companymanager";
	}
	@GetMapping(value="/membermanager")
	public String moveMemberManager() {
		return "/home/membermanager";
	}
	@GetMapping(value="/findid")
	public String findId() {
		return "/home/findid";
	}
	@GetMapping(value="/findpassword")
	public String findPassword() {
		return "/home/findpassword";
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
		return "/myInfo/myInfo";
	}
	@GetMapping(value="/myinfo/myinfo")
	public ModelAndView myinfoMain(HttpSession session) {
		mav = mm.moveMyInfo(session);
		return mav;
	}
	@GetMapping(value="/hr/hr")
	public String hrMain() {
		return "/hr/hrMain";
	}
	
	//게시글 페이지로 이동
	   @RequestMapping(value = "/writeFrm", method = RequestMethod.GET)
	   public String write() {
	      logger.info("게시글 창으로 이동");
	      return "writeFrm";
	   }
	   
	   //게시글 작성
	   @RequestMapping(value = "/writeBoard", method = RequestMethod.POST)
	   public ModelAndView writeBoard(ConsultingBoard board) {
	      mav=cbm.writeBoard(board);
	      return mav;
	   }
	   //게시글 수정
	   @RequestMapping(value = "/boardmodify", method = RequestMethod.POST)
	   public ModelAndView boardmodify(ConsultingBoard board) {
	      mav=cbm.boardmodify(board);
	      return mav;
	   }
	   
	   //게시글 수정페이지로 이동
	   @RequestMapping(value = "/boardmodifyajax", method = RequestMethod.POST)
	   public @ResponseBody String boardmodifyajax(Integer num) {
	      System.out.println("수정페이지 번호 값="+num);
	      String result=cbm.boardmodifyajax(num);
	      return result;
	   }
	   //게시글 삭제
	   @RequestMapping(value = "/writelistdelete", method = RequestMethod.POST)
	   public ModelAndView writelistdelete(Integer num) {
	      System.out.println("번호 값="+num);
	      mav=cbm.writelistdelete(num);
	      return mav;
	   }
}
