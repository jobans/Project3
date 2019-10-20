package com.spring.dao;

import java.util.List;

import com.spring.vo.ComVO;
import com.spring.vo.SearchVO;

public interface ComDAO {

	
// 0. 업체 등록 허용
	public void approveCom(String bnum);

			
// 1. 업체 등록
	public void regCom(ComVO cvo);

// 2. 업체 정보 조회
	public ComVO selectCom(String bnum);
	
	// 조회수
	public void comviewCnt(String bnum);

// 3. 업체 정보 수정
	public void updateCom(ComVO cvo);
	
// 4. 업체 삭제
	public void deleteCom(String bnum);
	
// 5. 사업자별 업체리스트
	public List<ComVO> comList(String o_id);
	
// 6. top6 리스트
	public List<ComVO> top6_List();
	
// 7. 검색 관련
	// 검색 리스트
	public List<ComVO> listFind(String keyword) throws Exception;
	
	// 검색자료 수
	public int findCountData(SearchVO svo) throws Exception;
		

	
}
