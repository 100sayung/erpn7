package com.n7.erp.bean.hr;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("payroll")
@Accessors(chain = true)
@Data
public class Payroll {
	private String HP_CODE;
	private Date HP_PAYDATE;
	private String HP_TAX;
	private String HP_INCEN;
	private String HP_INSURANCI;
	private String HP_REALMONEY;
	private String hp_ccode;
}
