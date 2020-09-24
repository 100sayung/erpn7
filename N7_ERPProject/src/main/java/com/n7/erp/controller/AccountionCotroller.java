package com.n7.erp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.ac.A_company;
import com.n7.erp.bean.ac.Account;
import com.n7.erp.bean.ApprovalDocu;
import com.n7.erp.bean.ac.SaleInfo;
import com.n7.erp.bean.ac.approvalLine;
import com.n7.erp.service.AccountMM;

@RestController
@RequestMapping(value = "/rest")
public class AccountionCotroller {
	@Autowired
	AccountMM am;

	ModelAndView mav;

	private static final Logger logger = LoggerFactory.getLogger(AccountionCotroller.class);

	@PostMapping(value = "/Account/insertcomlist", produces = "application/json;charset=utf-8")
	public Map<String, List<A_company>> insertcomlist(A_company ac, HttpSession session) {
		Map<String, List<A_company>> aMap = am.insertcomlist(ac, session);
		return aMap;
	}

	@PostMapping(value = "/Account/searchcode", produces = "application/json;charset=utf-8")
	public Map<String, List<A_company>> searchcode(A_company ac, String code) {
		System.out.println(code);
		Map<String, List<A_company>> aMap = am.searchcode(ac, code);
		return aMap;
	}

	@PostMapping(value = "/Account/getList", produces = "application/json;charset=utf-8")
	public Map<String, List<SaleInfo>> getList(String code) {
		System.out.println(code);
		Map<String, List<SaleInfo>> sMap = am.getList(code);
		return sMap;
	}

	/*
	 * @PostMapping(value = "/selectsale",produces="application/json;charset=utf-8"
	 * ) public Map<String, List<SaleInfo>> selectsale( String search) {
	 * System.out.println(search); Map<String, List<SaleInfo>>
	 * sMap=am.selectsale(search); return sMap; }
	 */
	@PostMapping(value = "/Account/saleinsert")
	public ModelAndView saleinsert(HttpServletRequest request, SaleInfo si, HttpSession session) {
		mav = am.saleinsert(request, si, session);
		return mav;
	}

	@PostMapping(value = "/Account/deleteCom", produces = "application/json;charset=utf-8")
	public Map<String, List<A_company>> deleteCom(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		System.out.println(cnt);
		String[] strArray = ARR.split(",");
		System.out.println(strArray);
		Map<String, List<A_company>> aMap = am.deleteCom(cnt, strArray);
		return aMap;
	}

	@PostMapping(value = "/Account/deleteSale", produces = "application/json;charset=utf-8")
	public Map<String, List<SaleInfo>> deleteSale(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		String[] strArray = ARR.split(",");
		Map<String, List<SaleInfo>> aMap = am.deleteSale(cnt, strArray);
		return aMap;
	}

	@PostMapping(value = "/Account/addApproval", produces = "application/json;charset=utf-8")
	public Map<String, List<approvalLine>> addApprovale(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		String[] strArray = ARR.split(",");
		Map<String, List<approvalLine>> aMap = am.addApproval(cnt, strArray);
		return aMap;
	}

	@PostMapping(value = "/Account/approLinecom", produces = "application/json;charset=utf-8")
	public Map<String, List<approvalLine>> approLinecom(String code1) {
		String[] code01 = code1.split(",");

		System.out.println(code01[0]);
		Map<String, List<approvalLine>> aMap = am.approLinecom(code01);
		return aMap;
	}

	@PostMapping(value = "/Account/searchName", produces = "application/json;charset=utf-8")
	public Map<String, List<approvalLine>> searchName(String name) {
		Map<String, List<approvalLine>> aMap = am.searchName(name);
		return aMap;
	}

	@GetMapping(value = "/Account/serchcomlist", produces = "application/json;charset=utf-8")
	public Map<String, List<A_company>> serchcomlist() {
		Map<String, List<A_company>> aMap = am.serchcomlist();
		return aMap;
	}

	@GetMapping(value = "/Account/getsaleList", produces = "application/json;charset=utf-8")
	public Map<String, List<SaleInfo>> getsaleList() {
		Map<String, List<SaleInfo>> sMap = am.getsaleList();
		return sMap;
	}

	@GetMapping(value = "/Account/getMyInfo", produces = "application/json;charset=utf-8")
	public Map<String, List<approvalLine>> getMyInfo(HttpSession session) {
		Map<String, List<approvalLine>> mMap = am.getMyInfo(session);
		return mMap;
	}

	@PostMapping(value = "/Account/getpkind", produces = "application/json;charset=utf-8")
	public Map<String, List<SaleInfo>> getpkind(String pkind) {
		Map<String, List<SaleInfo>> sMap = am.getpkind(pkind);
		return sMap;
	}

