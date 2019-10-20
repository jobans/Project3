package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ComDAO;
import com.spring.dao.OwnerDAO;
import com.spring.dao.UserDAO;
import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;
@Service
public class CommonServiceImple implements CommonService {
	
	@Inject
	private UserDAO udao;
	
	@Inject
	private OwnerDAO odao;

	@Override
	public UserVO loginuser(String u_id, String u_pw, int grade) {
		// TODO Auto-generated method stub
		return udao.loginUser(u_id, u_pw, grade);
	}

	@Override
	public OwnerVO loginowner(String o_id, String o_pw) {
		// TODO Auto-generated method stub
		return odao.loginOwner(o_id, o_pw);
	}

}
