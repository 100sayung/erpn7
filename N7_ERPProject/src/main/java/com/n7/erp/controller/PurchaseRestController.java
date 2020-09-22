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

import com.n7.erp.bean.ApprovalDocu;
import com.n7.erp.bean.ps.Purchase;
import com.n7.erp.bean.ps.PurchaseApproval;
import com.n7.erp.bean.ps.Return;
import com.n7.erp.bean.ps.approvalLine;
import com.n7.erp.service.PurchaseMM;

@RestController
@RequestMapping(value="/rest")
public class PurchaseRestController {
	@Autowired
	PurchaseMM pm;
	
	ModelAndView mav;

	@PostMapping(value = "/Purchrase/pregistration", produces= "application/json;charest=utf-8" )
	public ModelAndView pregistration(HttpServletRequest request, Purchase ps, HttpSession session) {
		System.out.println(ps);
		mav= pm.pregistration(request, ps, session);
		return mav;
	}
	
	@GetMapping(value = "/Purchase/pference", produces= "application/json;charest=utf-8" )
	public Map<String, List<Purchase>> pference() {
		System.out.println("들어감?");
		Map<String, List<Purchase>> pMap= pm.pFrerence();
		return pMap;
	}
	
	@PostMapping(value = "/Purchase/pfsearch", produces= "application/json;charest=utf-8" )
	public Map<String, List<Purchase>> pfsearch(String search, String choice) {
		System.out.println("들어가라");
		System.out.println(search);
		System.out.println(choice);
		Map<String, List<Purchase>> pMap= pm.pfsearch(search, choice);
		return pMap;
	}
	
	@PostMapping(value = "/Purchase/pfdelete", produces= "application/json;charest=utf-8" )
	public Map<String, List<Purchase>> pfdelete(String check_list) {
		System.out.println("checkList="+check_list);
		Map<String, List<Purchase>> pMap= pm.pfdelete(check_list);
		return pMap;
	}
	
	   //결재라인
	 @PostMapping(value = "/Purchase/addApproval",produces="application/json;charset=utf-8" )
	 public  Map<String, List<approvalLine>> addApprovale(String CNT, String ARR) {
	      int cnt = Integer.parseInt(CNT);
	      String [] strArray = ARR.split(",");
	      Map<String, List<approvalLine>> sMap=pm.addApproval(cnt,strArray);
	      return sMap;
	 }
	 
	 @PostMapping(value = "/Purchase/approLinecom",produces="application/json;charset=utf-8")
	 public  Map<String, List<approvalLine>> approLinecom(String code1, String code2) {
	      String [] code01 = code1.split(",");
//	      String [] code02 = code2.split(",");
	      
	      System.out.println(code01[0]);
//	      System.out.println(code02[0]);
	      Map<String, List<approvalLine>> sMap=pm.approLinecom(code01);
	      return sMap;
	 }
	   
	 @PostMapping(value = "/Purchase/searchName",produces="application/json;charset=utf-8" )
	 public  Map<String, List<approvalLine>> searchName(String name) {
	      Map<String, List<approvalLine>> sMap=pm.searchName(name);
	      return sMap;
	}
	 
	 
	 @PostMapping(value = "/Purchase/purchaseApproval", produces= "application/json;charest=utf-8" )
	 public ModelAndView pprogramwrite(HttpServletRequest request, PurchaseApproval pa, HttpSession session) {
		 mav= pm.purchaseApproval(request, pa, session);
		 return mav;
	 }
	 @GetMapping(value = "/Purchase/getMyInfo",produces="application/json;charset=utf-8" )
	   public  Map<String, List<approvalLine>> getMyInfo(HttpSession session) {
	      Map<String, List<approvalLine>> mMap=pm.getMyInfo(session);
	      return mMap;
	   }
	 
	@PostMapping(value = "/Purchase/rRegistration", produces= "application/json;charest=utf-8" )
	public ModelAndView rRegistration(Return rt) {
		mav= pm.rRegistration(rt);
		return mav;
	}
	
	@GetMapping(value = "/Purchase/rInfo", produces= "application/json;charest=utf-8" )
	public Map<String, List<Return>> rInfo() {
		Map<String, List<Return>> rMap= pm.rInfo();
		System.out.println("들어가");
		return rMap;
	}
	
	@PostMapping(value = "/Purchase/rdelete", produces= "application/json;charest=utf-8" )
	public Map<String, List<Return>> rdelete(String check_list) {
		System.out.println("check_list:"+check_list);
		Map<String, List<Return>> rMap= pm.rDelete(check_list);
		return rMap;
	}
	
	@PostMapping(value = "/Purchase/retrunsearch", produces= "application/json;charest=utf-8" )
	public Map<String, List<Return>> retrunsearch(String search, String choice) {
		System.out.println("choice="+choice);
		System.out.println("search="+search);
		Map<String, List<Return>> rMap= pm.rSearch(search, choice);
		return rMap;
	}
	

}
