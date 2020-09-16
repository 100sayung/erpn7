package com.n7.erp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.n7.erp.bean.ConsultingBoard;
import com.n7.erp.bean.hr.Deduct;
import com.n7.erp.bean.hr.Department;
import com.n7.erp.dao.HRIDeptDao;
import com.n7.erp.userClass.Paging;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class HRDepartmentMM {

	@Autowired
	private HRIDeptDao Ddao;

	ModelAndView mav = new ModelAndView();
	//부서 등록
	public ModelAndView deptregistinsert(Department dept, String cCode) {
		String view = null;
		System.out.println(dept.getHDP_dept());
		dept.setHdp_ccode(cCode);
		if (Ddao.deptregistinsert(dept)) {
			view = "hr/deptregistpage";

		} else {
			mav.addObject("deptfalse", "부서 등록에 실패하였습니다.");
			view = "hr/deptregistpage";
		}
		mav.setViewName(view);
		return mav;
	}
	//부서,직급 급여 변경 페이지 이동시 부서,직급 목록 출력
	public ModelAndView deptpayselect(String cCode) {
		String view = null;
		ArrayList<Department> dept = Ddao.deptpayselect(cCode);
		System.out.println("첫번째 =" + dept.size());

		Gson gson = new Gson();
		String json = gson.toJson(dept);
		System.out.println(json);

		if (dept != null) {
			mav.addObject("dept", json);
			view = "/hr/deptpay";
		}
		mav.setViewName(view);
		return mav;
	}
	//검색할때 부서 직급<select>창 목록
	public ModelAndView distictdp(String cCode) {
		String view=null;
		ArrayList<Department> distinctdept=Ddao.distinctdept(cCode);
		ArrayList<Department> distinctposition=Ddao.distinctposition(cCode);
		System.out.println("중복없앤 부서="+distinctposition);
		Gson gson=new Gson();
		String position=gson.toJson(distinctposition);
		System.out.println(position);
		if(distinctposition!=null) {
			mav.addObject("distinctposition", position);
			System.out.println("중복없앤 직책="+distinctdept);
			String dept=gson.toJson(distinctdept);
			System.out.println(dept);
			if(distinctdept!=null) {
				mav.addObject("distinctdept", dept);
				view="/hr/deptpay";
			}
		}
		mav.setViewName(view);
		return mav;
	}

	//부서,직급 변경
	public String deptpayupdate(String dept, Integer pay, String cCode) {
		System.out.println(dept);
		System.out.println(pay);
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("dept", dept);
		hMap.put("pay", pay.toString());
		hMap.put("cCode", cCode);
		System.out.println(hMap.get("pay"));
		if (Ddao.deptpayupdate(hMap)) {
			System.out.println("popopo");
			String resultdept = Ddao.payselect(hMap);
			System.out.println("아아 = "+resultdept);
			if (resultdept != null) {
				return resultdept;
			}
		}
		return null;
	}

	//부서/직급 삭제
	public String deptdelete(Integer deptnum, String cCode) {
		String json=null;
		HashMap<String, String> delMap = new HashMap<String, String>();
		delMap.put("deptnum", deptnum.toString());
		delMap.put("cCode", cCode);
		if(Ddao.deptdelete(delMap)) {
			ArrayList<Department> deList=Ddao.deptafterselect(cCode);
			System.out.println(deList);
			Gson gson=new Gson();
			json=gson.toJson(deList);
		}
		return json;
	}

	public ModelAndView searchpay(String cCode) {
		ArrayList<Department> deList=Ddao.searchpay(cCode);


		return mav;
	}
	//공제사항 관리 페이지 이동 and 공제 목록 출력
	public ModelAndView moveDeduct(String cCode) {
		String view=null;
		ArrayList<Deduct> duList=Ddao.moveDeduct(cCode);
		System.out.println("공제 = "+duList.size());
		if(duList!=null) {
			Gson gson=new Gson();
			String json=gson.toJson(duList);
			System.out.println(json);
			mav.addObject("deduct", json);
		}
		mav.setViewName(view);
		return mav;
	}
	//공제 금액 수정
	public String modifyDeduction(String deduct, Integer denum, String cCode) {
		HashMap<String, String> duMap=new HashMap<String, String>();
		duMap.put("deduct", deduct);
		duMap.put("denum", denum.toString());
		duMap.put("cCode", cCode);
		System.out.println(duMap);
		if(Ddao.modifyDeduction(duMap)) {
			System.out.println("????");
			String Deduction=Ddao.findDeduction(duMap);
			System.out.println(Deduction);
			if(Deduction!=null) {
				return Deduction;
			}
		}
		return null;
	}
	//부서 직급검색 기능
	public String findDeptPosition(String disdept, String disposition, String cCode) {
		System.out.println(disdept+","+disposition);
		System.out.println(disdept);
		ArrayList<Department> deptList=new ArrayList<Department>();
		String json=null;
		System.out.println("여긴 오겠지");
		HashMap<String, String> fdpMap = new HashMap<String, String>();
		fdpMap.put("disdept", disdept);
		fdpMap.put("disposition", disposition);
		fdpMap.put("cCode", cCode);

		if(disdept!=""&&disposition=="") {
			System.out.println("두번쨰에선오나");
			deptList=Ddao.findDisdept(fdpMap);
			if(deptList!=null) {
				Gson gson=new Gson();
				json=gson.toJson(deptList);
				return json;
			}
		}else if(disposition!=""&&disdept=="") {
			System.out.println("세번째 와바라");
			deptList=Ddao.findDisposition(fdpMap);
			if(deptList!=null) {
				Gson gson=new Gson();
				json=gson.toJson(deptList);
				return json;
			}
		}else if(disdept!=""&&disposition!="") {
			deptList=Ddao.findDeptPosition(fdpMap);
			if(deptList!=null) {
				Gson gson=new Gson();
				json=gson.toJson(deptList);
				return json;
			}
		}
		return null;
	}
	public String getDeptList(String cCode) {

		ArrayList<Department> distinctdept=Ddao.distinctdept(cCode);
		ArrayList<Department> distinctposition=Ddao.distinctposition(cCode);
		System.out.println(distinctdept);
		ArrayList<String> deptList = new ArrayList<String>();
		ArrayList<String> positionList = new ArrayList<String>();
		for(int i = 0 ; i < distinctdept.size(); i++) {
			deptList.add(distinctdept.get(i).getHDP_dept());
		}
		for(int i = 0 ; i < distinctposition.size(); i++) {
			positionList.add(distinctposition.get(i).getHDP_position());
		}
		HashMap<String, ArrayList<String>> deptAll = new HashMap<String, ArrayList<String>>();
		deptAll.put("deptList", deptList);
		deptAll.put("positionList", positionList);
		Gson gson = new Gson();
		String result = gson.toJson(deptAll);
		System.out.println(result);
		return result;
	}
	public String getDeptAuthList(String cCode) {
		ArrayList<Department> deptlist = Ddao.getDeptAuthlist(cCode); //사실 이게 전체긁어오는거임
		String result = new Gson().toJson(deptlist);
		return result;
	}
	public void updateDeptAuth(String cCode, HttpServletRequest request) {
		for(int i = 0 ; i <request.getParameterValues("HDP_dept").length ; i++) {
			Department dept = new Department();
			dept.setHdp_auth(request.getParameterValues("hdp_auth")[i]);
			dept.setHdp_ccode(cCode);
			dept.setHDP_num(request.getParameterValues("HDP_num")[i]);
			System.out.println(dept);
			Ddao.updateDeptAuth(dept);
			System.out.println(i);

		}
	}
}
