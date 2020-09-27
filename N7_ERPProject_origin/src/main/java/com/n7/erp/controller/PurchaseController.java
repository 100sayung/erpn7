package com.n7.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.service.PurchaseMM;


@Controller
public class PurchaseController {
	private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
	@Autowired
	PurchaseMM pm;

	ModelAndView mav;

	@RequestMapping(value = "Purchase/erpmain", method = RequestMethod.GET)
	public String purchasemain() {
		return "Purchase/erpmain";
	}
	
	@RequestMapping(value = "Purchase/pregistration", method = RequestMethod.GET)
	public String pregistration() {
		return "Purchase/pregistration";
	}
	
	@RequestMapping(value = "Purchase/purchasedetail", method = RequestMethod.GET)
	public ModelAndView purchasedetail(String check) {
		mav = pm.pDetail(check);
		System.out.println("check들어감?="+check);
		return mav;
	}
	
	@RequestMapping(value = "Purchase/pprogramwrite", method = RequestMethod.GET)
	public ModelAndView pprogramwrite(String check) {
		System.out.println("check="+check);
		mav = pm.pProgram(check);
		return mav;
	}
	
	
	@RequestMapping(value = "Purchase/returnregistration", method = RequestMethod.GET)
	public String returnregistration() {
		return "Purchase/returnregistration";
	}
	

}