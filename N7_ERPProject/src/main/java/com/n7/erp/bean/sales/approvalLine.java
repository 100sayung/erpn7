package com.n7.erp.bean.sales;


import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("Linee")
@Data
@Accessors(chain=true)
public class approvalLine {
	private String m_name;
	private String m_email;
	private String hc_hrcode;
	private String hc_dept;
	private String hc_position;
}