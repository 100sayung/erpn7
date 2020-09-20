package com.n7.erp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.n7.erp.bean.sales.A_company;
import com.n7.erp.bean.sales.Businessbean;
import com.n7.erp.bean.sales.Salesbean;
import com.n7.erp.bean.sales.Shippingbean;
import com.n7.erp.bean.sales.Uncollectedbean;
import com.n7.erp.bean.sales.approvaldetail;
import com.n7.erp.bean.sales.approvalLine;
import com.n7.erp.dao.SalesDao;

@Component
public class Salesmm {
   @Autowired
   SalesDao sDao;
   
   ModelAndView mav;


   public Map<String, List<Salesbean>> orderitem() {
      System.out.println("여긴들어와?2");
      Map<String, List<Salesbean>> sMap= null;
      
      List<Salesbean> sList= new ArrayList<>();
      sList=sDao.orderitem();
      System.out.println(sList);
      if(sList!=null) {
          sMap=new HashMap<>();
          sMap.put("sList", sList);
      }
      return sMap;
   }

   public ModelAndView orderregistrationinput(Salesbean s, HttpSession session) {
      s.setBo_ccode(session.getAttribute("cCode").toString());
      mav=new ModelAndView();   
      String view=null;
      System.out.println("슈밤222222222222");
      
      s.setBo_num("O");
      
      boolean result=sDao.orderregistrationinput(s);
      if(s.getBo_ccode()!="") {
         if(result) {
            mav.addObject("msg", "데이터 입력이 완료되었습니다");
            view="sales/orderregistrationfrm";
         }else {
            mav.addObject("msg", "데이터 입력이 실패하였습니다");
            view="sales/orderregistrationfrm";
         }
      }
      mav.setViewName(view);
      return mav;         
   }

   public Map<String, List<Salesbean>> orderregistrationsearch(String search, String choice) {
      Map<String, List<Salesbean>> sMap= null; 
      List<Salesbean> sList=new ArrayList<>();
      sList=sDao.orderregistrationsearch(search, choice);
      if(sList!=null) {
         sMap=new HashMap<>();
         sMap.put("sList", sList);
      }else {
         sMap=null;
      }
      return sMap;
   }

   public Map<String, List<Salesbean>> orderregistrationdelete(String check) {
      Map<String, List<Salesbean>> sMap = null;
      if(sDao.orderregistrationdelete(check)) {
         List<Salesbean> sList = sDao.orderitem();
         sMap = new HashMap<>();
         sMap.put("sList", sList);
         System.out.println(sList);
      }else {
         System.out.println("지워짐?");
         sMap = null;
      }
      return sMap;
   }


   public ModelAndView shippingrequestinput(Shippingbean ss, HttpSession session) {   
      ss.setBs_ccode(session.getAttribute("cCode").toString());
      mav = new ModelAndView();
      String view = null;
      
      //ss.setBs_docunum("S");
      
      boolean result = sDao.shippingrequestinput(ss);
      if(ss.getBs_ccode()!="") {
        if (result) {
         mav.addObject("msg", "출하입력이 완료되었습니다.");
         view = "sales/shippingrequestinputfrm";
      } else {
         mav.addObject("msg", "출하입력이 실패하였습니다.");
         view = "sales/shippingrequestinputfrm";
        }
      }
      mav.setViewName(view);
      return mav;
    }
            
   public Map<String, List<Shippingbean>> shippingitem() {
      Map<String, List<Shippingbean>> sMap= null;
      
      List<Shippingbean> sList= sDao.shippingitem();
      System.out.println(sList);
      if(sList!=null) {
          sMap=new HashMap<>();
          sMap.put("sList", sList);
      }
      return sMap;
   }

   public Map<String, List<Shippingbean>> shippingrequestdelete(String check) {
      Map<String, List<Shippingbean>> sMap = null;
      if(sDao.shippingrequestdelete(check)) {
         List<Shippingbean> sList = sDao.shippingitem();
         sMap = new HashMap<>();
         sMap.put("sList", sList);
         System.out.println(sList);
      }else {
         System.out.println("지워짐?");
         sMap = null;
      }
      return sMap;
   }
   
   public ModelAndView businessactivitiesinput(Businessbean b,  HttpSession session) {
      b.setBa_ccode(session.getAttribute("cCode").toString());
      mav=new ModelAndView();
      String view=null;
      
      b.setBa_ocode("A");
      
      boolean result=sDao.businessactivitiesinput(b);
      if(b.getBa_ccode()!="") {
        if(result) {
         mav.addObject("msg", "영업활동 입력이 완료되었습니다");
          view="sales/businessactivitiesfrm";
      }else {
         mav.addObject("msg", "영업활동 입력이 실패하였습니다");
          view="sales/businessactivitiesfrm";
      }
      }
      mav.setViewName(view);
      return mav;
   }

