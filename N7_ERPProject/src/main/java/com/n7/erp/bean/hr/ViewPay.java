package com.n7.erp.bean.hr;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Alias("viewpay")
@Data
public class ViewPay {
	private String HC_ID;
	private String HC_DEPT;
	private String HC_POSITION;
	private int HDP_PAY;
	private String HDP_CCODED;
	private String HC_HRCODE;
	private String HDP_AUTH;
	private int HDD_AMOUNT;
	private String M_NAME;
}
