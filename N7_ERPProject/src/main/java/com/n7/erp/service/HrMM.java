package com.n7.erp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.NameHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.n7.erp.bean.ApprovalDocu;
import com.n7.erp.bean.Member;
import com.n7.erp.bean.entity.NameHoliday;
import com.n7.erp.bean.entity.NameHrCode;
import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.ApplyHoliday;
import com.n7.erp.bean.hr.Attendance;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.dao.HRIDeptDao;
import com.n7.erp.dao.IBaiscDao;
import com.n7.erp.dao.IHrDao;
import com.n7.erp.dao.IMemberDao;

@Service
public class HrMM {

	ModelAndView mav = new ModelAndView();

	@Autowired
	private IHrDao hDao;
	@Autowired
	private IMemberDao mDao;
	@Autowired
	private HRIDeptDao dDao;
	@Autowired
	private IBaiscDao bDao;

	String view = "";

	public HR_Card getHrCardInfo(String id) {
		HR_Card hrCard = hDao.getHrCardDetail(id);
		return hrCard;
	}

	public List<Certification> getCertificationInfo(String id, String type, String cCode) {
		String hc_hrcode = hDao.getHrCodeFromID(id);
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("code", hc_hrcode);
		hMap.put("type", type);
		hMap.put("cCode", cCode);
		hMap.put("column", "hct");
		List<Certification> ctfList = hDao.getCertificationInfo(hMap);
		return ctfList;
	}

	public List<Career> getCareerInfo(String id, String type, String cCode) {
		String hc_hrcode = hDao.getHrCodeFromID(id);
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("code", hc_hrcode);
		hMap.put("type", type);
		hMap.put("cCode", cCode);
		hMap.put("column", "hcr");
		List<Career> crList = hDao.getCareerInfo(hMap);
		return crList;
	}

	public List<Academic> getAcademicInfo(String id, String type, String cCode) {
		String hc_hrcode = hDao.getHrCodeFromID(id);
		HashMap<String, String> hMap = new HashMap<String, String>();
		System.out.println(hc_hrcode);
		hMap.put("code", hc_hrcode);
		hMap.put("type", type);
		hMap.put("cCode", cCode);
		hMap.put("column", "hac");
		List<Academic> acList = hDao.getAcademicInfo(hMap);
		return acList;
	}

	public void registAcademic(HttpServletRequest request, String id) {
		HashMap<String, String> acMap = new HashMap<String, String>();
		String hc_hrcode = hDao.getHrCodeFromID(id);
		String cCode = request.getSession().getAttribute("cCode").toString();
		acMap.put("hrcode", hc_hrcode);
		acMap.put("cCode", cCode);
		Integer cnt = hDao.selectAcademic(acMap);
		for (int i = 0; i < request.getParameterValues("hac_school").length; i++) {
			Academic ac = new Academic();
			ac.setHac_ccode(cCode);
			ac.setHac_hrcode(hc_hrcode);
			ac.setHac_school(request.getParameterValues("hac_school")[i]);
			ac.setHac_major(request.getParameterValues("hac_major")[i]);
			ac.setHac_year(request.getParameterValues("hac_year")[i]);
			if (i < cnt) {
				ac.setHac_num(request.getParameterValues("hac_num")[i]);
				hDao.updateAcademic(ac);
				System.out.println("update : " + i);
			} else {
				hDao.registAcademic(ac);
			}
		}
		System.out.println("Academic");
	}

	public void registCareer(HttpServletRequest request, String id) {
		HashMap<String, String> crMap = new HashMap<String, String>();
		String hc_hrcode = hDao.getHrCodeFromID(id);
		String cCode = request.getSession().getAttribute("cCode").toString();
		crMap.put("hrcode", hc_hrcode);
		crMap.put("cCode", cCode);
		Integer cnt = hDao.selectCareer(crMap);
		for (int i = 0; i < request.getParameterValues("hcr_cname").length; i++) {
			Career cr = new Career();
			cr.setHcr_ccode(cCode);
			cr.setHcr_name(request.getParameterValues("hcr_cname")[i]);
			cr.setHcr_content(request.getParameterValues("hcr_content")[i]);
			cr.setHcr_startperiod(request.getParameterValues("hcr_startperiod")[i]);
			cr.setHcr_endperiod(request.getParameterValues("hcr_endperiod")[i]);
			cr.setHcr_position(request.getParameterValues("hcr_position")[i]);
			cr.setHcr_hrcode(hc_hrcode);
			if (i < cnt) {
				cr.setHcr_num(request.getParameterValues("hra_num")[i]);
				hDao.updateCareer(cr);
			} else {
				hDao.registCareer(cr);
			}
		}
		System.out.println("Career");
	}

