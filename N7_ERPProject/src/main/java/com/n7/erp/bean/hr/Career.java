package com.n7.erp.bean.hr;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("career")
@Data
@Accessors(chain = true)
public class Career {
	String hca_num;
	String hca_cname;
	String hca_period;
	String hca_periodend; //끝난 날
	String hca_content;
	String hca_position;
	String hca_code;
	
	private List<Career> caList;
}
