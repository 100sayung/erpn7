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
import com.n7.erp.dao.AccountDao;
import com.google.gson.Gson;
import com.n7.erp.bean.ac.A_company;
import com.n7.erp.bean.ac.ApprovalDocument;
import com.n7.erp.bean.ac.Approvaldocu;
import com.n7.erp.bean.ac.SaleInfo;
import com.n7.erp.bean.ac.myCompany;
import com.n7.erp.bean.ac.approvalLine;



@Component
public class AccountMM {
	
	@Autowired
	AccountDao aDao;
    
	ModelAndView mav;

	public Map<String, List<A_company>> insertcomlist(A_company ac, HttpSession session) {
		Map<String, List<A_company>> aMap=null;
		ac.setCl_ccode(session.getAttribute("cCode").toString());
		if(ac.getCl_code()!="") {
			if(aDao.insertcomlist(ac)) {
			   List<A_company> aList = aDao.getComList(ac.getCl_code());
			   aMap=new HashMap<>();
			   aMap.put("aList", aList);
			}else {
				aMap=null;
			}
		}else {
			List<A_company> aList = aDao.getComList(ac.getCl_code());
			aMap=new HashMap<>();
			aMap.put("aList", aList);
		}
			
	
		return aMap;
	}

	public Map<String, List<A_company>> serchcomlist() {
		Map<String, List<A_company>> aMap=null;
			   List<A_company> aList = aDao.getCompanyList();
			   aMap=new HashMap<>();
			   aMap.put("aList", aList);
			
		return aMap;
	}