	@PostMapping(value = "/Account/selectSearch", produces = "application/json;charset=utf-8")
	public Map<String, List<SaleInfo>> selectSearch(String select, String choice) {
		System.out.println(select);
		System.out.println(choice);
		Map<String, List<SaleInfo>> sMap = am.selectSearch(select, choice);
		return sMap;
	}

	@PostMapping(value = "/Account/comparecode", produces = "application/json;charset=utf-8")
	public Map<String, List<ApprovalDocu>> comparecode(String code) {
		System.out.println(code);
		Map<String, List<ApprovalDocu>> sMap = am.comparecode(code);
		return sMap;
	}

	///////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////

	// 분개전표 작성
	@PostMapping(value = "Account/actempoInsert", produces = "application/json;charset=utf-8")
	public int acCart(Account ac, HttpSession session) {
		logger.info("임시저장 acCart");
		int a = am.actempoInsert(ac, session);
		return a; // DAO
	}

	// 내가올린 결재안 목록
	@GetMapping(value = "Account/apupPaymentList", produces = "application/json;charset=utf-8")
	public Map<String, List<ApprovalDocu>> apupPaymentList(HttpSession session) {
		Map<String, List<ApprovalDocu>> pMap = am.apupPaymentList(session);
		return pMap;
	}

	// 내가올린 결재안 상세보기
	@GetMapping(value = "Account/apRequest", produces = "application/json;charset=utf-8")
	public ModelAndView acRequest(String j_docunum) {
		mav = am.acRequest(j_docunum);
		System.out.println(j_docunum);
		return mav;
	}

	// 내가받은 결재안 목록
	@GetMapping(value = "Account/apdownPaymentList", produces = "application/json;charset=utf-8")
	public Map<String, List<ApprovalDocu>> apdownPaymentList(HttpSession session) {
		Map<String, List<ApprovalDocu>> pMap = am.apdownPaymentList(session);
		return pMap;
	}
	
	// 내가받은 결재안 상세보기
	@GetMapping(value = "Account/acRequest2", produces = "application/json;charset=utf-8")
	public ModelAndView acRequest2(String j_docunum) {
		mav = am.acRequest2(j_docunum);
		System.out.println(j_docunum);
		return mav;
	}


	// 임시저장 결재안 목록
	@GetMapping(value = "Account/acTemporaryList", produces = "application/json;charset=utf-8")
	public Map<String, List<Account>> acTemporaryList(HttpSession session) {
		Map<String, List<Account>> aMap = am.acTemporaryList(session);
		return aMap;
	}

	// 임시저장 결재안 상세보기
	@GetMapping(value = "Account/acRequest3", produces = "application/json;charset=utf-8")
	public ModelAndView acRequest3(String j_docunum) {
		mav = am.acRequest3(j_docunum);
		System.out.println(j_docunum);
		return mav;
	}


	// 내문서결재요청(업데이트)
	@PostMapping(value = "Account/acSign", produces = "application/json;charset=utf-8")
	@ResponseBody
	public ModelAndView acSign(Account ac, ApprovalDocu ap, HttpServletRequest req, HttpServletResponse rep,
			HttpSession session) {
		logger.info("acSign 결재요청");
		mav = am.acSign(ac, ap, req, rep, session);
		return mav; // DAO
	}

	// 다른사람이 내문서 결재(업데이트)
	@PostMapping(value = "Account/acSign2", produces = "application/json;charset=utf-8")
	@ResponseBody
	public ModelAndView acSign2(Account ac, ApprovalDocu ap, HttpServletRequest req, HttpServletResponse rep,
			HttpSession session) {
		logger.info("acSign2 결재요청");
		mav = am.acSign2(ac, ap, req, rep, session);
		return mav; // DAO
	}

	// 결재안 삭제
	@RequestMapping(value = "Account/acDelete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public int acDelete(String j_docunum, Account ac, HttpServletRequest req, HttpServletResponse rep) {
		System.out.println(j_docunum);
		logger.info("acDelete 결재안 삭제요청");
		int a = am.acDelete(j_docunum, ac, req, rep);
		return (int) a; // DAO
	}

	// 반려(업데이트)
	@RequestMapping(value = "Account/acBack", produces = "application/json;charset=utf-8")
	@ResponseBody
	public ModelAndView acBack(Account ac, ApprovalDocu ap, HttpServletRequest req, HttpServletResponse rep) {
		System.out.println(ac.getJ_docunum());
		logger.info("acBack 반려요청");
		mav = am.acBack(ac, ap, req, rep);
		return mav; // DAO
	}

	// 내가올린결재안에서 이름찾아오기
	@PostMapping(value = "/Account/getApprinfo", produces = "application/json;charset=utf-8")
	public Map<String, List<approvalLine>> getApprinfo(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		String[] strArray = ARR.split(",");
		Map<String, List<approvalLine>> mMap = am.getApprinfo(cnt,strArray);
		return mMap;
	}

}
