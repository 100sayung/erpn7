package com.n7.erp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.bean.hr.Member;
import com.n7.erp.dao.IHrDao;
import com.n7.erp.dao.IMemberDao;

@Service
public class HrMM {

	ModelAndView mav = new ModelAndView();
	/*
	 * DB설정 뒤 DB관련 주석풀기
	 * 
	 * @Autowired private IHrDao hDao;
	 */
	String view = "";

	public HR_Card getHrCardInfo(String id) {
		HR_Card hrCard = null; //hDao.getHrCard(id);
		return hrCard;
	}

	public List<Certification> getCertificationInfo(String id, String type) {
//		String hc_code = hDao.getHcCodeFromID(id);
//		HashMap<String, String> hMap = new HashMap<String, String>();
//		hMap.put("code", hc_code);
//		hMap.put("type", type);
//		hMap.put("column", "hct");
		List<Certification> ctfList = null; //hDao.getCertificationInfo(hMap);
		return ctfList;
	}

	public List<Career> getCareerInfo(String id, String type) {
//		String hc_code = hDao.getHcCodeFromID(id);
//		HashMap<String, String> hMap = new HashMap<String, String>();
//		hMap.put("code", hc_code);
//		hMap.put("type", type);
//		hMap.put("column", "hca");
		List<Career> crList = null; //hDao.getCareerInfo(hMap);
		return crList;
	}

	public List<Academic> getAcademicInfo(String id, String type) {
//		String hc_code = hDao.getHcCodeFromID(id);
//		HashMap<String, String> hMap = new HashMap<String, String>();
//		System.out.println(hc_code);
//		hMap.put("code", hc_code);
//		hMap.put("type", type);
//		hMap.put("column", "hac");
		List<Academic> acList = null;//hDao.getAcademicInfo(hMap);
		return acList;
	}

	public void registAcademic(HttpServletRequest request, String id) {
//		String hc_code = hDao.getHcCodeFromID(id);
//		Integer cnt = hDao.selectAcademic(hc_code);
//		for (int i = 0; i < request.getParameterValues("hac_school").length; i++) {
//			Academic ac = new Academic();
//			ac.setHac_code(hc_code);
//			ac.setHac_school(request.getParameterValues("hac_school")[i]);
//			ac.setHac_major(request.getParameterValues("hac_major")[i]);
//			ac.setHac_year(request.getParameterValues("hac_year")[i]);
//			if (i < cnt) {
//				ac.setHac_num(request.getParameterValues("hac_num")[i]);
//				hDao.updateAcademic(ac);
//				System.out.println("update : " + i);
//			}else {
//				hDao.registAcademic(ac);
//			}
//		}
		System.out.println("Academic");
	}

	public void registCareer(HttpServletRequest request, String id) {
//		String hc_code = hDao.getHcCodeFromID(id);
//		Integer cnt = hDao.selectCareer(hc_code);
//		for (int i = 0; i < request.getParameterValues("hca_cname").length; i++) {
//			Career cr = new Career();
//			cr.setHca_cname(request.getParameterValues("hca_cname")[i]);
//			cr.setHca_content(request.getParameterValues("hca_content")[i]);
//			cr.setHca_period(request.getParameterValues("hca_period")[i]);
//			cr.setHca_periodend(request.getParameterValues("hca_periodend")[i]);
//			cr.setHca_position(request.getParameterValues("hca_position")[i]);
//			cr.setHca_code(hc_code);
//			if (i < cnt) {
//				cr.setHca_num(request.getParameterValues("hca_num")[i]);
//				hDao.updateCareer(cr);
//			}else {
//				hDao.registCareer(cr);
//			}
//		}
		System.out.println("Career");
	}

	public void registCertification(HttpServletRequest request, String id) {
		String hc_code = hDao.getHcCodeFromID(id);
		Integer cnt = hDao.selectCertification(hc_code);
		for (int i = 0; i < request.getParameterValues("hct_agency").length; i++) {
			Certification ctf = new Certification();
			ctf.setHct_code(hc_code);
			ctf.setHct_agency(request.getParameterValues("hct_agency")[i]);
			ctf.setHct_date(request.getParameterValues("hct_date")[i]);
			ctf.setHct_name(request.getParameterValues("hct_name")[i]);
			if (i < cnt) {
				ctf.setHct_num(request.getParameterValues("hct_num")[i]);
				hDao.updateCertification(ctf);
			}else {
				hDao.registCertification(ctf);
			}
		}
		System.out.println("Certification �엯�젰�셿猷�");
	}

	public void registHRCard(HR_Card hrCard, String id, String cCode) {
		System.out.println(id);
		hrCard.setHc_id(id);
		hrCard.setHc_cname(hDao.getCName(cCode));
		hrCard.setHc_cname("회사이름..두개?");
//		if (hDao.selectHRCard(id)) {
//			System.out.println("");
//			hDao.updateHRCard(hrCard);
//		} else {
//			hDao.registHRCard(hrCard);
//		}
	}

	public boolean haveHRCodeFromId(String m_id) {
//		boolean flag = hDao.haveHRCodeFromId(m_id);
		return true;//flag;
	}

	public Member getMemberInfo(String m_id) {
//		Member mb = hDao.getMemberInfo(m_id);
		return null; //mb;
	}

}
