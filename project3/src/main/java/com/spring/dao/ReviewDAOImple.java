package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReviewVO;
@Repository
public class ReviewDAOImple implements ReviewDAO{

	@Inject
	private SqlSession ss;
	
	@Override
	public void regReview(ReviewVO rvo) {
		// TODO Auto-generated method stub
		ss.insert("insertReview", rvo);
	}

	@Override
	public ReviewVO selectReview(int r_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectReview", r_no);
	}
	


	@Override
	public void updateReview(ReviewVO rvo) {
		// TODO Auto-generated method stub
		ss.update("updateReview", rvo);
	}

	@Override
	public void deleteReview(int r_no) {
		// TODO Auto-generated method stub
		ss.delete("deleteReview", r_no);
	}

	@Override
	public int countReview(String bnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("countReview", bnum);
	}

	// 업체별 리뷰리스트
	@Override
	public List<ReviewVO> ReviewList(String bnum) {
		// TODO Auto-generated method stub
		return ss.selectList("Reviewlist", bnum);
	}
	
	
	// 사용자별 리뷰 리스트
	@Override
	public List<ReviewVO> Review_uList(String u_id) {
		// TODO Auto-generated method stub
		return ss.selectList("ReviewUlist", u_id);
	}
	

	@Override
	public List<ReviewVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if(page<=0) {
			page=1;
		}
		
		page = (page-1)*10; // 한 페이지에 10개의 글 보이기
		
		return ss.selectList("listPage", page);
	}

	@Override
	public List<ReviewVO> listCriteria(PageCriteria page) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectList("listCriteria", page);
	}

	@Override
	public int countData(PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return ss.selectOne("countData", pCri);
	}

	@Override
	public void autoScore(String bnum) {
		ss.update("autoScore",bnum);
		
	}


	


}
