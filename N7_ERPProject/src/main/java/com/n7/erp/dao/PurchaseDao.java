package com.n7.erp.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.n7.erp.bean.ps.approvalLine;
import com.n7.erp.bean.IePort;
import com.n7.erp.bean.ps.Purchase;
import com.n7.erp.bean.ps.PurchaseApproval;
import com.n7.erp.bean.ps.Return;

@Mapper
@Component
public interface PurchaseDao {

	@Update("UPDATE P SET P_SITUATION=1 WHERE P_NUM=#{ie_pnum} AND ")//수정해야함
	boolean updatePurchase(IePort iePort);
	
	boolean pregistration(Purchase ps);

	boolean pcommom(Purchase ps);

	List<Purchase> pFrerence(@Param("cCode") String cCode);

	List<Purchase> pfSearch(@Param("search") String search, @Param("choice") String choice, @Param("cCode") String cCode);

	boolean pfDelete(@Param("check_list") String check_list, @Param("cCode") String cCode);

	boolean pcDelete(@Param("check_list") String check_list, @Param("cCode") String cCode);

	List<Purchase> pDetail(@Param("check")String check, @Param("cCode") String cCode);

	Purchase pInfo(@Param("check")String check, @Param("cCode") String cCode);

	Purchase pBring(@Param("check")String check, @Param("cCode") String cCode);

	List<Purchase> pProgram(@Param("check")String check, @Param("cCode") String cCode);

	List<approvalLine> approvalLine();

	List<approvalLine> searchName(String name);

    List<com.n7.erp.bean.ps.approvalLine> addApproval(String code01); //name

    com.n7.erp.bean.ps.approvalLine approLinecom1(String code01);

    List<com.n7.erp.bean.ps.approvalLine> getMyInfo(String code);

    boolean Approval(PurchaseApproval pa);

	boolean pApproval1(PurchaseApproval pa);

	boolean pApproval2(PurchaseApproval pa);

	boolean rRegistration(Return rt);

	List<Return> rInfo(@Param("cCode") String cCode);

	boolean rDelete(@Param("check_list")String check_list, @Param("cCode") String cCode);

	List<Return> rSearch(@Param("search") String search, @Param("choice") String choice, @Param("cCode") String cCode);


}
