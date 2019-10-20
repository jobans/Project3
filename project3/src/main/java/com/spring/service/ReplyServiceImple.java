package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ReplyDAO;
import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;
@Service
public class ReplyServiceImple implements ReplyService {

	@Inject
	private ReplyDAO r_rdao;
	
	@Override
	public void inputReply(ReplyVO r_rvo) throws Exception {
		// TODO Auto-generated method stub
		r_rdao.write(r_rvo);
	}

	@Override
	public List<ReplyVO> replyList(Integer r_no) throws Exception {
		// TODO Auto-generated method stub
		return r_rdao.reList(r_no);
	}

	@Override
	public void modifyReply(ReplyVO r_rvo) throws Exception {
		// TODO Auto-generated method stub
		r_rdao.modify(r_rvo);
	}

	@Override
	public void delRepley(Integer re_r_no) throws Exception {
		// TODO Auto-generated method stub
		r_rdao.reDelete(re_r_no);
	}

	@Override
	public List<ReplyVO> reListPage(Integer bid, PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reCount(Integer bid) throws Exception {
		// TODO Auto-generated method stub
		return r_rdao.reCount(bid);
	}

	@Override
	public List<ReplyVO> reallList() throws Exception {
		// TODO Auto-generated method stub
		return r_rdao.reallList();
	}

}
