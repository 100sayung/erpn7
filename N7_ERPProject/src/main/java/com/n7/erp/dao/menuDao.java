package com.n7.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.n7.erp.bean.Company;
import com.n7.erp.bean.Menu;
import com.n7.erp.bean.clientMenu;

@Mapper
@Component
public interface menuDao {

	List<Menu> getmenu();

	boolean addmenu(@Param("menu")String menu, @Param("cCode")String cCode);

	List<clientMenu> getaddmenu(String cCode);

	void deletemenu(String cCode);

	List<Company> getCompanyInfo(String cCode);

	boolean companyUpdate(Company cp);

	
	//내정보메뉴출력용 
	@Select("SELECT COUNT(*) FROM ERP_FUNCTION WHERE F_CCODE = #{cCode} AND F_FUNCTIONS = '인사관리'")
	boolean hasHrMenu(String string);

}