   public Map<String, List<Businessbean>> businessitem() {
      Map<String, List<Businessbean>> sMap= null;
      System.out.println("3333333333333333333");
      List<Businessbean> bList= sDao.businessitem();
      if(bList!=null) {
         sMap=new HashMap<>();
         sMap.put("bList", bList);
      }
      return sMap;
   }
   
   public Map<String, List<A_company>> insertcomlist(A_company ac) {
         Map<String, List<A_company>> aMap=null;
         //System.out.println(ac.getcl_code());
         if(ac.getCl_code()!="") {
            if(sDao.insertcomlist(ac)) {
               List<A_company> aList = sDao.getComList(ac.getCl_code());
               aMap=new HashMap<>();
               aMap.put("aList", aList);
            }else {
               aMap=null;
            }
         }else {
            List<A_company> aList = sDao.getComList(ac.getCl_code());
            aMap=new HashMap<>();
            aMap.put("aList", aList);
         }
      
         return aMap;
      }
   
   public Map<String, List<A_company>> serchcomlist() {
         Map<String, List<A_company>> aMap=null;
               List<A_company> aList = sDao.getCompanyList();
               aMap=new HashMap<>();
               aMap.put("aList", aList);
            
         return aMap;
      }
   
   public Map<String, List<A_company>> searchcode(A_company ac) {
         Map<String, List<A_company>> aMap=null;
            List<A_company> aList = sDao.getsearchCode(ac);
            if(aList!=null) {
               aMap=new HashMap<>();
               aMap.put("aList", aList);
            }
         
      return aMap;
   }
   
   public Map<String, List<A_company>> deleteCom(int cnt, String[] strArray) {
         Map<String, List<A_company>> aMap=null;
         boolean result=false;
         String code="";
         for(int i=0; i<cnt; i++) {
            code=strArray[i];
            result=sDao.deleteCom(code);
         }
         if(result) {
            List<A_company> aList = sDao.getCompanyList();
            aMap=new HashMap<>();
               aMap.put("aList", aList);
         }else {
            aMap=null;
         }
         return aMap;
      }


   public ModelAndView approvalplan(String check) {
        ModelAndView mav=new ModelAndView();
        Shippingbean sb=new Shippingbean();
        String view=null;        
                 sb=sDao.approvalplanchoice(check);      
           if(sb!=null) {
              mav.addObject("sb",sb);
              view="sales/approvalplan";
           }else {
              mav.addObject("msg", "데이터가 없습니다");
              view="sales/shippingrequestinputfrm";
           }
           mav.setViewName(view);       
      return mav;
   }
    //결재라인 
   public Map<String, List<com.n7.erp.bean.sales.approvalLine>> searchName(String name) {
         Map<String, List<approvalLine>> sMap=null;
         List<approvalLine> aList=null;
         if(name!=null) {
            aList = sDao.searchName(name);
            sMap=new HashMap<>();
            sMap.put("aList", aList);
         }else {
            sMap=null;
         }
         return sMap;
      }

      public Map<String, List<approvalLine>> addApproval(int cnt, String[] strArray) {
         Map<String, List<approvalLine>> sMap=null;
         List<approvalLine> aList=null;
         System.out.println(cnt);
         String code="";
         for(int i=0; i<cnt; i++) {
            code=strArray[i];
             aList=sDao.addApproval(code);
         }
         System.out.println(aList);
         if(aList!=null) {
            sMap=new HashMap<>();
            sMap.put("aList", aList);
         }else {
            sMap=null;
         }
         return sMap;
      }

      public Map<String, List<approvalLine>> approLinecom(String[] code01) {
            Map<String, List<approvalLine>> sMap=null;
            System.out.println(code01.length);
            //System.out.println(code02[0]);
            
            if(code01.length!=0) {
                  List<approvalLine> tList1 = new ArrayList<>();
//                  List<approvalLine> tList2= new ArrayList<>();
                  
                  for(int i=0; i<code01.length; i++) {
                     approvalLine al = new approvalLine();
                     al=sDao.approLinecom1(code01[i]); 
                     tList1.add(al);
                  }
//                  for(int i=0; i<code02.length; i++) {
//                     approvalLine al = new approvalLine();
//                     al=sDao.approLinecom2(code02[i]); 
//                     tList2.add(al);
//                  }
                  sMap=new HashMap<>();
                  System.out.println(tList1);
                  sMap.put("tList1",tList1);
                  //sMap.put("tList2",tList2);
               }else {
                  
                  sMap=null;
               }
            
            return sMap;

      }
    //결재라인 끝
      public ModelAndView approvalLine() {
            String view=null;
            mav= new ModelAndView();
            List<approvalLine> aList = null;
            aList=sDao.approvalLine(); 
            if(aList.size()!=0) {
                  mav.addObject("aList",new Gson().toJson(aList));
                  view="sales/approvalline";
               }else {
                  
                   mav.addObject("msg","주소록에 정보가 없습니다");
                  view="sales/shippingrequestinputfrm";
               }
            
            mav.setViewName(view);
            return mav;
         }
 
