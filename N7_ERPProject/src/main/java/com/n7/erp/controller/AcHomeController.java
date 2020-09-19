package com.n7.erp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< HEAD
import com.n7.erp.bean.ac.ApprovalDocument;
import com.n7.erp.service.AccountMM;

@Controller
public class AcHomeController {
=======

import com.n7.erp.bean.ac.ApprovalDocument;
import com.n7.erp.service.AccountMM;
import com.n7.erp.service.MemberMM;

@Controller
public class AcHomeController {

	@Autowired
	MemberMM mm;
>>>>>>> origin/JSJ
	
	@Autowired
	AccountMM am;
	
	ModelAndView mav;

<<<<<<< HEAD

=======
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		
//		return "home";
//	}
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login() {
//		
//		return "login";
//	}
//	@RequestMapping(value = "/join", method = RequestMethod.GET)
//	public String joinFrm() {
//		
//		return "join";
//	}
//	@RequestMapping(value = "/introducecompany", method = RequestMethod.GET)
//	public String introduceCompany() {
//	
//		return "introducecompany";
//	}
//	@RequestMapping(value = "/erpapply", method = RequestMethod.GET)
//	public String erpApply() {
//		
//		return "erpapply";
//	}
>>>>>>> origin/JSJ
	@RequestMapping(value = "Account/acerp", method = RequestMethod.GET)
	public String acerp() {
		
		return "Account/acerp";
	}
<<<<<<< HEAD

=======
	
//	@RequestMapping(value = "/grafe", method = RequestMethod.GET)
//	public String grafe() {
//		
//		return "grafe";
//	}
>>>>>>> origin/JSJ
	@RequestMapping(value = "Account/openTable", method = RequestMethod.GET)
	public String openTable() {
	
		return "Account/openTable";
	}
	@RequestMapping(value = "Account/comPany", method = RequestMethod.GET)
	public String comPany() {
		
		return "Account/comPany";
	}
	@RequestMapping(value = "Account/taxbill", method = RequestMethod.GET)
	public ModelAndView taxbill(String check) {
		System.out.println(check);
		mav=am.getTaxbill(check);
		return mav;
	}
<<<<<<< HEAD

=======
//	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
//	public ModelAndView memberJoin(Member mb) {
//		mav=mm.memberJoin(mb);
//		return mav;
//	}
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(Member mb, HttpSession session) {
//		mav=mm.access(mb,session);
//		return mav;
//	}
//	@RequestMapping(value = "/logout", method = RequestMethod.POST)
//	public ModelAndView logout(HttpSession session) {
//		mav=mm.logout(session);
//		return mav;
//	}
//	@RequestMapping(value = "/erpboard", method = RequestMethod.GET)
//	public String erpBoard() {
//		
//		return "erpboard";
//	}
>>>>>>> origin/JSJ
	@RequestMapping(value = "Account/acApproval", method = RequestMethod.GET)
	public ModelAndView acApproval(String check) {
		System.out.println(check);
		mav=am.acApproval(check);
		return mav;
	}
	@RequestMapping(value = "Account/approvalLine", method = RequestMethod.GET)
	public ModelAndView approvalLine() {
		mav=am.approvalLine();
		return mav;
	}
	@RequestMapping(value = "Account/saledetails", method = RequestMethod.GET)
	public ModelAndView saledetails(String check) {
		System.out.println(check);
		mav=am.saledetails(check);
		return mav;
	}
	@RequestMapping(value = "Account/SaleDetaile", method = RequestMethod.GET)
	public ModelAndView SaleDetaile(String check) {
		mav=am.SaleDetaile(check);
		return mav;
	}
	
	@RequestMapping(value = "Account/approdocument", method = RequestMethod.POST)
	public  ModelAndView approdocument(HttpServletRequest request, ApprovalDocument ad, HttpSession session) {
		mav=am.approdocument(request,ad,session);
		return mav;
	}
	
}
