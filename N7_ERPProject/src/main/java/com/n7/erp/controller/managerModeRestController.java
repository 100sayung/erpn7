package com.n7.erp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.Company;
import com.n7.erp.bean.Menu;
import com.n7.erp.bean.clientMenu;
import com.n7.erp.service.menuMM;

@RestController
@RequestMapping(value="/rest")
public class managerModeRestController {
	@Autowired
	menuMM mm;
	
	ModelAndView mav;
	
	@GetMapping(value = "/managermode/getmenu",produces="application/json;charset=utf-8" )
	public  Map<String, List<Menu>> getmenu() {
		Map<String, List<Menu>> mMap=mm.getmenu();
		return mMap;
	}
	@GetMapping(value = "/managermode/getaddmenu",produces="application/json;charset=utf-8" )
	public  Map<String, List<clientMenu>> getaddmenu(HttpSession session) {
		Map<String, List<clientMenu>> mMap=mm.getaddmenu(session);
		return mMap;
	}
	@GetMapping(value = "/managermode/getCompanyInfo",produces="application/json;charset=utf-8" )
	public  Map<String, List<Company>> getCompanyInfo(HttpSession session) {
		Map<String, List<Company>> mMap=mm.getCompanyInfo(session);
		return mMap;
	}
	@PostMapping(value = "/managermode/addmenu",produces="application/json;charset=utf-8" )
	public  Map<String, Object> addmenu(String MENU, HttpSession session) {
		String [] strArray = MENU.split(",");
		Map<String, Object> mMap=mm.addmenu(strArray,session);
		return mMap;
	}
	@PostMapping(value = "/managermode/companyUpdate",produces="application/json;charset=utf-8" )
	public  ModelAndView companyUpdate(Company cp) {
		 mav = mm.companyUpdate(cp);
		return mav;
	}
	
	//내정보 메뉴출력용!
	@GetMapping(value="/managermode/myinfomenu", produces = "application/json;charset=utf-8")
	public boolean myInfoMenu(HttpSession session) {
		boolean result = mm.myInfoMenu(session);
		return result;
	}
}
