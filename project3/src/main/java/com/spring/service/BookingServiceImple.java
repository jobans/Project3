package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.BookingDAO;
import com.spring.vo.BookingVO;
import com.spring.vo.OwnerVO;
@Service
public class BookingServiceImple implements BookingService {

	@Inject
	BookingDAO bdao;
	
	@Override
	public void regbooking(BookingVO bvo) {
		bdao.regBooking(bvo);
		
	}

	@Override
	public BookingVO selectbooking(int b_no) {
		// TODO Auto-generated method stub
		return bdao.selectBooking(b_no);
	}

	@Override
	public void updatebooking(BookingVO bvo) {
		// TODO Auto-generated method stub
		bdao.updateBooking(bvo);
	}

	@Override
	public void deletebooking(int b_no) {
		// TODO Auto-generated method stub
		bdao.deleteBooking(b_no);
	}

	@Override
	public List<BookingVO> bookinglist(String bnum) {
		// TODO Auto-generated method stub
		return bdao.BookingList(bnum);
	}

	@Override
	public List<BookingVO> Booking_uList(String u_id) {
		// TODO Auto-generated method stub
		return bdao.Booking_uList(u_id);
	}

	@Override
	public OwnerVO bookingOwnerMail(String bnum) {
		
		return bdao.bookingOwnerMail(bnum);
	}

}
