package com.n7.erp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.ac.A_company;
import com.n7.erp.bean.ac.ApprovalDocument;
import com.n7.erp.bean.ac.Approvaldocu;
import com.n7.erp.bean.ac.SaleInfo;
import com.n7.erp.bean.ac.approvalLine;
import com.n7.erp.service.AccountMM;

@RestController
@RequestMapping(value="/rest")
public class AccountionCotroller {
	@Autowired
	AccountMM am;
	
	ModelAndView mav;
	
	@PostMapping(value = "/Account/insertcomlist",produces="application/json;charset=utf-8" )
	public  Map<String, List<A_company>> insertcomlist( A_company ac, HttpSession session) {
	Map<String, List<A_company>> aMap=am.insertcomlist(ac, session);
		return aMap;
	}
	
	@PostMapping(value = "/Account/searchcode",produces="application/json;charset=utf-8" )
	public  Map<String, List<A_company>> searchcode(A_company ac, String code) {
		System.out.println(code);
		Map<String, List<A_company>> aMap=am.searchcode(ac,code);
		return aMap;
	}
	@PostMapping(value = "/Account/getList",produces="application/json;charset=utf-8" )
	public  Map<String, List<SaleInfo>> getList(String code) {
		System.out.println(code);
		Map<String, List<SaleInfo>> sMap=am.getList(code);
		return sMap;
	}

	/*
	 * @PostMapping(value = "/selectsale",produces="application/json;charset=utf-8"
	 * ) public Map<String, List<SaleInfo>> selectsale( String search) {
	 * System.out.println(search); Map<String, List<SaleInfo>>
	 * sMap=am.selectsale(search); return sMap; }
	 */
	@PostMapping(value = "/Account/saleinsert" )
	public  ModelAndView saleinsert( HttpServletRequest request, SaleInfo si, HttpSession session) {
		mav=am.saleinsert(request, si,session);
		return mav;
	}
	
	
	@PostMapping(value = "/Account/deleteCom",produces="application/json;charset=utf-8" )
	public  Map<String, List<A_company>> deleteCom(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		System.out.println(cnt);
        String [] strArray = ARR.split(",");
        System.out.println(strArray);
		Map<String, List<A_company>> aMap=am.deleteCom(cnt,strArray);
		return aMap;
	}
	@PostMapping(value = "/Account/deleteSale",produces="application/json;charset=utf-8" )
	public  Map<String, List<SaleInfo>> deleteSale(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		String [] strArray = ARR.split(",");
		Map<String, List<SaleInfo>> aMap=am.deleteSale(cnt,strArray);
		return aMap;
	}
	@PostMapping(value = "/Account/addApproval",produces="application/json;charset=utf-8" )
	public  Map<String, List<approvalLine>> addApprovale(String CNT, String ARR) {
		int cnt = Integer.parseInt(CNT);
		String [] strArray = ARR.split(",");
		Map<String, List<approvalLine>> aMap=am.addApproval(cnt,strArray);
		return aMap;
	}
	@PostMapping(value = "/Account/approLinecom",produces="application/json;charset=utf-8")
	public  Map<String, List<approvalLine>> approLinecom(String code1) {
		String [] code01 = code1.split(",");
//		String [] code02 = code2.split(",");
		
		System.out.println(code01[0]);
		//System.out.println(code02[0]);
		Map<String, List<approvalLine>> aMap=am.approLinecom(code01);
		return aMap;
	}
	@PostMapping(value = "/Account/searchName",produces="application/json;charset=utf-8" )
	public  Map<String, List<approvalLine>> searchName(String name) {
		Map<String, List<approvalLine>> aMap=am.searchName(name);
		return aMap;
	}
	
	@GetMapping(value = "/Account/serchcomlist",produces="application/json;charset=utf-8" )
	public  Map<String, List<A_company>> serchcomlist() {
		Map<String, List<A_company>> aMap=am.serchcomlist();
		return aMap;
	}
	@GetMapping(value = "/Account/getsaleList",produces="application/json;charset=utf-8" )
	public  Map<String, List<SaleInfo>> getsaleList() {
		Map<String, List<SaleInfo>> sMap=am.getsaleList();
		return sMap;
	}
	@PostMapping(value = "/Account/getpkind",produces="application/json;charset=utf-8" )
	public  Map<String, List<SaleInfo>> getpkind(String pkind) {
		Map<String, List<SaleInfo>> sMap=am.getpkind(pkind);
		return sMap;
	}
	@PostMapping(value = "/Account/selectSearch",produces="application/json;charset=utf-8" )
	public  Map<String, List<SaleInfo>> selectSearch(String select, String choice) {
		System.out.println(select);
		System.out.println(choice);
		Map<String, List<SaleInfo>> sMap=am.selectSearch(select , choice);
		return sMap;
	}
	
	@PostMapping(value = "/Account/comparecode",produces="application/json;charset=utf-8" )
	public  Map<String, List<Approvaldocu>> comparecode(String code) {
		System.out.println(code);
		Map<String, List<Approvaldocu>> sMap=am.comparecode(code);
		return sMap;
	}
	
}
