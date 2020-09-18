package com.n7.erp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.MultipartStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.n7.erp.bean.Member;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.dao.HRIDeptDao;
import com.n7.erp.dao.IHrDao;
import com.n7.erp.dao.IMemberDao;
import com.n7.erp.userClass.FileManager;

@Service
public class MemberMM {

	ModelAndView mav = new ModelAndView();
	@Autowired private IMemberDao mDao;
	@Autowired private IHrDao hDao;
	
	String view = "";

	   public ModelAndView access(Member mb, HttpSession session) {
		      System.out.println(mb.getM_id());
		      if (mDao.access(mb)) {
		         view = "/home/home";
		         session.setAttribute("id", mb.getM_id());
		         session.setAttribute("cCode", mDao.bringCCode(mb));
		         if (hDao.haveHrCode(mb.getM_id())) {
		            session.setAttribute("hrCode", hDao.getHrCodeFromID(mb.getM_id()));
		            System.out.println(hDao.getHrCodeFromID(mb.getM_id()));
		         }
		      } else {
		         view = "/home/login";
		         mav.addObject("warn", "Warning");
		      }
		      System.out.println(view);
		      mav.setViewName(view);
		      return mav;
		   }

	public ModelAndView join(MultipartHttpServletRequest multi) {
		Member mb = new Member();
		System.out.println("m_ccode = " + multi.getParameter("m_ccode"));
		if(multi.getParameter("m_ccode").toString().equals("")) {
			mb.setM_ccode("N7");
		}
		String id = multi.getParameter("m_id");
		String pw = multi.getParameter("m_pw");
		String address = multi.getParameter("m_address");
		String phonenum = multi.getParameter("m_phonenum");
		String birth = multi.getParameter("m_birth");
		String name = multi.getParameter("m_name");
		String email = multi.getParameter("m_email");
		mb.setM_address(address).setM_birth(birth).setM_email(email).setM_id(id).setM_name(name)
				.setM_phonenum(phonenum).setM_pw(pw);
		System.out.println(address);
		FileManager fm = new FileManager();
		String file = fm.fileUp(multi);
		System.out.println(file);
		mb.setM_photo(file);

		if (mDao.join(mb)) {
			mav.addObject("msg", 1);
		} else {
			mav.addObject("msg", 0);
		}
		mav.setViewName("/home/home");
		return mav;
	}

}