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
	
	@GetMapping(value="myinfo/checkattendance")
	public String moveCheckAttendance() {
		return "myInfo/checkAttendance";
	}
	
}
