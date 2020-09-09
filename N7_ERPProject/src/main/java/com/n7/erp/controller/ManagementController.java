package com.n7.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.service.HRDepartmentMM;
import com.n7.erp.service.HrMM;
import com.n7.erp.service.MemberMM;

@Controller
public class ManagementController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ModelAndView mav;
	@Autowired private HRDepartmentMM dm;
	@Autowired private HrMM hm;
	@Autowired private MemberMM mm;

	@GetMapping(value="/management/deptauth")
	public String moveDeptAuth() {
		return "/management/deptauth";
	}
}
