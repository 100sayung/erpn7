package com.n7.erp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.n7.erp.bean.ps.PurchaseApproval;
import com.n7.erp.bean.ps.Purchasebean;
import com.n7.erp.bean.ps.Return;
import com.n7.erp.dao.PurchaseDao;

@Component
public class PurchaseMM {
	@Autowired
	private PurchaseDao pDao;

	public ModelAndView pregistration(HttpServletRequest request, Purchasebean ps) {
		ModelAndView mav = new ModelAndView();
		boolean a = false;
		boolean b = false;
		String view = null;
		a= pDao.pcommom(ps);
		String [] p_name = request.getParameterValues("p_name");
		String [] p_itcode = request.getParameterValues("p_itcode");
		String [] p_amount = request.getParameterValues("p_amount");
		String [] p_unlit = request.getParameterValues("p_unlit");
		String [] p_budget = request.getParameterValues("p_budget");
		for(int i=0; i<p_name.length; i++ ) {
			ps.setP_name(p_name[i]);
			ps.setP_itcode(p_itcode[i]);
			ps.setP_amount(Integer.parseInt(p_amount[i]));
			ps.setP_unlit(Integer.parseInt(p_unlit[i]));
			ps.setP_budget(Integer.parseInt(p_budget[i]));
			b= pDao.pregistration(ps); 
		}
		if(a&&b) {
			view = "/pregistrationfrm";
			mav.addObject("msg", "데이터입력완료");
		} else {
			view = "/pregistrationfrm";
			mav.addObject("msg", "데이터입력 실패");
		}
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<Purchasebean>> pFrerence() {
		Map<String, List<Purchasebean>> pMap = null;
		List<Purchasebean> pList = pDao.pFrerence();
		if (pList != null) {
			pMap = new HashMap<>();
			pMap.put("pList", pList);
			System.out.println("pList=" + pList);
		} else {
			pMap = null;
		}
		return pMap;
	}

	public Map<String, List<Purchasebean>> pfsearch(String search, String choice) {
		Map<String, List<Purchasebean>> pMap = null;
		List<Purchasebean> pList = pDao.pfSearch(search, choice);
		if (pList != null) {
			pMap = new HashMap<>();
			pMap.put("pList", pList);
			System.out.println("pList=" + pList);
		} else {
			pMap = null;
		}
		return pMap;
	}

	public Map<String, List<Purchasebean>> pfdelete(String check_list) {
		Map<String, List<Purchasebean>> pMap = null;
		System.out.println(check_list);

		if(pDao.pcDelete(check_list) && pDao.pfDelete(check_list)) {
			List<Purchasebean>pList= pDao.pFrerence();
			pMap = new HashMap<>();
			pMap.put("pList", pList);
			System.out.println("지워짐");
		}else {
			System.out.println("안지워짐");
			pMap = null;
		}
		return pMap;
	}

	public ModelAndView pDetail(String check) {
		ModelAndView mav= new ModelAndView();
		String view= null;
		List<Purchasebean> pList= null;
		Purchasebean ps= new Purchasebean();
		
		if(check!=null) {
			ps= pDao.pInfo(check);
			pList= pDao.pDetail(check);
			if(pList!=null) {
				mav.addObject("pList", new Gson().toJson(pList));
				System.out.println("PLIST"+pList);
				mav.addObject("ps", ps);
				view= "/purchasedetail";
			}
		}else {
			mav.addObject("msg", "가지고 올 데이터가 없습니다.");
			view= "/purchasedetail";
		}
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView pProgram(String check) {
		ModelAndView mav= new ModelAndView();
		String view= null;
		List<Purchasebean> pList= new ArrayList<Purchasebean>();
		
		if(check!=null) {
			if(pList!=null) {
				Purchasebean ps= new Purchasebean();
				ps= pDao.pBring(check);
				pList= pDao.pProgram(check);
				view= "/pprogramwrite";
				mav.addObject("pList", new Gson().toJson(pList));
				mav.addObject("ps", ps);
			}
		}else {
			check= null;
		}
		mav.setViewName(view);
		return mav;
	}
//	
//	public Map<String, List<approvalLine>> searchName(String name) {
//	      Map<String, List<approvalLine>> aMap=null;
//	      List<approvalLine> aList=null;
//	      if(name!=null) {
//	         aList = pDao.searchName(name);
//	         aMap=new HashMap<>();
//	         aMap.put("aList", aList);
//	      }else {
//	         aMap=null;
//	      }
//	      return aMap;
//	   }
//
//	   public Map<String, List<approvalLine>> addApproval(int cnt, String[] strArray) {
//	      Map<String, List<approvalLine>> aMap=null;
//	      List<approvalLine> aList=null;
//	      System.out.println(cnt);
//	      boolean result=false;
//	      String code="";
//	      for(int i=0; i<cnt; i++) {
//	         approvalLine al = new approvalLine();
//	         code=strArray[i];
//	          aList=pDao.addApproval(code);
//	      }
//	      System.out.println(aList);
//	      if(aList!=null) {
//	         aMap=new HashMap<>();
//	         aMap.put("aList", aList);
//	      }else {
//	         aMap=null;
//	      }
//	      return aMap;
//	   }
//
//	   public Map<String, List<approvalLine>> approLinecom(String[] code01, String[] code02) {
//	      Map<String, List<approvalLine>> aMap=null;
//	      System.out.println(code01[0]);
//	      System.out.println(code02[0]);
//	      
//	      if(code01.length!=0) {
//	            List<approvalLine> tList1 = new ArrayList<>();
//	            List<approvalLine> tList2= new ArrayList<>();
//	            
//	            for(int i=0; i<code01.length; i++) {
//	               approvalLine al = new approvalLine();
//	               al=pDao.approLinecom1(code01[i]); 
//	               tList1.add(al);
//	            }
//	            for(int i=0; i<code02.length; i++) {
//	               approvalLine al = new approvalLine();
//	               al=pDao.approLinecom2(code02[i]); 
//	               tList2.add(al);
//	            }
//	            aMap=new HashMap<>();
//	            System.out.println(tList1);
//	            aMap.put("tList1",tList1);
//	            aMap.put("tList2",tList2);
//	         }else {
//	            
//	            aMap=null;;
//	         }
//	      
//	      return aMap;
//	   
//	   }
//	   
//	   public ModelAndView approvalLine() {
//		   	ModelAndView mav = new ModelAndView();
//		      String view=null;
//		      mav= new ModelAndView();
//		      List<approvalLine> aList = null;
//		      aList=pDao.approvalLine(); 
//		      if(aList.size()!=0) {
//		            mav.addObject("aList",new Gson().toJson(aList));
//		            view="approvalLine";
//		         }else {
//		            
//		             mav.addObject("msg","주소록에 정보가 없습니다");
//		            view="pprogramwrite";
//		         }
//		      
//		      mav.setViewName(view);
//		      return mav;
//		   }

	public ModelAndView pprogramwrite(HttpServletRequest request, PurchaseApproval pa) {
		ModelAndView mav = new ModelAndView();
		boolean a = false;
		boolean b = false;
		boolean c = false;
		String view = null;
		a= pDao.Approval(pa);
		b= pDao.pApproval1(pa);
		String [] p_name = request.getParameterValues("p_name");
		String [] p_itcode = request.getParameterValues("p_itcode");
		String [] p_amount = request.getParameterValues("p_amount");
		String [] p_unlit = request.getParameterValues("p_unlit");
		String [] p_budget = request.getParameterValues("p_budget");
		for(int i=0; i<p_name.length; i++ ) {
			pa.setP_name(p_name[i]);
			pa.setP_itcode(p_itcode[i]);
			pa.setP_amount(Integer.parseInt(p_amount[i]));
			pa.setP_unlit(Integer.parseInt(p_unlit[i]));
			pa.setP_budget(Integer.parseInt(p_budget[i]));
			c= pDao.pApproval2(pa); 
		}
		if(a&&b&&c) {
			view = "/pregistrationfrm";
			mav.addObject("msg", "데이터입력완료");
		} else {
			view = "/pprogramwrite";
			mav.addObject("msg", "데이터입력 실패");
		}
		mav.setViewName(view);
		return mav;
	}

	public ModelAndView rRegistration(Return rt) {
		ModelAndView mav= new ModelAndView();
		String view= null;
		
		if(pDao.rRegistration(rt)) {
			view= "/returnregistration";
			mav.addObject("msg", "데이터입력 완료");
		}else {
			view="/returnregistration";
			mav.addObject("msg", "데이터입력 실패");
		}
		mav.setViewName(view);
		return mav;
	}

	public Map<String, List<Return>> rInfo() {
		Map<String, List<Return>> rMap = null;
		List<Return> rList = pDao.rInfo();
		if (rList != null) {
			rMap = new HashMap<>();
			rMap.put("rList", rList);
			System.out.println("rList=" + rList);
		} else {
			rMap = null;
		}
		return rMap;
	}

	public Map<String, List<Return>> rDelete(String check_list) {
		Map<String, List<Return>> rMap=null;
		System.out.println(check_list);
		
		if(pDao.rDelete(check_list)) {
			List<Return>rList=pDao.rInfo();
			rMap= new HashMap<>();
			rMap.put("rList", rList);
			System.out.println("지워짐");
		}else {
			System.out.println("안지워짐");
			rMap=null;
		}
		return rMap;
	}

	public Map<String, List<Return>> rSearch(String search, String choice) {
		Map<String, List<Return>> rMap= null;
		List<Return> rList= pDao.rSearch(search, choice);
		if(rList!=null) {
			rMap= new HashMap<>();
			rMap.put("rList", rList);
			System.out.println("rList="+rList);
		}else {
			rMap=null;
		}
		return rMap;
	}
}
