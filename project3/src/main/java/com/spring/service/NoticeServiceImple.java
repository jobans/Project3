package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.NoticeDAO;
import com.spring.vo.NoticeVO;
import com.spring.vo.PageCriteria;
@Service
public class NoticeServiceImple implements NoticeService{

	@Inject
	private NoticeDAO ndao;
	
	@Override
	public void regnotice(NoticeVO nvo) {
		ndao.regNotice(nvo);
		
	}

	@Override
	public NoticeVO selectnotice(int n_no) {
		// TODO Auto-generated method stub
		return ndao.selectNotice(n_no);
	}
	
	// 조회수
	@Override
	public void noticeviewcnt(int n_no) {
		// TODO Auto-generated method stub
		ndao.noticeviewCnt(n_no);
	}


	@Override
	public void updatenotice(NoticeVO nvo) {
		ndao.updateNotice(nvo);
		
	}

	@Override
	public void deletenotice(int n_no) {
		// TODO Auto-generated method stub
		ndao.deleteNotice(n_no);
	}

	@Override
	public List<NoticeVO> Noticelist(String bnum) {
		// TODO Auto-generated method stub
		return ndao.NoticeList(bnum);
	}
	

	@Override
	public List<NoticeVO> NoticeAlllist() {
		// TODO Auto-generated method stub
		return ndao.NoticeAllList();
	}

	@Override
	public List<NoticeVO> listpage(int page) throws Exception {
		// TODO Auto-generated method stub
		return ndao.listPage(page);
	}

	@Override
	public List<NoticeVO> listcriteria(PageCriteria page) throws Exception {
		// TODO Auto-generated method stub
		return ndao.listCriteria(page);
	}

	@Override
	public int countdata(PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return ndao.countData(pCri);
	}


}
