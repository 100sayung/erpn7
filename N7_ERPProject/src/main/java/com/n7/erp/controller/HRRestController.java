package com.n7.erp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7.erp.bean.Member;
import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.Department;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.service.HRDepartmentMM;
import com.n7.erp.service.HrMM;

@RestController // @ResponseBody 생략가능
@RequestMapping(value = "/rest")
public class HRRestController {

	@Autowired
	private HrMM hm;
	@Autowired private HRDepartmentMM deptmm;
	//자격증 리스트 출력
	@GetMapping(value="/hr/certification")
	public List<Certification> getCTFInfo(String m_id, HttpServletRequest request) {
		List<Certification> ctfList = hm.getCertificationInfo(m_id, request.getServletPath().substring(9), request.getSession().getAttribute("cCode").toString());
		return ctfList;
	}
	//인사카드 정보 출력
	@GetMapping(value="/hr/hrcard")
	public HR_Card getHRCInfo(String m_id, HttpServletRequest request) {
		HR_Card hrCard = hm.getHrCardInfo(m_id);
		return hrCard;
	}
	//학력 리스트 출력
	@GetMapping(value="/hr/academic")
	public List<Academic> getACInfo(String m_id, HttpServletRequest request) {
		List<Academic> acList = hm.getAcademicInfo(m_id, request.getServletPath().substring(9), request.getSession().getAttribute("cCode").toString());
		return acList;
	}
	//이력 리스트 출력
	@GetMapping(value="/hr/career")
	public List<Career> getCRInfo(String m_id, HttpServletRequest request) {
		List<Career> crList = hm.getCareerInfo(m_id, request.getServletPath().substring(9), request.getSession().getAttribute("cCode").toString());
		return crList;
	}
	
	//id로부터 hrCard가 존재하는지 안하는지 체크함!!!
	@GetMapping(value="/hr/hrcodefromid")
	public boolean haveHRCodeFromID(String m_id) {
		boolean flag = hm.haveHRCodeFromId(m_id);
		return flag;
	}
	//id로부터 member정보 가져옴!
	@GetMapping(value="/hr/memberfromid")
	public Member getMemberInfo(String m_id) {
		System.out.println(m_id);
		Member mb = hm.getMemberInfo(m_id);
		return mb;
	}
	
	//
	@GetMapping(value = "/hr/deptlist")
	public String getDeptList(HttpSession session) {
		Department dept = new Department();
		String result = deptmm.getDeptList(session.getAttribute("cCode").toString());
		return result;
	}
	//부서 등급 검색
	@GetMapping(value = "/hr/deptauthlist")
	public String getDeptAuthList(HttpSession session) {
		String result = deptmm.getDeptAuthList(session.getAttribute("cCode").toString());
		return result;
	}
	//휴가신청
	@GetMapping(value = "/hr/myleaderlist")
	public String getMyLeaderUsingGrade(HttpSession session){
		String leaderList = hm.getMyLeaderUsingGrade(session, "2");
		return leaderList;
	}
	
	
	//근태관리
	
	//출결등록
	@PostMapping(value = "/hr/attendance") 
	public String logAttendance(HttpSession session, String status, String time) {
		String result = hm.logAttendance(session.getAttribute("cCode").toString(), session.getAttribute("id").toString(), status,time);
		return result;
	}
	//현재상태확인
	@GetMapping(value="/hr/currentattendance")
	public String getCurAttendance(HttpSession session) {
		String result = hm.getCurAttendance(session.getAttribute("id").toString());
		return result;
	}
	
	//사원출결조회
	@GetMapping(value="/hr/employeeattendance")
	public String getMyAttendance(HttpSession session, String day, String yearmonth) {
		String result = hm.getEmployeeAttendance(session, day, yearmonth);
		return result; 
	}
	
	//근무조회
	@GetMapping(value="/hr/employeestatus")
	public String getEmployeeStatus(HttpSession session) {
		String result = hm.getEmployeeStatus(session);
		return result;
	}
	//사원 휴가 조회
	@GetMapping(value="/hr/employeeholiday")
	public String getEmployeeHoliday(HttpSession session, String yearmonth) {
		String result = hm.getEmployeeHoliday(session, yearmonth);
		return result;
	}
	
	
	//사원 휴/퇴직 상태 조회
	@GetMapping(value="/hr/checkretired")
	public String getCheckRetired(HttpSession session, String status) {
		String result = hm.getCheckRetired(session.getAttribute("cCode").toString(), status);
		return result;
	}
	@PostMapping(value="/hr/updateretired")
	public void updateRetired(HttpSession session, String hrCode, String work) {
		hm.updateRetired(session.getAttribute("cCode").toString(), hrCode, work);
	}
	
	@GetMapping(value="/hr/detailholiday")
	public String getDetailHoliday(HttpSession session, String docunum) {
		String result = hm.getDetailHoliday(session.getAttribute("cCode").toString(), docunum);
		return result;
	}
}
