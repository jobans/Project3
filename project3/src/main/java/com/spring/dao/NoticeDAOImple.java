package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.NoticeVO;
import com.spring.vo.PageCriteria;
@Repository
public class NoticeDAOImple implements NoticeDAO {

	@Inject
	private SqlSession ss;
	
	
	@Override
	public void regNotice(NoticeVO nvo) {
		ss.insert("regNotice", nvo);
		
	}

	@Override
	public NoticeVO selectNotice(int n_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectNotice", n_no);
	}
	
	@Override
	public void noticeviewCnt(int n_no) {
		// TODO Auto-generated method stub
		ss.update("noticeviewCnt", n_no);
	}

	@Override
	public void updateNotice(NoticeVO nvo) {
		ss.update("updateNotice", nvo);
		
	}

	@Override
	public void deleteNotice(int n_no) {
		ss.delete("deleteNotice", n_no);
	}

	@Override
	public List<NoticeVO> NoticeList(String bnum) {
		// TODO Auto-generated method stub
		return ss.selectList("Noticelist", bnum);
	}
	
	@Override
	public List<NoticeVO> NoticeAllList() {
		// TODO Auto-generated method stub
		return ss.selectList("NoticeAlllist");
	}


	@Override
	public List<NoticeVO> listPage(int page) throws Exception {
		if(page<=0) {
			page=1;
		}
		
		page = (page-1)*10; // 한 페이지에 10개의 글 보이기
		
		return ss.selectList("listPage", page);
	}

	@Override
	public List<NoticeVO> listCriteria(PageCriteria page) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectList("listCriteria", page);
	}

	@Override
	public int countData(PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectOne("countData", pCri);
	}

	


}
