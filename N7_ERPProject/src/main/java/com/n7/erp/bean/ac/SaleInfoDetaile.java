package com.n7.erp.bean.ac;


import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("saleInfo2")
@Data
@Accessors(chain=true)
public class SaleInfoDetaile {
	private String s_num;
	
}
