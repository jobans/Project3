package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ReviewDAO;
import com.spring.vo.PageCriteria;
import com.spring.vo.ReviewVO;
@Service
public class ReviewServiceImple implements ReviewService {

	@Inject
	private ReviewDAO rdao;
	
	@Override
	public void regreview(ReviewVO rvo) {
		// TODO Auto-generated method stub
		rdao.regReview(rvo);
	}

	@Override
	public ReviewVO selectreview(int r_no) {
		// TODO Auto-generated method stub
		return rdao.selectReview(r_no);
	}


	@Override
	public void updatereview(ReviewVO rvo) {
		// TODO Auto-generated method stub
		rdao.updateReview(rvo);
	}

	@Override
	public void deletereview(int r_no) {
		// TODO Auto-generated method stub
		rdao.deleteReview(r_no);
	}

	@Override
	public int countreview(String bnum) {
		// TODO Auto-generated method stub
		return rdao.countReview(bnum);
	}

	@Override
	public List<ReviewVO> Reviewlist(String bnum) {
		// TODO Auto-generated method stub
		return rdao.ReviewList(bnum);
	}

	@Override
	public List<ReviewVO> listpage(int page) throws Exception {
		// TODO Auto-generated method stub
		return rdao.listPage(page);
	}

	@Override
	public List<ReviewVO> listcriteria(PageCriteria page) throws Exception {
		// TODO Auto-generated method stub
		return rdao.listCriteria(page);
	}

	@Override
	public int countdata(PageCriteria pCri) throws Exception {
		// TODO Auto-generated method stub
		return rdao.countData(pCri);
	}

	@Override
	public List<ReviewVO> Review_Ulist(String u_id) {
		// TODO Auto-generated method stub
		return rdao.Review_uList(u_id);
	}

	@Override
	public void autoScore(String bnum) {
		rdao.autoScore(bnum);
		
	}

	
}
