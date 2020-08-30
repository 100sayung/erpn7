package com.n7.erp.bean.hr;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Alias("")
@Data
public class Academic {
	String code;
	String hac_code;
	String hac_num;
	String hac_school;
	String hac_major;
	String hac_year;

}
