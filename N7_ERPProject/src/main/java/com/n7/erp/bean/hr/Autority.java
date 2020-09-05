package com.n7.erp.bean.hr;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("autority")
@Accessors(chain = true)
@Data
public class Autority {
	String hat_hrcode;
	String hat_ccode;
	String hat_auth;
}
