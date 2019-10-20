package com.spring.service;

import java.util.List;

import com.spring.vo.ComVO;
import com.spring.vo.SearchVO;

public interface ComService {

	// 0. 업체 등록 승인
		public void admissionCom(String bnum);
	
	// 1. 업체 등록
		public void insertCom(ComVO cvo);
		
	// 2. 업체 정보 조회
		public ComVO readCom(String bnum);
		
		// 조회수
		public void comviewcnt(String bnum);
			
		
		
	// 3. 업체 정보 수정
		public void modifyCom(ComVO cvo);
		
	// 4. 업체 삭제
		public void removeCom(String bnum);
		
	// 5. 사업자별 업체 리스트
		public List<ComVO> comlist(String o_id);
		
	// 6. top6 리스트
		public List<ComVO> top6_list();
	
	// 7. 검색
		public List<ComVO> listFind(String keyword) throws Exception;
		
		
		//public int findCountData(SearchVO svo) throws Exception;
		
	
}
