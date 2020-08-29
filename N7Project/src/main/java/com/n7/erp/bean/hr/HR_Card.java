package com.n7.erp.bean.hr;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("hr_card")
@Data
public class HR_Card {
	private String hc_id;
	private String hc_code;
	private String hc_joindate;
	private String hc_cname;
	private String hc_dept;
	private String hc_position;
	private String hc_married;
	private String hc_work;
	private String hc_status;
	private String hc_numholi;
}
