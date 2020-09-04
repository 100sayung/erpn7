package com.n7.erp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.n7.erp.bean.Member;
import com.n7.erp.bean.hr.Academic;
import com.n7.erp.bean.hr.Career;
import com.n7.erp.bean.hr.Certification;
import com.n7.erp.bean.hr.HR_Card;

public interface IHrDao {
	@Select("SELECT * FROM HR_CARD WHERE HC_ID = #{m_id}")
	HR_Card getHrCardDetail(String id);
	
	@Select("SELECT HC_HRCODE FROM HR_CARD WHERE HC_ID = #{m_id}")
	String getHrCodeFromID(String id);
	
	@Select("SELECT * FROM HR_${type} WHERE ${column}_HRCODE = #{code} AND ${column}_CCODE = #{cCode}")
	List<Certification> getCertificationInfo(HashMap<String, String> hMap);
	@Select("SELECT * FROM HR_${type} WHERE ${column}_HRCODE = #{code} AND ${column}_CCODE = #{cCode}")
	List<Academic> getAcademicInfo(HashMap<String, String> hMap);
	@Select("SELECT * FROM HR_${type} WHERE ${column}_HRCODE = #{code} AND ${column}_CCODE = #{cCode}")
	List<Career> getCareerInfo(HashMap<String, String> hMap);


	//HC_CODE 대신에 해보는중

	@Select("SELECT C_NAME FROM COMPANY WHERE C_CODE = #{cCode}")
	String getCName(String cCode);

	
	@Select("SELECT COUNT(*) FROM HR_ACADEMIC WHERE Hac_HRCODE = #{hrcode} AND HAC_CCODE = #{cCode}")
	Integer selectAcademic(HashMap<String, String> acMap);
	@Select("SELECT COUNT(*) FROM HR_CARD WHERE HC_ID = #{hc_id}")
	boolean selectHRCard(String hc_id);
	@Select("SELECT COUNT(*) FROM HR_CAREER WHERE Hcr_HRCODE = #{hrcode} AND HCR_CCODE = #{cCode}")
	Integer selectCareer(HashMap<String, String> crMap);
	@Select("SELECT COUNT(*) FROM HR_CERTIFICATION WHERE Hct_HRCODE = #{hct_hrcode} AND HCT_CCODE = #{hct_ccode}")
	Integer selectCertification(HashMap<String, String> ctfMap);

	@Insert("INSERT INTO HR_CARD VALUES(#{hc_hrcode}||HR_CARD_SEQ.NEXTVAL, #{hc_ccode}, #{hc_id}, #{hc_dept}, #{hc_position}, #{hc_joindate}, DEFAULT, DEFAULT, DEFAULT)")
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

	@Insert("INSERT INTO HR_ATTENDANCE VALUES(#{cCode}, #{hrCode}, DEFAULT, #{type})")
	boolean logAttendance(HashMap<String, String> logAtMap);
	@Insert("UPDATE HR_CARD SET HC_STATUS = #{type} WHERE HC_CCODE = #{cCode} AND HC_HRCODE = #{hrCode}")
	void logStatusToHrCard(HashMap<String, String> logAtMap);
	
}
