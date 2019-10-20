package com.spring.dao;

import java.util.List;

import com.spring.vo.BookingVO;
import com.spring.vo.OwnerVO;

public interface BookingDAO {

	
	// 1. 예약 등록
		public void regBooking(BookingVO bvo);

	// 2. 예약 조회
		public BookingVO selectBooking(int b_no);

	// 3. 예약 수정
		public void updateBooking(BookingVO bvo);
		
	// 4. 예약 삭제
		public void deleteBooking(int b_no);
		
	// 5. 업체별 예약 리스트
		public List<BookingVO> BookingList(String bnum);
		
	// 6. 사용자별 예약 리스트
		public List<BookingVO> Booking_uList(String u_id);
	
	// 7. 예약메일 보내기
		public OwnerVO bookingOwnerMail(String bnum);
}
