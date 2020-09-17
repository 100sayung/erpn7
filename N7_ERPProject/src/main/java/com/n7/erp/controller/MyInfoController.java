package com.n7.erp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.service.HrMM;
import com.n7.erp.service.MemberMM;




@Controller
public class MyInfoController {
	
	ModelAndView mav;
	
	@Autowired
	private MemberMM mm;
	@Autowired
	private HrMM hm;
	//이동관련
	@GetMapping(value="/myinfo/checkattendance")
	public ModelAndView moveCheckAttendance(HttpSession session) {
		mav = hm.checkMyHrCard(session, "myInfo/checkAttendance");
		return mav;
	}
	@GetMapping(value="/myinfo/applyholiday")
	public ModelAndView moveApplyHoliday(HttpSession session) {
		mav = hm.checkMyHrCard(session, "/myInfo/applyHoliday");
		return mav;
	}
	@GetMapping(value="/myinfo/myattendance")
	public ModelAndView moveMyAttendance(HttpSession session) {
		mav = hm.checkMyHrCard(session, "/myInfo/myAttendance");
		return mav;
	}
	@GetMapping(value="/myinfo/myholiday")
	public ModelAndView moveMyHoliday(HttpSession session) {
		mav = hm.checkMyHrCard(session, "myInfo/myHoliday");
		return mav;
	}
	
	//여기까지 이동관련
	
	
	//myinfo 내정보 스스로 등록 메소드
	@PostMapping(value="/myinfo/newacademic")
	public String registAcademic(HttpServletRequest request){
		String id = request.getSession().getAttribute("id").toString();
		hm.registAcademic(request, id);
		return "myInfo/myInfo";
	}
	//새로운 이력 정보 등록
	@PostMapping(value="/myinfo/newcareer")
	public String registCareer(HttpServletRequest request){
		String id = request.getSession().getAttribute("id").toString();
		hm.registCareer(request, id);
		return "myInfo/myInfo";
	}
	//새로운 자격증 정보 등록
	@PostMapping(value="/myinfo/newcertification")
	public String registCertification(HttpServletRequest request) throws Exception{
		String id = request.getSession().getAttribute("id").toString();
		hm.registCertification(request, id);
		return "myInfo/myInfo";
	}
	//새로운 인사카드 등록
	@PostMapping(value="/myinfo/newhrcard")
	public String registHRCard(HR_Card hrCard, HttpSession session) {
		hm.registHRCard(hrCard, session.getAttribute("id").toString(), session.getAttribute("cCode").toString());
		return "myInfo/myInfo";
	}
}
