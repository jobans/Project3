package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ComDAO;
import com.spring.vo.ComVO;
import com.spring.vo.SearchVO;
import com.spring.vo.UserVO;
@Service
public class ComServiceImple implements ComService {

	@Inject
	private ComDAO cdao;
	
	
	//업체등록 승인
	@Override
	public void admissionCom(String bnum) {
		cdao.approveCom(bnum);
		
	}
	

	// 업체 등록
	@Override
	public void insertCom(ComVO cvo) {
		cdao.regCom(cvo);
	}

	// 업체 정보 보기
	@Override
	public ComVO readCom(String bnum) {
	
		return cdao.selectCom(bnum);
	}
	
	// 조회수
	@Override
	public void comviewcnt(String bnum) {
		cdao.comviewCnt(bnum);
		
	}
	
	// 업체 수정
	@Override
	public void modifyCom(ComVO cvo) {
		cdao.updateCom(cvo);

	}

	// 업체 삭제
	@Override
	public void removeCom(String bnum) {
		cdao.deleteCom(bnum);

	}

	// 사업자별 업체 리스트
	@Override
	public List<ComVO> comlist(String o_id) {
		// TODO Auto-generated method stub
		return cdao.comList(o_id);
	}


	@Override
	public List<ComVO> top6_list() {
		// TODO Auto-generated method stub
		return cdao.top6_List();
	}

	// 검색
	@Override
	public List<ComVO> listFind(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return cdao.listFind(keyword);
	}
/*
	@Override
	public int findCountData(SearchVO svo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
*/


	


	
	
}
