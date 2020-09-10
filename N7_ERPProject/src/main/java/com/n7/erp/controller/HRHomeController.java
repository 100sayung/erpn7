package com.n7.erp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.hr.ApplyHoliday;
import com.n7.erp.bean.hr.Department;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.service.HRDepartmentMM;
import com.n7.erp.service.HrMM;
import com.n7.erp.service.MemberMM;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HRHomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	ModelAndView mav;

	@Autowired private HRDepartmentMM dm;
	@Autowired private HrMM hm;
	@Autowired private MemberMM mm;
	
	//인사카드 세부정보 페이지로 이동 
	@GetMapping(value="/hr/hrModifyDetail")
	public ModelAndView moveModifyDetail(@RequestParam String id) {
		mav.setViewName("/hr/hrModifyDetail");
		return mav;
	}
	//새로운 학력 정보 등록
	@PostMapping(value="/hr/newacademic/{id}")
	public String registAcademic(HttpServletRequest request, @PathVariable("id") String id) throws Exception{
		hm.registAcademic(request, id);
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	//새로운 이력 정보 등록
	@PostMapping(value="/hr/newcareer/{id}")
	public String registCareer(HttpServletRequest request, @PathVariable("id") String id) throws Exception{
		hm.registCareer(request, id);
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	//새로운 자격증 정보 등록
	@PostMapping(value="/hr/newcertification/{id}")
	public String registCertification(HttpServletRequest request, @PathVariable("id") String id) throws Exception{
		hm.registCertification(request, id);
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	//새로운 인사카드 등록
	@PostMapping(value="/hr/newhrcard/{id}")
	public String registHRCard(HR_Card hrCard, @PathVariable("id") String id, HttpSession session) {
		hm.registHRCard(hrCard, id, session.getAttribute("cCode").toString());
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	
	//인사카드 페이지로 이동
	@GetMapping(value="/hr/movehrcardpage")
	public ModelAndView moveHrCard(HttpSession session) {
		mav = hm.hrCard(session);
		return mav;
	}
	
	//사원출결조회 페이지로 이동
	@GetMapping(value = "/hr/attendance")
	public String moveAttendance() {
		return "/hr/attendance";
	}
	//근무조회 페이지로 이동
	@GetMapping(value = "/hr/employeestatus")
	public String moveEmployeeStatus() {
		return "/hr/employeestatus";
	}
	//휴/퇴직 관리 페이지로 이동
	@GetMapping(value="/hr/retiremm")
	public String moveRetireMM() {
		return "/hr/retiremm";
	}
	
	
	@RequestMapping(value = "/hr/deptregistpage", method = RequestMethod.GET)
	public String deptregistpage() {
		logger.info("부서 등록페이지 이동");
		return "/hr/deptregistpage";
	}

	// 급여 조회 페이지 이동
	@RequestMapping(value = "/hr/deduct", method = RequestMethod.GET)
	public ModelAndView moveDeduct(HttpSession session) {
		mav = dm.moveDeduct(session.getAttribute("cCode").toString());

		return mav;
	}

	// 급여 조회 페이지 이동
	@RequestMapping(value = "/hr/searchpay", method = RequestMethod.GET)
	public ModelAndView moveSearchPay(HttpSession session) {
		mav = dm.searchpay(session.getAttribute("cCode").toString());

		return mav;
	}

	// 부서 직급 별 페이지 이동시 . 부서 . 직급 . 급액 별로 목록 출력
	@RequestMapping(value = "/hr/deptpay", method = RequestMethod.GET)
	public ModelAndView moveDeptPay(HttpSession session) {
		mav = dm.deptpayselect(session.getAttribute("cCode").toString());
		mav = dm.distictdp(session.getAttribute("cCode").toString());
		return mav;
	}

	// 부서 직급 별 금액 수정
	@RequestMapping(value = "/hr/modifydeptpay", method = RequestMethod.POST)
	public @ResponseBody String modifyDeptPay(@Param(value = "dept") String dept, @Param(value = "pay") Integer pay, HttpSession session) {
		System.out.println(dept + "," + pay);
		String update = dm.deptpayupdate(dept, pay, session.getAttribute("cCode").toString());
		System.out.println("금액1=" + update);
		return update;
	}

	// 부서 직급 삭제
	@RequestMapping(value = "/hr/deptdelete", method = RequestMethod.POST)
	public @ResponseBody String deptdelete(Integer deptnum, HttpSession session) {
		System.out.println("삭제 서비스 첫번째" + deptnum);
		String d = dm.deptdelete(deptnum, session.getAttribute("cCode").toString());
		return d;
	}

	// 부서 직급 삽입
	@RequestMapping(value = "/hr/deptregistinsert", method = RequestMethod.POST)
	public ModelAndView deptregistinsert(Department dept, HttpSession session) {
		mav = dm.deptregistinsert(dept, session.getAttribute("cCode").toString());
		return mav;
	}

	// 부서 직급 별 검색
	@RequestMapping(value = "/hr/distinct", method = RequestMethod.POST)
	public @ResponseBody String distinct(String disdept, String disposition, HttpSession session) {
		String result = dm.findDeptPosition(disdept, disposition, session.getAttribute("cCode").toString());
		return result;
	}

	// 공제사항 금액 수정
	@RequestMapping(value = "/hr/modifydeduction", method = RequestMethod.POST)
	public @ResponseBody String modifyDeduction(HttpSession session, @Param(value = "deduct") String deduct,
			@Param(value = "denum") Integer denum) {
		System.out.println(deduct + "," + denum);
		String duction = dm.modifyDeduction(deduct, denum, session.getAttribute("cCode").toString());
		System.out.println("넘어온 값=" + duction);
		return duction;
	}
	
	
	//휴가신청
	@PostMapping(value="/hr/applyholiday")
	public ModelAndView applyHoliday(ApplyHoliday apholi, HttpSession session) {
		mav = hm.applyHoliday(apholi, session);
		return mav;
	}
	
}
