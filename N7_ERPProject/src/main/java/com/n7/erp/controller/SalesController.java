package com.n7.erp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.sales.A_company;
import com.n7.erp.bean.sales.Businessbean;
import com.n7.erp.bean.sales.Salesbean;
import com.n7.erp.bean.sales.Shippingbean;
import com.n7.erp.bean.sales.Uncollectedbean;
import com.n7.erp.bean.sales.approvalLine;
import com.n7.erp.bean.sales.approvaldetail;
import com.n7.erp.service.Salesmm;



@RestController
@RequestMapping(value="/rest")
public class SalesController {
   
   @Autowired
   Salesmm sm;

   ModelAndView mav;
   
   @GetMapping(value = "/sales/orderitem") //수주 DB데이터 긁어온 거
   public @ResponseBody Map<String, List<Salesbean>> orderitem() {
     System.out.println("여긴들어와?1");
     Map<String, List<Salesbean>> sMap=sm.orderitem();
      return sMap;
   }
   
   @PostMapping(value = "/sales/orderregistrationinput",produces="application/json;charset=utf-8") //수주등록
   public ModelAndView orderregistrationinput(Salesbean s, HttpSession session) {
     System.out.println("슈밤111111");
     mav=sm.orderregistrationinput(s, session);
      return mav;
   }
   
   @PostMapping(value = "/sales/orderregistrationsearch") //수주검색
   public Map<String, List<Salesbean>> orderregistrationsearch(String search, String choice) {
     Map<String, List<Salesbean>> sMap=sm.orderregistrationsearch(search, choice);
      return sMap;
   }
   
   @PostMapping(value = "/sales/orderregistrationdelete") //수주삭제
   public Map<String, List<Salesbean>> orderregistrationdelete(String check) {
      Map<String, List<Salesbean>> sMap=sm.orderregistrationdelete(check);
      return sMap;
   } 
   
   @PostMapping(value = "/sales/insertcomlist",produces="application/json;charset=utf-8" ) //거래처 전체리스트
   public  Map<String, List<A_company>> insertcomlist(A_company ac, HttpSession session) {
      Map<String, List<A_company>> aMap=sm.insertcomlist(ac, session);
      return aMap;
   }
   
   @PostMapping(value = "/sales/searchcode",produces="application/json;charset=utf-8" ) //거래처 코드검색
   public  Map<String, List<A_company>> searchcode(A_company ac, String code) {
      Map<String, List<A_company>> aMap=sm.searchcode(ac,code);
      return aMap;
   }
   
   @PostMapping(value = "/sales/deleteCom",produces="application/json;charset=utf-8" ) //거래처 삭제
   public  Map<String, List<A_company>> deleteCom(String CNT, String ARR) {
      int cnt = Integer.parseInt(CNT);
      System.out.println(cnt);
      String [] strArray = ARR.split(",");
      System.out.println(strArray);
      Map<String, List<A_company>> aMap=sm.deleteCom(cnt,strArray);
      return aMap;
   }
   
   @GetMapping(value = "/sales/serchcomlist",produces="application/json;charset=utf-8" ) //거래처 회사검색?
   public  Map<String, List<A_company>> serchcomlist() {
      Map<String, List<A_company>> aMap=sm.serchcomlist();
      return aMap;
   }
   
   @PostMapping(value = "/sales/shippingrequestinput",produces="application/json;charset=utf-8") //출하의뢰등록
   public ModelAndView shippingrequestinput(Shippingbean ss, HttpSession session) {
     System.out.println("슈밤22222222222222");
     mav=sm.shippingrequestinput(ss, session);
      return mav;
   }
   
   @GetMapping(value = "/sales/shippingitem") //출하 DB데이터 긁어온 거
   public @ResponseBody Map<String, List<Shippingbean>> shippingitem() {
     System.out.println("여긴들어와?1");
     Map<String, List<Shippingbean>> sMap=sm.shippingitem();
      return sMap;
   }
   
   @PostMapping(value = "/sales/shippingrequestsearch") //출하검색
   public Map<String, List<Shippingbean>> shippingrequestsearch(String search, String choice) {
     Map<String, List<Shippingbean>> sMap=sm.shippingrequestsearch(search, choice);
      return sMap;
   }
   
