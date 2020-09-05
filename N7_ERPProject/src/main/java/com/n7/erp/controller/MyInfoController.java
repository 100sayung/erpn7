package com.n7.erp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.service.MemberMM;




@Controller
public class MyInfoController {
	
	ModelAndView mav;
	
	@Autowired
	private MemberMM mm;
	//이동관련
	@GetMapping(value="/myinfo/checkattendance")
	public String moveCheckAttendance() {
		return "myInfo/checkAttendance";
	}
	@GetMapping(value="/myinfo/applyholiday")
	public String moveApplyHoliday() {
		return "myInfo/applyHoliday";
	}
	@GetMapping(value="/myinfo/myattendance")
	public String moveMyAttendance() {
		return "myInfo/myAttendance";
	}
	@GetMapping(value="/myinfo/myholiday")
	public String moveMyHoliday() {
		return "myInfo/myHoliday";
	}
	@GetMapping(value="/myinfo/myinfo")
	public String moveMyinfo() {
		return "myInfo/myInfo";
	}
	
	//여기까지 이동관련
}
