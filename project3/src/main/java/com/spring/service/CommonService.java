package com.spring.service;

import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;

public interface CommonService {
	
	public UserVO loginuser(String u_id, String u_pw, int grade);

	public OwnerVO loginowner(String o_id, String o_pw);

}
