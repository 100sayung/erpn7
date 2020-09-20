package com.n7.erp.dao;

import org.apache.ibatis.annotations.Update;

import com.n7.erp.bean.IePort;


public interface PurchaseDao {

	@Update("UPDATE P SET P_SITUATION=1 WHERE P_NUM=#{ie_pnum} AND ")//수정해야함
	boolean updatePurchase(IePort iePort);

}