	public Map<String, List<A_company>> searchcode(A_company ac, String code) {
		Map<String, List<A_company>> aMap=null;
		ac.setCl_code(code);
		   List<A_company> aList = aDao.getsearchCode(ac);
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
			result=aDao.deleteCom(code);
		}
		if(result) {
			List<A_company> aList = aDao.getCompanyList();
			aMap=new HashMap<>();
			   aMap.put("aList", aList);
		}else {
			aMap=null;
		}
		return aMap;
	}

	public ModelAndView saleinsert(HttpServletRequest request, SaleInfo si, HttpSession session) {
		String view=null;
		boolean a=false;
		boolean b= false;
		mav= new ModelAndView();
		A_company ac = new A_company();
		ac = aDao.getcomcode(si.getS_comnum());
		si.setS_clcode(ac.getCl_code());
		si.setS_ccode(session.getAttribute("cCode").toString());
		String [] strpkind=request.getParameterValues("s_pkind");
		String [] strcnt=request.getParameterValues("s_cnt");
		String [] strprice=request.getParameterValues("s_price");
		String [] strprice2=request.getParameterValues("s_price2");
		String [] strtax=request.getParameterValues("s_tax");
		String [] strtotal=request.getParameterValues("s_total");
		String [] strmemo=request.getParameterValues("s_memo");
		     	a = aDao.saleinsert(si);
		     	
		for(int i=0; i<strpkind.length; i++) {
			si.setS_pkind(strpkind[i]);
			si.setS_cnt(strcnt[i]);
			si.setS_price(strprice[i]);
			si.setS_price2(strprice2[i]);
			si.setS_tax(strtax[i]);
			si.setS_total(strtotal[i]);
			si.setS_memo(strmemo[i]);
			 	b=aDao.saleinsert2(si);
		}
		
		if(a && b) {
			    mav.addObject("msg","전표등록성공");
			    view="Account/openTable";
			}else {
				mav.addObject("msg","전표등록실패");
				view="Account/openTable";
			}
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<SaleInfo>> getsaleList() {
		Map<String, List<SaleInfo>> aMap=null;
		   List<SaleInfo> sList1 = aDao.getsaleList();
		   //List<SaleInfo> sList2 = aDao.getsaleList2();
		   if(sList1!=null) {
			   
			   aMap=new HashMap<>();
			   aMap.put("sList1", sList1);
		   }else {
			   aMap=null;
		   }
		   //aMap.put("sList2", sList2);
		
	return aMap;
}

	public Map<String, List<SaleInfo>> getList(String code) {
		System.out.println(code);
		Map<String, List<SaleInfo>> sMap=null;
		List<SaleInfo> sList = aDao.getList(code);
		if(sList!=null){
			sMap=new HashMap<>();
			sMap.put("sList", sList);
			
		}
		return sMap;
	}

	public ModelAndView getTaxbill(String check) {
		String view=null;
		System.out.println(check);
		mav= new ModelAndView();
		
		if(check!=null) {
			if(check.contains("S")) {
				List<SaleInfo> tList1 = aDao.saleDetaile(check);
				List<SaleInfo> tList2 = aDao.saleDetaile2(check);
				String company=tList1.get(0).getS_company();
				myCompany mc = new myCompany(); 
				A_company ac = new A_company(); 
				ac=aDao.getcomInfo(company);
				mc=aDao.getmyCompany();
				mav.addObject("mc",mc);
				mav.addObject("ac",ac);
				mav.addObject("tList1",tList1);
				mav.addObject("tList2",new Gson().toJson(tList2));
				view="Account/taxbillS";
				
			}else {
				myCompany mc = new myCompany(); 
				A_company ac = new A_company();
				List<SaleInfo> tList1 = aDao.saleDetaile(check);
				List<SaleInfo> tList2 = aDao.saleDetaile2(check);
				String company=tList1.get(0).getS_company();
				mc=aDao.getmyCompany();
				ac=aDao.getcomInfo(company);
				mav.addObject("mc",mc);
				mav.addObject("ac",ac);
				mav.addObject("tList1",tList1);
				mav.addObject("tList2",new Gson().toJson(tList2));
				mav.addObject("msg","세금계산서 등록");
				view="Account/taxbillP";
			}
			}else {
				mav.addObject("msg","선택한 항목이없습니다");
				view="Account/openTable";
			}
		
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<SaleInfo>> deleteSale(int cnt, String[] strArray) {
		Map<String, List<SaleInfo>> aMap=null;
		boolean result=false;
		boolean result2=false;
		String code="";
		for(int i=0; i<cnt; i++) {
			code=strArray[i];
			result2=aDao.deleteSale2(code);
			result=aDao.deleteSale(code);
		}
		if(result && result2) {
			List<SaleInfo> sList = aDao.getsaleList();
			aMap=new HashMap<>();
			   aMap.put("sList", sList);
		}else {
			aMap=null;
		}
		return aMap;
	}

	public ModelAndView saledetails(String check) {
		String view=null;
		System.out.println(check);
		mav= new ModelAndView();
		
		if(check!=null) {
				List<SaleInfo> tList = new ArrayList<>();
				tList=aDao.getTaxbill(check); 
				List<SaleInfo> tList2 = aDao.saleDetaile2(check);
				myCompany mc = new myCompany(); 
				mc=aDao.getmyCompany();
				mav.addObject("mc",mc);
				mav.addObject("tList",tList);
				mav.addObject("tList2",new Gson().toJson(tList2));
				view="Account/saledetails";
			}else {
				
			    mav.addObject("msg","매출만 거래명세서를 볼수 있습니다");
				view="Account/openTable";
			}
		
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView acApproval(String check) {
		mav= new ModelAndView();
		String view ="";
		if(check!=null) {
			List<SaleInfo> sList1 = aDao.saleDetaile(check);
			List<SaleInfo> sList2 = aDao.saleDetaile2(check);
			   if(sList1!=null) {
				   mav.addObject("sList1", sList1);
				   mav.addObject("sList2", new Gson().toJson(sList2));
				   view="Account/acApproval";
			   }
		}else {
			mav.addObject("msg","불러올 데이터가 없습니다");
			view="opentable";
		}
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView approvalLine() {
		String view=null;
		mav= new ModelAndView();
		List<approvalLine> aList = null;
		aList=aDao.approvalLine(); 
		if(aList.size()!=0) {
				mav.addObject("aList",new Gson().toJson(aList));
				view="Account/approvalLine";
			}else {
				
			    mav.addObject("msg","주소록에 정보가 없습니다");
				view="Account/acApproval";
			}
		
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<approvalLine>> searchName(String name) {
		Map<String, List<approvalLine>> aMap=null;
		List<approvalLine> aList=null;
		if(name!=null) {
			aList = aDao.searchName(name);
			aMap=new HashMap<>();
			aMap.put("aList", aList);
		}else {
			aMap=null;
		}
		return aMap;
	}

	public Map<String, List<approvalLine>> addApproval(int cnt, String[] strArray) {
		Map<String, List<approvalLine>> aMap=null;
		List<approvalLine> aList= new ArrayList<>();
		System.out.println("숫자="+cnt);
		System.out.println("이름값="+strArray.length);
		
		String code="";
		approvalLine al = new approvalLine();
		for(int i=0; i<cnt; i++) {
			code=strArray[i];
			al=aDao.addApproval(code);
		    aList.add(al);
		}
		if(aList!=null) {
			aMap=new HashMap<>();
			aMap.put("aList", aList);
		}else {
			aMap=null;
		}
		return aMap;
	}

	public Map<String, List<approvalLine>> approLinecom(String[] code01) {
		Map<String, List<approvalLine>> aMap=null;
		System.out.println(code01.length);
		//System.out.println(code02[0]);
		
		if(code01.length!=0) {
				List<approvalLine> tList1 = new ArrayList<>();
				//List<approvalLine> tList2= new ArrayList<>();
				
				for(int i=0; i<code01.length; i++) {
					approvalLine al = new approvalLine();
					al=aDao.approLinecom1(code01[i]); 
					tList1.add(al);
				}
//				for(int i=0; i<code02.length; i++) {
//					approvalLine al = new approvalLine();
//					al=aDao.approLinecom2(code02[i]); 
//					tList2.add(al);
//				}
				aMap=new HashMap<>();
				System.out.println(tList1);
				aMap.put("tList1",tList1);
				//aMap.put("tList2",tList2);
			}else {
				
				aMap=null;;
			}
		
		return aMap;
	
	
	}

	public ModelAndView approdocument(HttpServletRequest request, ApprovalDocument ad, HttpSession session) {
		String view=null;
		mav= new ModelAndView();
		boolean a=false;
		boolean b=false;
		boolean c=false;
		A_company ac = new A_company();
		ac = aDao.getcomcode(ad.getRs_comnum());
		ad.setRs_clcode(ac.getCl_code());
		ad.setRs_ccode(session.getAttribute("cCode").toString());
		String [] strpkind=request.getParameterValues("rs_pkind");
		String [] strcnt=request.getParameterValues("rs_cnt");
		String [] strprice=request.getParameterValues("rs_price");
		String [] strprice2=request.getParameterValues("rs_price2");
		String [] strtax=request.getParameterValues("rs_tax");
		String [] strtotal=request.getParameterValues("rs_total");
		String [] strmemo=request.getParameterValues("rs_memo");
		 		a = aDao.approvaldocu(ad);
		     	b = aDao.approdocument(ad);
		     	
		for(int i=0; i<strpkind.length; i++) {
			ad.setRs_pkind(strpkind[i]);
			ad.setRs_cnt(strcnt[i]);
			ad.setRs_price(strprice[i]);
			ad.setRs_price2(strprice2[i]);
			ad.setRs_tax(strtax[i]);
			ad.setRs_total(strtotal[i]);
			ad.setRs_memo(strmemo[i]);
			 	c=aDao.approdocument2(ad);
		}
		if(a && b && c) {
			//aDao.saleListDelete(ad);
			mav.addObject("num","1");
				view="Account/openTable";
			}else {
				mav.addObject("num","0");
				view="Account/openTable";
			}
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<SaleInfo>> getpkind(String pkind) {
		Map<String, List<SaleInfo>> sMap=null;
		List<SaleInfo> sList=null;
		//SaleInfo si = new SaleInfo();
		sList=aDao.getpkind(pkind);
		//sList.add(si);
		System.out.println(sList);
		if(sList!=null) {
			sMap=new HashMap<>();
			sMap.put("sList", sList);
		}else {
			sMap=null;
		}
		return sMap;
	}

	public ModelAndView SaleDetaile(String check) {
		String view=null;
		mav= new ModelAndView();
		
		if(check!=null) {
			List<SaleInfo> sList1 = aDao.saleDetaile(check);
			List<SaleInfo> sList2 = aDao.saleDetaile2(check);
			   if(sList1!=null) {
				   mav.addObject("sList1", sList1);
				   mav.addObject("sList2", new Gson().toJson(sList2));
				   view="Account/SaleDetaile";
			   }
		}else {
			mav.addObject("msg","불러올 데이터가 없습니다");
			view="Account/opentable";
		}
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<SaleInfo>> selectSearch(String select, String choice) {
		Map<String, List<SaleInfo>> sMap=null;
		List<SaleInfo> sList=null;
		
		sList=aDao.selectSreach(select,choice);
		System.out.println(sList);
		if(sList!=null) {
			sMap=new HashMap<>();
			sMap.put("sList", sList);
		}else {
			sMap=null;
		}
		return sMap;
	}

	public Map<String, List<Approvaldocu>> comparecode(String code) {
		Map<String, List<Approvaldocu>> sMap=null;
		List<Approvaldocu> sList=null;
		
		sList=aDao.comparecode(code);
		System.out.println(sList);
		if(sList!=null) {
			sMap=new HashMap<>();
			sMap.put("sList", sList);
		}else {
			sMap=null;
		}
		return sMap;
	}
}