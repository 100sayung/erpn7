spackage com.n7.erp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.ac.approvalLine;
import com.n7.erp.bean.ps.Purchasebean;
import com.n7.erp.bean.ps.Return;
import com.n7.erp.service.PurchaseMM;

@RestController
@RequestMapping(value="/rest")
public class PurchaseRestController {
	@Autowired
	PurchaseMM pm;
	
	ModelAndView mav;

	@PostMapping(value = "/Purchase/pregistration")
	public ModelAndView pregistration(HttpServletRequest request, Purchasebean ps) {
		mav= pm.pregistration(request, ps);
		return mav;
	}
	
	@GetMapping(value = "/Purchase/pference")
	public Map<String, List<Purchasebean>> pference() {
		Map<String, List<Purchasebean>> pMap= pm.pFrerence();
		return pMap;
	}
	
	@PostMapping(value = "/Purchase/pfsearch")
	public Map<String, List<Purchasebean>> pfsearch(String search, String choice) {
		System.out.println("들어가라");
		System.out.println(search);
		System.out.println(choice);
		Map<String, List<Purchasebean>> pMap= pm.pfsearch(search, choice);
		return pMap;
	}
	
	@PostMapping(value = "/Purchase/pfdelete")
	public Map<String, List<Purchasebean>> pfdelete(String check_list) {
		System.out.println("checkList="+check_list);
		Map<String, List<Purchasebean>> pMap= pm.pfdelete(check_list);
		return pMap;
	}
	
	@PostMapping(value = "/Purchase/addApproval",produces="application/json;charset=utf-8" )
	public Map<String, List<approvalLine>> addApprovale(String CNT, String ARR) {
	     int cnt = Integer.parseInt(CNT);
	     String [] strArray = ARR.split(",");
	     Map<String, List<approvalLine>> aMap=pm.addApproval(cnt,strArray);
	     return aMap;
	}
	
	@PostMapping(value = "/Purchase/approLinecom",produces="application/json;charset=utf-8")
	public Map<String, List<approvalLine>> approLinecom(String code1, String code2) {
	     String [] code01 = code1.split(",");
	     String [] code02 = code2.split(",");
	      
	     System.out.println(code01[0]);
	     System.out.println(code02[0]);
	     Map<String, List<approvalLine>> aMap=pm.approLinecom(code01, code02);
	     return aMap;
	}
	
	@PostMapping(value = "/Purchase/searchName",produces="application/json;charset=utf-8" )
	public Map<String, List<approvalLine>> searchName(String name) {
	     Map<String, List<approvalLine>> aMap=pm.searchName(name);
	     return aMap;
	}
	
	@PostMapping(value = "/Purchase/pprogramwrite")
	public ModelAndView pprogramwrite(HttpServletRequest request, PurchaseApproval pa) {
		mav= pm.pprogramwrite(request, pa);
		return mav;
	}
	
	@PostMapping(value = "/Purchase/rRegistration")
	public ModelAndView rRegistration(Return rt) {
		mav= pm.rRegistration(rt);
		return mav;
	}
	
	@GetMapping(value = "/Purchase/rInfo")
	public Map<String, List<Return>> rInfo() {
		Map<String, List<Return>> rMap= pm.rInfo();
		System.out.println("들어가");
		return rMap;
	}
	
	@PostMapping(value = "/Purchase/rdelete")
	public Map<String, List<Return>> rdelete(String check_list) {
		System.out.println("check_list:"+check_list);
		Map<String, List<Return>> rMap= pm.rDelete(check_list);
		return rMap;
	}
	
	@PostMapping(value = "/Purchase/retrunsearch")
	public Map<String, List<Return>> retrunsearch(String search, String choice) {
		System.out.println("choice="+choice);
		System.out.println("search="+search);
		Map<String, List<Return>> rMap= pm.rSearch(search, choice);
		return rMap;
	}
	

}
