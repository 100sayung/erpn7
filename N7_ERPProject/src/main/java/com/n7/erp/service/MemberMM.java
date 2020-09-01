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

import com.n7.erp.bean.hr.Member;
import com.n7.erp.dao.IMemberDao;
import com.n7.erp.userClass.FileManager;

@Service
public class MemberMM {

	ModelAndView mav = new ModelAndView();
	@Autowired private IMemberDao mDao;
	
	String view = "";

	public ModelAndView access(Member mb, HttpSession session) {
//		System.out.println(mb.getM_id());
//		if (mDao.access(mb)) {
//			view = "/home/home";
//			session.setAttribute("id", mb.getM_id());
//			session.setAttribute("cCode", mDao.bringCCode(mb));
//		} else {
//			view = "/home/login";
//			mav.addObject("warn", "Warning");
//		}
		view="/home/login";
//		System.out.println(view);
//		mav.setViewName(view);
		return mav;
	}

	public ModelAndView join(MultipartHttpServletRequest multi) {
		Member mb = new Member();

		String id = multi.getParameter("m_id");
		String pw = multi.getParameter("m_pw");
		String address = multi.getParameter("m_address");
		String phonenum = multi.getParameter("m_phonenum");
		String gender = multi.getParameter("m_gender");
		String ccode = multi.getParameter("m_ccode");
		String birth = multi.getParameter("m_birth");
		String name = multi.getParameter("m_name");

		mb.setM_address(address).setM_birth(birth).setM_ccode(ccode).setM_gender(gender).setM_id(id).setM_name(name)
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

	public ModelAndView hrCard(HttpSession session) {
		String m_id = session.getAttribute("id").toString();
		String m_ccode = session.getAttribute("cCode").toString();

		System.out.println(m_ccode);

//		ArrayList<Member> hrCardList = new ArrayList<>();
//		hrCardList = mDao.getHRCard(m_ccode);
//		System.out.println(hrCardList.get(0).getM_birth());

//		mav.addObject("hrCard", makeHRCardList(hrCardList));
		mav.setViewName("forward:/hr/hrCard");
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
			str.append("<td>" + hList.get(i).getM_gender() + "</td><td>");
			str.append("<input type='button' value='' onclick='modifyDetail(\""+hList.get(i).getM_id()+"\")'></td></tr>");
		}
		str.append("</table>");
		return str.toString();
	}

}