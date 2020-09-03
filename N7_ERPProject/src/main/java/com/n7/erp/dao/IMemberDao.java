package com.n7.erp.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.n7.erp.bean.Member;

public interface IMemberDao {
	boolean access(Member mb);
	boolean join(Member mb);
	//boolean fileInsert(Map<String, String> fMap);
	@Select("SELECT M_CCODE FROM MEMBER WHERE M_ID=#{m_id}")
	String bringCCode(Member mb);
	ArrayList<Member> getHRCard(String m_ccode);
}