   public ModelAndView approvalinput(approvaldetail app, HttpSession session) {
	  app.setBs_ccode(session.getAttribute("cCode").toString());
      mav=new ModelAndView();
      String view=null;
   
      boolean result=sDao.approvalinput(app);
      boolean result2=sDao.approvalinput2(app);
      if(app.getBs_ccode()!="") {
        if(result && result2) {
         mav.addObject("msg", "데이터 입력이 완료되었습니다");
          view="sales/approvalplan";
      }else {
         mav.addObject("msg", "데이터 입력이 실패하였습니다");
          view="sales/approvalplan";
        }
      }
      mav.setViewName(view);
      return mav;
   }

   public Map<String, List<approvaldetail>> creditsearch() {
      Map<String, List<approvaldetail>> sMap= null; 
      List<approvaldetail> sList=new ArrayList<>();
      sList=sDao.creditsearch();
      if(sList!=null) {
         sMap=new HashMap<>();
         sMap.put("sList", sList);
      }else {
         sMap=null;
      }
      return sMap;
   }
   
   public Map<String, List<approvaldetail>> fullpaymentsearch() {
      Map<String, List<approvaldetail>> sMap= null; 
      List<approvaldetail> sList=new ArrayList<>();
      sList=sDao.fullpaymentsearch();
      if(sList!=null) {
         sMap=new HashMap<>();
         sMap.put("sList", sList);
      }else {
         sMap=null;
      }
      return sMap;      
   }

   public ModelAndView uncollectedmoneyinput(approvaldetail ap, HttpSession session) {
	  ap.setBs_ccode(session.getAttribute("cCode").toString());
	  mav=new ModelAndView();
      String view=null;
      
      boolean result=sDao.uncollectedmoneyinput(ap);
      if(ap.getBs_ccode()!="") {
       if(result) {
         mav.addObject("msg", "데이터 입력이 완료되었습니다");
         view="sales/uncollectedmoneyregistrationfrm";
      }else {
         mav.addObject("msg", "데이터 입력이 실패하였습니다");
         view="sales/uncollectedmoneyregistrationfrm";
        }
      }
      mav.setViewName(view);
      return mav;
   }   

   public Map<String, List<approvaldetail>> uncollectedmoneyitem() {
      Map<String, List<approvaldetail>> sMap= null;
      System.out.println("3333333333333333333");
      List<approvaldetail> sList=new ArrayList<>();
      List<approvaldetail> sList2=new ArrayList<>();
      sList=sDao.uncollectedmoneyitem();
      sList2=sDao.uncollectedmoneyitem2();
      
      if(sList!=null) {
         sMap=new HashMap<>();
         sMap.put("sList", sList);
         sMap.put("sList2", sList2);
      }else {
         sMap=null;
      }
      return sMap;
   }
   

   public Map<String, List<Shippingbean>> shippingrequestsearch(String search, String choice) {
      Map<String, List<Shippingbean>> sMap= null; 
      List<Shippingbean> sList=new ArrayList<>();
      sList=sDao.shippingrequestsearch(search, choice);
      if(sList!=null) {
         sMap=new HashMap<>();
         sMap.put("sList", sList);
      }else {
         sMap=null;
      }
      return sMap;
   }

   public Map<String, List<Uncollectedbean>> uncollectedmoneysearch(String search, String choice) {
      Map<String, List<Uncollectedbean>> sMap= null; 
      List<Uncollectedbean> sList=new ArrayList<>();
      sList=sDao.uncollectedmoneysearch(search, choice);
      if(sList!=null) {
         sMap=new HashMap<>();
         sMap.put("sList", sList);
      }else {
         sMap=null;
      }
      return sMap;
   }


   public Map<String, List<approvaldetail>> fullpaymentprocess(String check) {
      Map<String, List<approvaldetail>> sMap= null; 
      List<approvaldetail> sList=new ArrayList<>();
      System.out.println("여기옴?");
      if(sDao.fullpaymentprocess(check)){
          System.out.println("들어옴!");
          sList=sDao.uncollectedmoneyitem2();
          sMap=new HashMap<>();
          sMap.put("sList",sList);
      }else {
         sMap=null;
         System.out.println("망함?");
      }
      return sMap;
  }

   public Map<String, List<Businessbean>> businessactivitiessearch(String search, String choice) {
      Map<String, List<Businessbean>> sMap= null; 
      List<Businessbean> bList=new ArrayList<>();
      bList=sDao.businessactivitiessearch(search, choice);
      if(bList!=null) {
         sMap=new HashMap<>();
         sMap.put("bList", bList);
      }else {
         sMap=null;
      }
      return sMap;
   }
}