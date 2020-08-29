package com.n7.erp.bean.hr;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("academic")
@Data
@Accessors(chain = true)
public class Academic {
	String hac_code;
	String hac_num;
	String hac_school;
	String hac_major;
	String hac_year;

	private List<Academic> aclist;
}
