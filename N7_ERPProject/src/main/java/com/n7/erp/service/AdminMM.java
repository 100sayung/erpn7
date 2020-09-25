package com.n7.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n7.erp.bean.Company;
import com.n7.erp.bean.Member;
import com.n7.erp.dao.AdminDao;
import com.n7.erp.userClass.PagingVO;

@Service
public class AdminMM {

	@Autowired AdminDao aDao;
	

	//페이징 처리 멤버
	public int countMember() {
		return aDao.countMember();
	}
	
	public List<Member> selectMember(PagingVO vo){
		return aDao.selectMember(vo);
	}

	public int countCompany() {
		return aDao.countCompany();
	}

	public List<Company> selectCompany(PagingVO vo){
		return aDao.selectCompany(vo);
	}


}
