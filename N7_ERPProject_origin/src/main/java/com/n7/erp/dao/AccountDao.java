package com.n7.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.n7.erp.bean.ac.A_company;
import com.n7.erp.bean.ac.ApprovalDocument;
import com.n7.erp.bean.ApprovalDocu;
import com.n7.erp.bean.ac.SaleInfo;
import com.n7.erp.bean.ac.approvalLine;
import com.n7.erp.bean.ac.myCompany;

@Mapper
@Component
public interface AccountDao {

	boolean insertcomlist(A_company ac);

	List<A_company> getComList(String c_code);

	List<A_company> getCompanyList();

	List<A_company> getsearchCode(A_company ac);

	boolean deleteCom(String code);

	boolean saleinsert(SaleInfo si);
	
	boolean saleinsert2(SaleInfo si);

	List<SaleInfo> getsaleList();

	List<SaleInfo> getList(String code);

	List<SaleInfo> getTaxbill(String check);

	A_company getcomInfo(String company);

	myCompany getmyCompany();

	boolean deleteSale(String code);

	List<approvalLine> approvalLine();

	List<approvalLine> searchName(String name);

	com.n7.erp.bean.ac.approvalLine addApproval(String code);
	
	com.n7.erp.bean.ac.approvalLine approLinecom1(String code01);

	/*
	 * com.n7.erp.bean.ac.approvalLine approLinecom2(String code02);
	 */
	void saleListDelete(ApprovalDocument ad);

	List<SaleInfo> getpkind(String pkind);

	List<SaleInfo> getsaleList2();

	List<SaleInfo> saleDetaile(String check);

	List<SaleInfo> saleDetaile2(String check);

	boolean deleteSale2(String code);

	List<SaleInfo> selectSreach(@Param("select") String select,@Param("choice") String choice);

	boolean approvaldocu(ApprovalDocument ad);

	boolean approdocument(ApprovalDocument ad);

	boolean approdocument2(ApprovalDocument ad);

	A_company getcomcode(String s_comnum);

	List<ApprovalDocu> comparecode(String code);

	List<com.n7.erp.bean.ac.approvalLine> getMyInfo(String code);


//	List<SaleInfo> saledetails(String check);

	/* List<SaleInfo> selectsale(String search); */

}
