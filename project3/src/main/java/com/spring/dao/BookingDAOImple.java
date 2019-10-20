package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.BookingVO;
import com.spring.vo.OwnerVO;

@Repository
public class BookingDAOImple implements BookingDAO {
	
	@Inject
	private SqlSession ss;

	@Override
	public void regBooking(BookingVO bvo) {
		ss.insert("regbookig", bvo);
		
	}

	@Override
	public BookingVO selectBooking(int b_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectBooking", b_no);
	}

	@Override
	public void updateBooking(BookingVO bvo) {
		// TODO Auto-generated method stub
		ss.update("updateBooking", bvo);
	}

	@Override
	public void deleteBooking(int b_no) {
		// TODO Auto-generated method stub
		ss.delete("deleteBooking", b_no);
	}

	@Override
	public List<BookingVO> BookingList(String bnum) {
		// TODO Auto-generated method stub
		return ss.selectList("BookingList", bnum);
	}

	@Override
	public List<BookingVO> Booking_uList(String u_id) {
		// TODO Auto-generated method stub
		return ss.selectList("Booking_uList", u_id);
	}

	@Override
	public OwnerVO bookingOwnerMail(String bnum) {
		return ss.selectOne("bookingOwnerMail",bnum);
	}

	

}
