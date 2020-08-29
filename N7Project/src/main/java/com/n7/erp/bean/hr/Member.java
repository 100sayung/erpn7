package com.n7.erp.bean.hr;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("member")
@Data
@Accessors(chain = true)
public class Member {
	private String m_id;
	private String m_pw;
	private String m_address;
	private String m_phonenum;
	private String m_photo;
	private String m_gender;
	private String m_birth;
	private String m_name;
	private String m_ccode;
}
