package com.n7.erp.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.bean.hr.Member;
import com.n7.erp.service.HrMM;

@RestController // @ResponseBody 생략가능
@RequestMapping(value = "/rest")
public class HRRestController {

	@Autowired
	private HrMM hm;
	
	@GetMapping(value="/hr/certification")
	public List<Certification> getCTFInfo(String m_id, HttpServletRequest request) {
		List<Certification> ctfList = hm.getCertificationInfo(m_id, request.getServletPath().substring(9));
		return ctfList;
	}
	@GetMapping(value="/hr/hrcard")
	public HR_Card getHRCInfo(String m_id, HttpServletRequest request) {
		HR_Card hrCard = hm.getHrCardInfo(m_id);
		return hrCard;
	}
	@GetMapping(value="/hr/academic")
	public List<Academic> getACInfo(String m_id, HttpServletRequest request) {
		List<Academic> acList = hm.getAcademicInfo(m_id, request.getServletPath().substring(9));
		return acList;
	}
	@GetMapping(value="/hr/career")
	public List<Career> getCRInfo(String m_id, HttpServletRequest request) {
		List<Career> crList = hm.getCareerInfo(m_id, request.getServletPath().substring(9));
		return crList;
	}
	@GetMapping(value="/hr/hrcodefromid")
	public boolean haveHRCodeFromID(String m_id) {
		boolean flag = hm.haveHRCodeFromId(m_id);
		return flag;
	}
	@GetMapping(value="/hr/memberfromid")
	public Member getMemberInfo(String m_id) {
		System.out.println(m_id);
		Member mb = hm.getMemberInfo(m_id);
		return mb;
	}
	
	
}
