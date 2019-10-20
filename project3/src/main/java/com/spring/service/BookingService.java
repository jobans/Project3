package com.spring.service;

import java.util.List;

import com.spring.vo.BookingVO;
import com.spring.vo.OwnerVO;

public interface BookingService {
	
	// 1. 예약 등록
		public void regbooking(BookingVO bvo);

	// 2. 예약 조회
		public BookingVO selectbooking(int b_no);

	// 3. 예약 수정
		public void updatebooking(BookingVO bvo);
		
	// 4. 예약 삭제
		public void deletebooking(int b_no);
		
	// 5. 예약 리스트
		public List<BookingVO> bookinglist(String bnum);
	
	// 6. 사용자별 예약 리스트
		public List<BookingVO> Booking_uList(String u_id);
	
	// 7.예약메일보내기
		public OwnerVO bookingOwnerMail(String bnum);
}
