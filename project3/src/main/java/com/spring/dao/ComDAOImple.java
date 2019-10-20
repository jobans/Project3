package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.ComVO;
import com.spring.vo.SearchVO;
@Repository
public class ComDAOImple implements ComDAO {

	@Inject
	private SqlSession ss;
	
	
	
	@Override
	public void approveCom(String bnum) {
		ss.update("approveCom", bnum);
		
	}
	
	@Override
	public void regCom(ComVO cvo) {
		ss.insert("regCom", cvo);
	}


	@Override
	public ComVO selectCom(String bnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectCom", bnum);
	}
	
	@Override
	public void comviewCnt(String bnum) {
		ss.update("comviewCnt", bnum);
		
	}


	@Override
	public void updateCom(ComVO cvo) {
		// TODO Auto-generated method stub
		ss.update("updateCom", cvo);
	}


	@Override
	public void deleteCom(String bnum) {
		// TODO Auto-generated method stub
		ss.delete("deleteCom", bnum);
	}

	@Override
	public List<ComVO> comList(String o_id) {
		
		return ss.selectList("comList", o_id);
			
	}


	@Override
	public List<ComVO> top6_List() {
		// TODO Auto-generated method stub
		return ss.selectList("top6_List");
	}

	@Override
	public List<ComVO> listFind(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectList("listFind", keyword);
	}

	@Override
	public int findCountData(SearchVO svo) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectOne("findCountData", svo);
	}

	
	


	
	
}
