package com.n7.erp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.n7.erp.bean.hr.ApplyHoliday;
import com.n7.erp.bean.hr.Department;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.bean.hr.ViewPay;
import com.n7.erp.service.ConsultingBoardMM;
import com.n7.erp.service.AccountMM;
import com.n7.erp.service.HRDepartmentMM;
import com.n7.erp.service.HrMM;
import com.n7.erp.service.MemberMM;

@Controller
public class HRHomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	ModelAndView mav;

	@Autowired private HRDepartmentMM dm;
	@Autowired private HrMM hm;
	@Autowired private MemberMM mm;
	@Autowired private ConsultingBoardMM cbm;
		@Autowired private AccountMM am;

	//�씤�궗移대뱶 �꽭遺��젙蹂� �럹�씠吏�濡� �씠�룞
	@GetMapping(value="/hr/hrModifyDetail")
	public ModelAndView moveModifyDetail(@RequestParam String id) {
		mav.setViewName("/hr/hrModifyDetail");
		return mav;
	}
	//�깉濡쒖슫 �븰�젰 �젙蹂� �벑濡�
	@PostMapping(value="/hr/newacademic/{id}")
	public String registAcademic(HttpServletRequest request, @PathVariable("id") String id) throws Exception{
		hm.registAcademic(request, id);
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	//�깉濡쒖슫 �씠�젰 �젙蹂� �벑濡�
	@PostMapping(value="/hr/newcareer/{id}")
	public String registCareer(HttpServletRequest request, @PathVariable("id") String id) throws Exception{
		hm.registCareer(request, id);
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	//�깉濡쒖슫 �옄寃⑹쬆 �젙蹂� �벑濡�
	@PostMapping(value="/hr/newcertification/{id}")
	public String registCertification(HttpServletRequest request, @PathVariable("id") String id) throws Exception{
		hm.registCertification(request, id);
		return "redirect:/hr/hrModifyDetail?id="+id;
	}
	//�깉濡쒖슫 �씤�궗移대뱶 �벑濡�
	@PostMapping(value="/hr/newhrcard/{id}")
	public String registHRCard(HR_Card hrCard, @PathVariable("id") String id, HttpSession session) {
		hm.registHRCard(hrCard, id, session.getAttribute("cCode").toString());
		return "redirect:/hr/hrModifyDetail?id="+id;
	}

	//�씤�궗移대뱶 �럹�씠吏�濡� �씠�룞
	@GetMapping(value="/hr/movehrcardpage")
	public ModelAndView moveHrCard(HttpSession session) {
		mav = hm.hrCard(session);
		return mav;
	}

	//�궗�썝異쒓껐議고쉶 �럹�씠吏�濡� �씠�룞
	@GetMapping(value = "/hr/attendance")
	public ModelAndView moveAttendance(HttpSession session) {
		mav = hm.checkMemberHrCard(session, "/hr/attendance");
		return mav;
	}
	//洹쇰Т議고쉶 �럹�씠吏�濡� �씠�룞
	@GetMapping(value = "/hr/employeestatus")
	public ModelAndView moveEmployeeStatus(HttpSession session) {
		mav = hm.checkMemberHrCard(session, "/hr/employeestatus");
		return mav;
	}
	//�쑕/�눜吏� 愿�由� �럹�씠吏�濡� �씠�룞
	@GetMapping(value="/hr/retiremm")
	public ModelAndView moveRetireMM(HttpSession session) {
		mav = hm.checkMemberHrCard(session, "/hr/retiremm");
		return mav;
	}


	@RequestMapping(value = "/hr/deptregistpage", method = RequestMethod.GET)
	public String deptregistpage() {
		return "/hr/deptregistpage";
	}

	// 湲됱뿬 議고쉶 �럹�씠吏� �씠�룞
	@RequestMapping(value = "/hr/deduct", method = RequestMethod.GET)
	public ModelAndView moveDeduct(HttpSession session) {
		mav = dm.moveDeduct(session.getAttribute("cCode").toString());

		return mav;
	}

	// 湲됱뿬 議고쉶 �럹�씠吏� �씠�룞
	@RequestMapping(value = "/hr/searchpaymm", method = {RequestMethod.GET , RequestMethod.POST})
	public ModelAndView moveSearchPay(ViewPay pay,HttpSession session) {
		System.out.println("findhrcode="+pay.getHC_HRCODE());
		System.out.println("findccode="+pay.getHC_CCODE());
		System.out.println("findpaydate="+pay.getHP_PAYDATE());
		if(pay.getHP_PAYDATE()==""||pay.getHP_PAYDATE()==null) {
			if(pay.getHC_HRCODE()==null) {
				mav = dm.searchpay(session.getAttribute("cCode").toString());
			}else if(pay.getHC_HRCODE()!=null){
				String view="/hr/payinputmodify";
				mav.setViewName(view);
			}
			return mav;
		}else if(pay.getHP_PAYDATE()!="" || pay.getHP_PAYDATE()!=null){
			mav=dm.payroll(pay);
		}
		return mav;
	}

	// 遺��꽌 吏곴툒 蹂� �럹�씠吏� �씠�룞�떆 . 遺��꽌 . 吏곴툒 . 湲됱븸 蹂꾨줈 紐⑸줉 異쒕젰
	@RequestMapping(value = "/hr/deptpay", method = RequestMethod.GET)
	public ModelAndView moveDeptPay(HttpSession session) {
		mav = dm.deptpayselect(session.getAttribute("cCode").toString());
		mav = dm.distictdp(session.getAttribute("cCode").toString());
		return mav;
	}

	// 遺��꽌 吏곴툒 蹂� 湲덉븸 �닔�젙
	@RequestMapping(value = "/hr/modifydeptpay", method = RequestMethod.POST)
	public @ResponseBody String modifyDeptPay(@Param(value = "dept") String dept, @Param(value = "pay") Integer pay, HttpSession session) {
		String update = dm.deptpayupdate(dept, pay, session.getAttribute("cCode").toString());
		return update;
	}

	// 遺��꽌 吏곴툒 �궘�젣
	@RequestMapping(value = "/hr/deptdelete", method = RequestMethod.POST)
	public @ResponseBody String deptdelete(Integer deptnum, HttpSession session) {
		String d = dm.deptdelete(deptnum, session.getAttribute("cCode").toString());
		return d;
	}

	// 遺��꽌 吏곴툒 �엯�젰
	@RequestMapping(value = "/hr/deptregistinsert", method = RequestMethod.POST)
	public ModelAndView deptregistinsert(Department dept, HttpSession session) {
		System.out.println("dept="+dept.getHDP_dept()+" ...position="+dept.getHDP_position());
			mav = dm.deptregistinsert(dept, session.getAttribute("cCode").toString());
			return mav;
	}

	// 遺��꽌 吏곴툒 蹂� 寃��깋
	@RequestMapping(value = "/hr/distinct", method = RequestMethod.POST)
	public @ResponseBody String distinct(String disdept, String disposition, HttpSession session) {
		String result = dm.findDeptPosition(disdept, disposition, session.getAttribute("cCode").toString());
		return result;
	}

	// 怨듭젣�궗�빆 湲덉븸 �닔�젙
	@RequestMapping(value = "/hr/modifydeduction", method = RequestMethod.POST)
	public @ResponseBody String modifyDeduction(HttpSession session, @Param(value = "deduct") String deduct,
			@Param(value = "denum") Integer denum) {
		String duction = dm.modifyDeduction(deduct, denum, session.getAttribute("cCode").toString());
		return duction;
	}


	//�쑕媛��떊泥�
	@PostMapping(value="/hr/applyholiday")
	public ModelAndView applyHoliday(ApplyHoliday apholi, HttpSession session) {
		mav = hm.applyHoliday(apholi, session);
		return mav;
	}

	@GetMapping(value="/hr/receiptholiday")
	public String moveReceiptHoliady() {
		return "/hr/receiptholiday";
	}



	// 湲됱뿬議고쉶 �럹�씠吏� 紐⑸줉
	@RequestMapping(value = "/hr/searchwages", method = RequestMethod.POST)
	public @ResponseBody String searchwages() {
		String wages = dm.searchwages();
		return wages;
	}
	// 湲됱뿬議고쉶 �긽�꽭�럹�씠吏� �씠�룞
	@RequestMapping(value = "/hr/paydetai", method = RequestMethod.GET)
	public String detailpay(@RequestParam("hc") String hc) {
		mav=dm.detailpay(hc);
		return "/hr/searchpaymm";
	}
	
	
	@RequestMapping(value = "/hr/payinputmodify", method = RequestMethod.GET)
	public ModelAndView detail() {
		String view="/hr/payinputmodify";
		mav.setViewName(view);
		return mav;
	}
	// 湲됱뿬議고쉶 �긽�꽭�럹�씠吏�
	@RequestMapping(value = "/hr/paydetail", method = RequestMethod.GET)
	public ModelAndView paydetail() {
		String view="/hr/paydetail";
		mav.setViewName(view);
		return mav;
	}
	//�궗�썝 湲됱뿬 紐낆꽭�꽌 紐⑸줉
	@PostMapping(value = "/hr/findmonth")
	public @ResponseBody String findmonth(String month,String hrcode,HttpSession session) {
		mav=new ModelAndView();
		String result=dm.findmonth(month,hrcode);
		if(result==null) {
			return "1";
		}
		return result;
	}
	@GetMapping(value="/hr/holidayap")
	public ModelAndView holidayAp() {
		mav=am.approvalLine();
		return mav;
	}

	@GetMapping(value="/hr/holidaydetail")
	public ModelAndView getHolidayDetail(String docunum, HttpSession session) {
		mav = hm.getHolidayDetail(docunum, session);
		return mav;
	}
	
	@RequestMapping(value = "/hr/findcheckpayid", method = RequestMethod.POST)
	public @ResponseBody String findcheckpayid(String checkpayid) {
		String result=dm.findcheckpayid(checkpayid);
		return result;
	}
}