	public void registCertification(HttpServletRequest request, String id) {
		HashMap<String, String> ctfMap = new HashMap<String, String>();
		String cCode = request.getSession().getAttribute("cCode").toString();
		String hc_hrcode = hDao.getHrCodeFromID(id);
		ctfMap.put("hrcode", hc_hrcode);
		ctfMap.put("cCode", cCode);
		Integer cnt = hDao.selectCertification(ctfMap);
		for (int i = 0; i < request.getParameterValues("hct_agency").length; i++) {
			Certification ctf = new Certification();
			ctf.setHct_ccode(cCode);
			ctf.setHct_hrcode(hc_hrcode);
			ctf.setHct_agency(request.getParameterValues("hct_agency")[i]);
			ctf.setHct_date(request.getParameterValues("hct_date")[i]);
			ctf.setHct_name(request.getParameterValues("hct_name")[i]);
			if (i < cnt) {
				ctf.setHct_num(request.getParameterValues("hct_num")[i]);
				hDao.updateCertification(ctf);
			} else {
				hDao.registCertification(ctf);
			}
		}
	}

	public void registHRCard(HR_Card hrCard, String id, String cCode) {
		System.out.println(id);
		hrCard.setHc_id(id);
		hrCard.setHc_ccode(cCode);
		System.out.println(hrCard.getHc_joindate());
		hrCard.setHc_hrcode(hrCard.getHc_joindate().toString().replace("-", ""));
		if (hDao.selectHRCard(id)) {
			hDao.updateHRCard(hrCard);
		} else {
			hDao.registHRCard(hrCard);
		}
	}

	public boolean haveHRCodeFromId(String m_id) {
		boolean flag = hDao.haveHRCodeFromId(m_id);
		return flag;
	}

	public Member getMemberInfo(String m_id) {
		Member mb = hDao.getMemberInfo(m_id);
		return mb;
	}

	public ModelAndView hrCard(HttpSession session) {
		String m_id = session.getAttribute("id").toString();
		String m_ccode = session.getAttribute("cCode").toString();

		System.out.println(m_ccode);

		ArrayList<Member> hrCardList = new ArrayList<>();
		hrCardList = mDao.getHRCard(m_ccode);

		mav.addObject("hrCard", makeHRCardList(hrCardList));
		mav.setViewName("/hr/hrCard");
		return mav;
	}

	private String makeHRCardList(ArrayList<Member> hList) {
		StringBuilder str = new StringBuilder();
		str.append("<table id='table1'>");
		str.append("<tr><td></td><td>�</td><td></td><td></td><td></td></tr>");
		for (int i = 0; i < hList.size(); i++) {
			str.append("<tr><td><img src='/erp/upload/" + hList.get(i).getM_photo() + "'></td>");
			str.append("<td>" + hList.get(i).getM_name() + "</td>");
			str.append("<td>" + hList.get(i).getM_birth() + "</td>");
			str.append("<td>" + hList.get(i).getM_email() + "</td><td>");
			str.append("<input type='button' value='' onclick='modifyDetail(\"" + hList.get(i).getM_id()
					+ "\")'></td></tr>");
		}
		str.append("</table>");
		return str.toString();
	}

