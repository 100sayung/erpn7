package com.n7.erp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.n7.erp.bean.ac.ApprovalDocument;
import com.n7.erp.service.AccountMM;

@Controller
public class AcHomeController {

	@Autowired
	AccountMM am;

	ModelAndView mav;

	@RequestMapping(value = "Account/acerp", method = RequestMethod.GET)
	public String acerp() {

		return "Account/acerp";
	}

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
		mav = am.getTaxbill(check);
		return mav;
	}

	@RequestMapping(value = "Account/acApproval", method = RequestMethod.GET)
	public ModelAndView acApproval(String check) {
		System.out.println(check);
		mav = am.acApproval(check);
		return mav;
	}

	@RequestMapping(value = "Account/approvalLine", method = RequestMethod.GET)
	public ModelAndView approvalLine() {
		mav = am.approvalLine();
		return mav;
	}

	@RequestMapping(value = "Account/saledetails", method = RequestMethod.GET)
	public ModelAndView saledetails(String check) {
		System.out.println(check);
		mav = am.saledetails(check);
		return mav;
	}

	@RequestMapping(value = "Account/SaleDetaile", method = RequestMethod.GET)
	public ModelAndView SaleDetaile(String check) {
		mav = am.SaleDetaile(check);
		return mav;
	}

	@RequestMapping(value = "Account/approdocument", method = RequestMethod.POST)
	public ModelAndView approdocument(HttpServletRequest request, ApprovalDocument ad, HttpSession session) {
		mav = am.approdocument(request, ad, session);
		return mav;
	}

////////////////////////////////////////////////////////////////////////////////
// 분개전표
////////////////////////////////////////////////////////////////////////////////

//// 분개전표 메인창으로 이동
//@RequestMapping(value = "Account/acMain", method = RequestMethod.GET)
//public String acMain(Locale locale) {
//return "Account/acMain";
//}

	// 분개전표 입력창
	@RequestMapping(value = "Account/acWritefrm", method = RequestMethod.GET)
	public String acWritefrm(Locale locale) {
		return "Account/acWritefrm";
	}

	// 분개전표 전체리스트
	@RequestMapping(value = "Account/acPend", method = RequestMethod.GET)
	public String acPend(Locale locale) {
		return "Account/acPend";
	}

	// 분개전표 임시저장
	@RequestMapping(value = "Account/acDownlist", method = RequestMethod.GET)
	public String acDownlist(Locale locale) {
		return "Account/acDownlist";
	}

	// 내가올린결재안 상세보기
	@RequestMapping(value = "Account/acapPreinfo", method = RequestMethod.GET)
	public String acapPreinfo(Locale locale) {
		return "Account/acapPreinfo";
	}

	// 임시저장 분개전표 상세보기
	@RequestMapping(value = "Account/acCartinfo", method = RequestMethod.GET)
	public String acCartinfo(Locale locale) {
		return "Account/acCartinfo";
	}

	// 내가 결재할 분개전표 상세보기
	@RequestMapping(value = "Account/acApinfo", method = RequestMethod.GET)
	public String acApinfo(Locale locale) {
		return "Account/acCartinfo";
	}

	// 임시저장 목록보기
	@RequestMapping(value = "Account/acpreList", method = RequestMethod.GET)
	public String acpreList(Locale locale) {
		return "Account/acpreList";
	}

}
