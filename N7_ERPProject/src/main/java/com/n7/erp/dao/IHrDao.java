package com.n7.erp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;
import com.n7.erp.bean.hr.Member;

public interface IHrDao {
	@Select("SELECT * FROM HR_CARD WHERE HC_ID = #{m_id}")
	HR_Card getHrCard(String id);
	
	@Select("SELECT HC_CODE FROM HR_CARD WHERE HC_ID = #{m_id}")
	String getHcCodeFromID(String id);
	
	@Select("SELECT * FROM HR_${type} WHERE ${column}_CODE = #{code}")
	List<Certification> getCertificationInfo(HashMap<String, String> hMap);
	@Select("SELECT * FROM HR_${type} WHERE ${column}_CODE = #{code}")
	List<Academic> getAcademicInfo(HashMap<String, String> hMap);
	@Select("SELECT * FROM HR_${type} WHERE ${column}_CODE = #{code}")
	List<Career> getCareerInfo(HashMap<String, String> hMap);


	//HC_CODE 대신에 해보는중

	@Select("SELECT C_NAME FROM COMPANY WHERE C_CODE = #{cCode}")
	String getCName(String cCode);

	
	@Select("SELECT COUNT(*) FROM HR_ACADEMIC WHERE Hac_CODE = #{hc_code}")
	Integer selectAcademic(String hc_code);
	@Select("SELECT COUNT(*) FROM HR_CARD WHERE HC_ID = #{hc_id}")
	boolean selectHRCard(String hc_id);
	@Select("SELECT COUNT(*) FROM HR_CAREER WHERE Hca_CODE = #{hc_code}")
	Integer selectCareer(String hc_code);
	@Select("SELECT COUNT(*) FROM HR_CERTIFICATION WHERE Hct_CODE = #{hc_code}")
	Integer selectCertification(String hc_code);

	@Insert("INSERT INTO HR_CARD VALUES(#{hc_id}, #{hc_joindate}||HC_CODE_SEQ.NEXTVAL, #{hc_joindate}, #{hc_cname}, #{hc_dept}, #{hc_position}, DEFAULT, DEFAULT, DEFAULT)")
	void registHRCard(HR_Card hrCard);
	void registAcademic(Academic ac);
	void registCareer(Career cr);
	void registCertification(Certification ctf);
	
	void updateAcademic(Academic ac);
	void updateCareer(Career cr);
	void updateCertification(Certification ctf);
	void updateHRCard(HR_Card hrCard);

	@Select("SELECT COUNT(*) FROM HR_CARD WHERE HC_ID = #{m_id}")
	boolean haveHRCodeFromId(String m_id);

	@Select("SELECT * FROM MEMBER WHERE M_ID = #{m_id}")
	Member getMemberInfo(String m_id);
	
}