	public String logAttendance(String cCode, String id, String status, String time) {
		String hrCode = hDao.getHrCodeFromID(id);
		System.out.println(time);
		System.out.println(status);
		HashMap<String, String> logAtMap = new HashMap<String, String>();
		logAtMap.put("hrCode", hrCode);
		logAtMap.put("cCode", cCode);
		logAtMap.put("time", time);
		String type;
		if (status.equals("in")) {
			type = "1";
		} else {
			type = "0";
		}
		logAtMap.put("type", type);
		System.out.println("type은? " + logAtMap.get("type"));
		hDao.logAttendance(logAtMap);
		hDao.logStatusToHrCard(logAtMap);
		return type;
	}

	public ModelAndView applyHoliday(ApplyHoliday apholi, HttpSession session) {
		String id = session.getAttribute("id").toString();
		String cCode = session.getAttribute("cCode").toString();
		String hrCode = hDao.getHrCodeFromID(id);

		// 결재문서양식부터 등록
		ApprovalDocu docu = new ApprovalDocu();
		docu.setAp_ccode(cCode).setAp_docuname(apholi.getHap_docuname()).setAp_docunum("H");
		docu.setAp_fromapprover(hrCode).setAp_toapprover(apholi.getHap_toapprover());

		apholi.setHap_ccode(cCode).setHap_hrcode(hrCode);
		apholi.setHap_fromapprover(hrCode).setHap_docunum("H");

		if (bDao.registHolidayApprovalDocu(docu)) {
			hDao.registHoliday(apholi);
		}
		mav.setViewName("/myInfo/myHoliday");
		return mav;
	}

	public String getMyLeaderUsingGrade(HttpSession session, String string) {

		String id = session.getAttribute("id").toString();
		String cCode = session.getAttribute("cCode").toString();
		String myDept = hDao.getHrCardDetail(id).getHc_dept();

		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("authority", string);
		hMap.put("cCode", cCode);
		hMap.put("myDept", myDept);
		ArrayList<NameHrCode> nlist = dDao.getMyLeaderUsingGradeDept(hMap);
		String result = new Gson().toJson(nlist);
		System.out.println(result);
		return result;
	}

	public String getMyAttendance(HttpSession session, String day, String yearmonth) {
		Attendance at = new Attendance();

		String id = session.getAttribute("id").toString();
		String cCode = session.getAttribute("cCode").toString();
		String hrCode = hDao.getHrCodeFromID(id);

		// 검색을 위해서 양식 만들기
		int dayInt = Integer.parseInt(day);
		if (dayInt < 10) {
			day = "0" + day;
		}
		String month = "";
		if (yearmonth.substring(6).equals("1월")) {
			month = "Jan";
		} else if (yearmonth.substring(6).equals("2월")) {
			month = "Feb";
		} else if (yearmonth.substring(6).equals("3월")) {
			month = "Mar";
		} else if (yearmonth.substring(6).equals("4월")) {
			month = "Apr";
		} else if (yearmonth.substring(6).equals("5월")) {
			month = "May";
		} else if (yearmonth.substring(6).equals("6월")) {
			month = "Jun";
		} else if (yearmonth.substring(6).equals("7월")) {
			month = "Jul";
		} else if (yearmonth.substring(6).equals("8월")) {
			month = "Aug";
		} else if (yearmonth.substring(6).equals("9월")) {
			month = "Sep";
		} else if (yearmonth.substring(6).equals("10월")) {
			month = "Oct";
		} else if (yearmonth.substring(6).equals("11월")) {
			month = "Nov";
		} else if (yearmonth.substring(6).equals("12월")) {
			month = "Dec";
		}
		String dateStandard = "%" + month + " " + day + " " + yearmonth.substring(0, 4) + "%";
		System.out.println(dateStandard);

		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("hrCode", hrCode);
		hMap.put("cCode", cCode);
		hMap.put("dateStandard", dateStandard);

		ArrayList<Attendance> atList = hDao.getMyAttendance(hMap);
		String result = new Gson().toJson(atList);
		return result;
	}
	public String getAllMyAttendance(HttpSession session, String yearmonth) {
		String cCode = session.getAttribute("cCode").toString();
		String hrCode = session.getAttribute("hrCode").toString();
		String month = monthConvert(yearmonth.substring(6));
		String date = "%" + month + "%" + yearmonth.substring(0, 4) + "%";
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("hrCode", hrCode);
		hMap.put("cCode", cCode);
		hMap.put("date", date);

		ArrayList<Attendance> atList = hDao.getAllMyAttendance(hMap);
		String result = new Gson().toJson(atList);
		return result;
	}

