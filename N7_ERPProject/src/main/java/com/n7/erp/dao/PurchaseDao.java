package com.n7.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.n7.erp.bean.IePort;
import com.n7.erp.bean.Purchase;

@Mapper
@Component
public interface PurchaseDao {

	@Update("UPDATE P SET P_SITUATION=1 WHERE P_NUM=#{ie_pnum} AND ")//수정해야함
	boolean updatePurchase(IePort iePort);
	

}
