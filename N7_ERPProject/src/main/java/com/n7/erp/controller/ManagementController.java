package com.n7.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.hr.Department;
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

	@PostMapping(value="/management/updateDeptAuth")
	public String updateDeptAuth(HttpServletRequest request) {
		dm.updateDeptAuth(request.getSession().getAttribute("cCode").toString(), request);

		return "/management/deptauth";
	}


}
