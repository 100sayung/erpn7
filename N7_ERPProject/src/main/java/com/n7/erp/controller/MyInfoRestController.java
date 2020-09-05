package com.n7.erp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7.erp.service.MyInfoMM;

@RestController // @ResponseBody 생략가능
@RequestMapping(value = "/rest")
public class MyInfoRestController {
	
	@Autowired MyInfoMM imm;
	
	
	//myInfo에 내 정보 출력
	@GetMapping(value="/myinfo/myinfo")
	public String getMyInfo(HttpSession session) {
		
		String json =  imm.getMyInfo(session);
		return json;
	}
}
