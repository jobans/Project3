package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ComdbDAO;
import com.spring.vo.ComdbVO;
@Service
public class ComdbServiceImple implements ComdbService {

	@Inject
	private ComdbDAO cdbdao;
	
	
	@Override
	public ComdbVO searchCdb(String bnum) {
		// TODO Auto-generated method stub
		return cdbdao.searchCdb(bnum);
	}

}
