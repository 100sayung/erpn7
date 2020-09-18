package com.n7.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.n7.erp.bean.IePort;
import com.n7.erp.bean.Purchase;
import com.n7.erp.bean.approvalLine;
import com.n7.erp.bean.ps.PurchaseApproval;
import com.n7.erp.bean.ps.Purchasebean;
import com.n7.erp.bean.ps.Return;

@Mapper
@Component
public interface PurchaseDao {

	@Update("UPDATE P SET P_SITUATION=1 WHERE P_NUM=#{ie_pnum} AND ")//수정해야함
	boolean updatePurchase(IePort iePort);

	boolean pregistration(Purchasebean ps);

	boolean pcommom(Purchasebean ps);

	List<Purchasebean> pFrerence();

	List<Purchasebean> pfSearch(@Param("search") String search, @Param("choice") String choice);

	boolean pfDelete(String check_list);

	boolean pcDelete(String check_list);

	List<Purchasebean> pDetail(String check);

	Purchasebean pInfo(String check);

	Purchasebean pBring(String check);

	List<Purchasebean> pProgram(String check);

	com.n7.erp.bean.approvalLine approLinecom1(String code01);

	com.n7.erp.bean.approvalLine approLinecom2(String code02);

	List<approvalLine> approvalLine();

	List<approvalLine> searchName(String name);

	List<approvalLine> addApproval(String name);

	boolean Approval(PurchaseApproval pa);

	boolean pApproval1(PurchaseApproval pa);

	boolean pApproval2(PurchaseApproval pa);

	boolean rRegistration(Return rt);

	List<Return> rInfo();

	boolean rDelete(String check_list);

	List<Return> rSearch(@Param("search") String search, @Param("choice") String choice);


}
