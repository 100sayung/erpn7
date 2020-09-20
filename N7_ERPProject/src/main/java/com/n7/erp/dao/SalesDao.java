package com.n7.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.n7.erp.bean.sales.A_company;
import com.n7.erp.bean.sales.Businessbean;
import com.n7.erp.bean.sales.Salesbean;
import com.n7.erp.bean.sales.Shippingbean;
import com.n7.erp.bean.sales.Uncollectedbean;
import com.n7.erp.bean.sales.approvaldetail;

@Mapper
@Component
public interface SalesDao {
	
	List<Salesbean> orderitem(); //수주품목

	boolean orderregistrationinput(Salesbean s); //수주등록

	List<Salesbean> orderregistrationsearch(@Param("search") String search, @Param("choice") String choice); //수주검색

	//boolean shippingdelete(String check); //출하삭제

	boolean orderregistrationdelete(String check); //수주삭제

	boolean shippingrequestinput(Shippingbean ss); //출하등록
	
	List<Shippingbean> shippingitem(); //출하품목
	
	List<Shippingbean> shippingrequestsearch(@Param("search") String search, @Param("choice") String choice); //출하검색
	
	boolean shippingrequestdelete(String check); //출하삭제

	boolean businessactivitiesinput(Businessbean b); //영업활동 등록

	List<Businessbean> businessitem();
	
	boolean insertcomlist(A_company ac);

	List<A_company> getComList(String c_code);

	List<A_company> getCompanyList();

	List<A_company> getsearchCode(A_company ac);

	boolean deleteCom(String code);

	List<Shippingbean> approvalplan(); //출하결재창

	Shippingbean approvalplanchoice(String check);
	
	List<com.n7.erp.bean.sales.approvalLine> approvalLine();

	List<com.n7.erp.bean.sales.approvalLine> searchName(String name);

	List<com.n7.erp.bean.sales.approvalLine> addApproval(String code01); //name

	com.n7.erp.bean.sales.approvalLine approLinecom1(String code01);

	//com.n7.erp.bean.sales.approvalLine approLinecom2(String code02);

	boolean approvalinput(approvaldetail app); //결재창 등록

	boolean approvalinput2(approvaldetail app); //결재창 등록2

	List<approvaldetail> creditsearch(); //외상

	List<approvaldetail> fullpaymentsearch(); //완납
	
	boolean uncollectedmoneyinput(approvaldetail ap); //미수금 등록
	
	List<approvaldetail> uncollectedmoneyitem(); //미수금 품목

	List<approvaldetail> uncollectedmoneyitem2(); //미수금품목2
	
	List<Uncollectedbean> uncollectedmoneysearch(@Param("search") String search, @Param("choice") String choice); //미수금 검색

	boolean fullpaymentprocess(String check); //완납처리

	List<Businessbean> businessactivitiessearch(@Param("search") String search, @Param("choice") String choice); //영업활동 검색

	boolean businessactivitiesdelete(String check);






}

