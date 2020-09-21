package com.n7.erp.bean.ps;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Alias("purchase")
@Accessors(chain = true)
public class Purchase {
	private String p_documentcode; 
	private String p_productnum;
	private String p_ccode; 
	private String p_day; 
	private String p_clcode; 
	private String p_writer; 
	private String p_itcode; 
	private String p_name; 
	private int p_unlit; 
	private int p_amount; 
	private int p_budget; 
	
	
}
