package com.n7.erp.bean.hr;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Alias("hrpay")
@Data
public class HR_PAY {
	private String HC_ID;
	private String HC_DEPT;
	private String HC_POSITION;
	private String HDP_PAY;
	private String HDD_AMOUNT;
	private String RESULT;
}
