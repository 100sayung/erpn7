package com.n7.erp.bean.ps;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Alias("pApproval")
public class PurchaseApproval {
	private String p_documentcode;
	private String p_ccode;
	private String p_title;
	private String p_productnum;
	private String p_date;
	private String p_pday;
	private String p_clcode;
	private int p_budget;
	private String p_ect;
	private String p_itcode;
	private int p_amount;
	private int p_unlit;
	private String p_name;
	private String p_approvel0;
	private String p_approvel1;
	private String p_approvel2;
}

