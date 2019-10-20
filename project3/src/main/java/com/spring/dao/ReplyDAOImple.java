package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;
@Repository
public class ReplyDAOImple implements ReplyDAO{

	@Inject
	private SqlSession ss;
	
	
	@Override
	public List<ReplyVO> reList(Integer r_no) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectList("reList", r_no);
	}

	@Override
	public void write(ReplyVO r_rvo) throws Exception {
		// TODO Auto-generated method stub
		ss.insert("write", r_rvo);
	}

	@Override
	public void modify(ReplyVO r_rvo) throws Exception {
		// TODO Auto-generated method stub
		ss.update("modify", r_rvo);
	}

	@Override
	public void reDelete(Integer re_r_no) throws Exception {
		// TODO Auto-generated method stub
		ss.delete("reDelete", re_r_no);
	}

	@Override
	public List<ReplyVO> reListPage(Integer bid, PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reCount(Integer bid) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectOne("reCount", bid);
	}

	@Override
	public List<ReplyVO> reallList() throws Exception {
		return ss.selectList("reallList");
	}

}
