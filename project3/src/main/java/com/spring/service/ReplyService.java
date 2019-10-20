package com.spring.service;

import java.util.List;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;

public interface ReplyService {
	public void inputReply(ReplyVO r_rvo) throws Exception;
	public List<ReplyVO> replyList(Integer r_no) throws Exception;
	public void modifyReply(ReplyVO r_rvo) throws Exception;
	public void delRepley(Integer re_r_no) throws Exception;
	public List<ReplyVO> reallList() throws Exception;
	public List<ReplyVO> reListPage(Integer bid, PageCriteria pCri) throws Exception;
	public int reCount(Integer bid) throws Exception;
}
