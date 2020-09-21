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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.hr.Department;
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
	//�씠�룞愿��젴
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
	
	//�뿬湲곌퉴吏� �씠�룞愿��젴
	
	
	//myinfo �궡�젙蹂� �뒪�뒪濡� �벑濡� 硫붿냼�뱶
	@PostMapping(value="/myinfo/newacademic")
	public String registAcademic(HttpServletRequest request){
		String id = request.getSession().getAttribute("id").toString();
		hm.registAcademic(request, id);
		return "myInfo/myInfo";
	}
	//�깉濡쒖슫 �씠�젰 �젙蹂� �벑濡�
	@PostMapping(value="/myinfo/newcareer")
	public String registCareer(HttpServletRequest request){
		String id = request.getSession().getAttribute("id").toString();
		hm.registCareer(request, id);
		return "myInfo/myInfo";
	}
	//�깉濡쒖슫 �옄寃⑹쬆 �젙蹂� �벑濡�
	@PostMapping(value="/myinfo/newcertification")
	public String registCertification(HttpServletRequest request) throws Exception{
		String id = request.getSession().getAttribute("id").toString();
		hm.registCertification(request, id);
		return "myInfo/myInfo";
	}
	//�깉濡쒖슫 �씤�궗移대뱶 �벑濡�
	@PostMapping(value="/myinfo/newhrcard")
	public String registHRCard(HR_Card hrCard, HttpSession session) {
		hm.registHRCard(hrCard, session.getAttribute("id").toString(), session.getAttribute("cCode").toString());
		return "myInfo/myInfo";
	}
	
	//�궡 湲됱뿬 紐낆꽭�꽌 �씠�룞
	@RequestMapping(value="/myinfo/myPaycheck", method = RequestMethod.GET)
	public ModelAndView moveMyPayCheck(HttpSession session) {
		mav=hm.moveMyPayCheck(session);
		return mav;
	}
	
	//�궡 湲됱뿬 紐낆꽭�꽌 異쒕젰
	@RequestMapping(value = "/myinfo/paycheckselect" ,method = RequestMethod.POST)
	public @ResponseBody String mypayselect(HttpSession session,@RequestParam("month") String month) {
		Department dept = new Department();
		String hrCode=session.getAttribute("hrCode").toString();
		String result=hm.getMyPaySelect(hrCode,month);
		
		return result;
	}
}
