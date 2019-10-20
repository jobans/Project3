package com.spring.dao;

import java.util.List;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> reList(Integer r_no) throws Exception;
	public List<ReplyVO> reallList() throws Exception;
	public void write (ReplyVO r_rvo) throws Exception;
	public void modify (ReplyVO r_rvo) throws Exception;
	public void reDelete (Integer re_r_no) throws Exception;
	
	public List<ReplyVO> reListPage(Integer bid, PageCriteria pCri) throws Exception;
	public int reCount(Integer bid) throws Exception;
}
