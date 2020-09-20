package com.n7.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PurchaseController {
	private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	ModelAndView mav;

	@RequestMapping(value = "/purchase/purchasemain", method = RequestMethod.GET)
	public String purchasemain() {
		return "/purchase/purchasemain";
	}
	
	@RequestMapping(value = "/purchase/purchaseinquiryfrm", method = RequestMethod.GET)
	public String purchaseinquiry() {
		return "purchase/purchaseinquiryfrm";
	}

	@RequestMapping(value = "/purchase/orderpreveal", method = RequestMethod.GET)
	public String orderAjaxPreveal() {
		return "purchase/orderpreveal";
	}
	

}