	public String getMyHoliday(HttpSession session) {
		String id = session.getAttribute("id").toString();
		String cCode = session.getAttribute("cCode").toString();
		String hrCode = hDao.getHrCodeFromID(id);

		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("hrCode", hrCode);
		hMap.put("cCode", cCode);

		ArrayList<ApplyHoliday> ahList = hDao.getMyHoliday(hMap);
		String result = new Gson().toJson(ahList);
		return result;
	}

	public String getCurAttendance(String id) {
		String curAttendance = hDao.getHrCardDetail(id).getHc_status();

		return curAttendance;

	}

	public String getEmployeeAttendance(HttpSession session, String day, String yearmonth) {

		String id = session.getAttribute("id").toString();
		String cCode = session.getAttribute("cCode").toString();

		// 검색을 위해서 양식 만들기
		int dayInt = Integer.parseInt(day);
		if (dayInt < 10) {
			day = "0" + day;
		}
		String month = monthConvert(yearmonth.substring(6));
		String dateStandard = "%" + month + " " + day + " " + yearmonth.substring(0, 4) + "%";
		System.out.println(dateStandard);

		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("cCode", cCode);
		hMap.put("dateStandard", dateStandard);

		ArrayList<Attendance> atList = hDao.getEmployeeAttendance(hMap);
		String result = new Gson().toJson(atList);
		return result;
	}

	public String getCheckRetired(String cCode, String status) {
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("cCode", cCode);
		hMap.put("status", status);
		ArrayList<HR_Card> hList = hDao.getCheckRetired(hMap);
		System.out.println(hList);
		String result = new Gson().toJson(hList);
		System.out.println("테스트중" + result);
		return result;
	}

	public String getDetailHoliday(String cCode, String docunum) {
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("docunum", docunum);
		hMap.put("cCode", cCode);
		String result = new Gson().toJson(hDao.getDetailHoliday(hMap));
		return result;
	}

	public void updateRetired(String cCode, String hrCode, String work) {
		HR_Card hrCard = new HR_Card();
		hrCard.setHc_ccode(cCode);
		hrCard.setHc_hrcode(hrCode);
		hrCard.setHc_work(work);
		hDao.updateRetired(hrCard);
	}

	public String getEmployeeStatus(HttpSession session) {
		String cCode = session.getAttribute("cCode").toString();
		ArrayList<HR_Card> hlist = hDao.getEmployeeStatus(cCode);
		String result = new Gson().toJson(hlist);
		return result;
	}


	public String getEmployeeHoliday(HttpSession session, String yearmonth) {
		String cCode = session.getAttribute("cCode").toString();
		System.out.println(yearmonth);
		String month = yearmonth.substring(6);
		month = month.substring(0, month.length()-1);
		if(Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		String date = yearmonth.substring(0, 4) + "-" + month + "%";
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("cCode", cCode);
		hMap.put("date", date);
		ArrayList<NameHoliday> holiList = hDao.getEmployeeHoliday(hMap);
		System.out.println(holiList);
		String result = new Gson().toJson(holiList);
		return result;
	}


	private String monthConvert(String number) {
		String month = "";
		if (number.equals("1월")) {
			month = "Jan";
		} else if (number.equals("2월")) {
			month = "Feb";
		} else if (number.equals("3월")) {
			month = "Mar";
		} else if (number.equals("4월")) {
			month = "Apr";
		} else if (number.equals("5월")) {
			month = "May";
		} else if (number.equals("6월")) {
			month = "Jun";
		} else if (number.equals("7월")) {
			month = "Jul";
		} else if (number.equals("8월")) {
			month = "Aug";
		} else if (number.equals("9월")) {
			month = "Sep";
		} else if (number.equals("10월")) {
			month = "Oct";
		} else if (number.equals("11월")) {
			month = "Nov";
		} else if (number.equals("12월")) {
			month = "Dec";
		}
		return month;
	}

}