   @PostMapping(value = "/sales/shippingrequestdelete") //출하삭제
   public Map<String, List<Shippingbean>> shippingrequestdelete(String check) {
      Map<String, List<Shippingbean>> sMap=sm.shippingrequestdelete(check);
      return sMap;
   } 
   //결재라인
   @PostMapping(value = "/sales/addApproval",produces="application/json;charset=utf-8" )
   public  Map<String, List<approvalLine>> addApprovale(String CNT, String ARR) {
      int cnt = Integer.parseInt(CNT);
      String [] strArray = ARR.split(",");
      Map<String, List<approvalLine>> sMap=sm.addApproval(cnt,strArray);
      return sMap;
   }
   @PostMapping(value = "/sales/approLinecom",produces="application/json;charset=utf-8")
   public  Map<String, List<approvalLine>> approLinecom(String code1, String code2) {
      String [] code01 = code1.split(",");
//      String [] code02 = code2.split(",");
      
      System.out.println(code01[0]);
//    System.out.println(code02[0]);
      Map<String, List<approvalLine>> sMap=sm.approLinecom(code01);
      return sMap;
   }
   @PostMapping(value = "/sales/searchName",produces="application/json;charset=utf-8" )
   public  Map<String, List<approvalLine>> searchName(String name) {
      Map<String, List<approvalLine>> sMap=sm.searchName(name);
      return sMap;
   }
   
   @PostMapping(value = "/sales/approvalinput",produces="application/json;charset=utf-8") //출하 결재창 등록
   public ModelAndView approvalinput(approvaldetail app, HttpSession session) {
     System.out.println("슈밤111111");
     mav=sm.approvalinput(app, session);
      return mav;
   }
  
   @PostMapping(value = "/sales/uncollectedmoneyinput", produces = "application/json;charset=utf-8") // 미수금 등록
   public ModelAndView uncollectedmoneyinput(approvaldetail ap, HttpSession session) {
      System.out.println("들어가닝");
      mav = sm.uncollectedmoneyinput(ap, session);
      return mav;
   }
   
   @GetMapping(value = "/sales/uncollectedmoneyitem") //미수금 DB데이터 긁어온 거
   public @ResponseBody Map<String, List<approvaldetail>> uncollectedmoneyitem() {
      System.out.println("여긴들어와?444444");
      Map<String, List<approvaldetail>> sMap=sm.uncollectedmoneyitem();
      return sMap;
   }
   
   @PostMapping(value = "/sales/uncollectedmoneysearch") //미수금 검색
   public Map<String, List<Uncollectedbean>> uncollectedmoneysearch(String search, String choice) {
     Map<String, List<Uncollectedbean>> sMap=sm.uncollectedmoneysearch(search, choice);
      return sMap;
   }


   @PostMapping(value = "/sales/fullpaymentprocess") //완납 처리
   public Map<String, List<approvaldetail>> fullpaymentprocess(String check) {
      System.out.println(check);
      System.out.println("오냐오냐");
      Map<String, List<approvaldetail>> sMap=sm.fullpaymentprocess(check);
      return sMap;
   } 
   
     
   @GetMapping(value = "/sales/creditsearch") //외상
   public Map<String, List<approvaldetail>> creditsearch() {
     Map<String, List<approvaldetail>> sMap=sm.creditsearch();
      return sMap;
   }
   
   @GetMapping(value = "/sales/fullpaymentsearch") //완납
   public Map<String, List<approvaldetail>> fullpaymentsearch() {
     Map<String, List<approvaldetail>> sMap=sm.fullpaymentsearch();
      return sMap;
   }
   
   @PostMapping(value = "/sales/businessactivitiesinput",produces="application/json;charset=utf-8") //영업활동 등록
   public ModelAndView businessactivitiesinput(Businessbean b, HttpSession session) {
      System.out.println("슈댕");
      mav=sm.businessactivitiesinput(b, session);
      return mav;
   }
   
   @GetMapping(value = "/sales/businessitem") //영업 DB데이터 긁어온 거
   public @ResponseBody Map<String, List<Businessbean>> businessitem() {
      System.out.println("여긴들어와?333333333");
      Map<String, List<Businessbean>> sMap=sm.businessitem();
      return sMap;
   } 
   
   @PostMapping(value = "/sales/businessactivitiessearch") //영업활동 검색
   public Map<String, List<Businessbean>> businessactivitiessearch(String search, String choice) {
     Map<String, List<Businessbean>> sMap=sm.businessactivitiessearch(search, choice);
      return sMap;
   }
   
   @PostMapping(value = "/sales/businessactivitiesdelete") //영업삭제
   public Map<String, List<Businessbean>> businessactivitiesdelete(String check) {
      Map<String, List<Businessbean>> sMap=sm.businessactivitiesdelete(check);
      return sMap;
   } 
} 