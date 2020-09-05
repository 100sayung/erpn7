package com.n7.erp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.n7.erp.bean.ConsultingBoard;
import com.n7.erp.bean.entity.NameHrCode;
import com.n7.erp.bean.hr.Deduct;
import com.n7.erp.bean.hr.Department;


public interface HRIDeptDao {
	
	@Insert("INSERT INTO HR_DEPT VALUES(#{HDP_position},#{HDP_dept},#{hdp_ccode}, 0, HR_DEPT_SEQ.nextval)")
	boolean deptregistinsert(Department dept);

	@Select("SELECT * FROM HR_DEPT WHERE HDP_CCODE = #{cCode}")
	ArrayList<Department> deptpayselect(String cCode);

	@Update("UPDATE HR_DEPT SET HDP_PAY=#{pay} WHERE HDP_NUM=#{dept} AND HDP_CCODE = #{cCode}")
	boolean deptpayupdate(HashMap<String, String> hMap);
	
	String payselect(HashMap<String, String> hMap);
	
	@Delete("DELETE FROM HR_DEPT WHERE HDP_NUM=#{deptnum} AND HDP_CCODE = #{cCode}")
	boolean deptdelete(HashMap<String, String> delMap);
	
	@Select("SELECT * FROM HR_DEPT WHERE HDP_CCODE = #{cCode}")
	ArrayList<Department> deptafterselect(String cCode);

	ArrayList<Department> searchpay(String cCode);
	
	@Select("SELECT * FROM HR_DEDUCTION WHERE HDD_CCODE = #{cCode}")
	ArrayList<Deduct> moveDeduct(String cCode);
	
	@Update("UPDATE HR_DEDUCTION SET HDD_AMOUNT=#{denum} WHERE HDD_NAME=#{deduct} AND HDD_CCODE = #{cCode}")
	boolean modifyDeduction(HashMap<String, String> duMap);

	String findDeduction(HashMap<String, String> duMap);

	@Select("SELECT DISTINCT HDP_POSITION FROM HR_DEPT WHERE HDP_CCODE = #{cCode}")
	ArrayList<Department> distinctposition(String cCode);
	@Select("SELECT DISTINCT HDP_DEPT FROM HR_DEPT WHERE HDP_CCODE = #{cCode}")
	ArrayList<Department> distinctdept(String cCode);
	
	@Select("SELECT * FROM HR_DEPT WHERE HDP_DEPT=#{disdept} AND HDP_POSITION=#{disposition} AND HDP_CCODE = #{cCode}")
	ArrayList<Department> findDeptPosition(HashMap<String, String> fdpMap);
	@Select("SELECT * FROM HR_DEPT WHERE HDP_DEPT=#{disdept} AND HDP_CCODE = #{cCode}")
	ArrayList<Department> findDisdept(HashMap<String, String> fdpMap);
	@Select("SELECT * FROM HR_DEPT WHERE HDP_POSITION=#{disposition} AND HDP_CCODE = #{cCode}")
	ArrayList<Department> findDisposition(HashMap<String, String> fdpMap);


	ArrayList<NameHrCode> getMyLeaderUsingGradeDept(HashMap<String, String> hMap);
	
}
