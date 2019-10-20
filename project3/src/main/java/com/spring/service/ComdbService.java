package com.spring.service;

import com.spring.vo.ComdbVO;

public interface ComdbService {

	//모범 음식점 찾아서 등록 승인하기
	public ComdbVO searchCdb(String bnum);
}
