package com.spring.demo;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.MemberDAO;
import com.spring.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class) // main 이 없어도 메인처럼 동작시키게 하는데 동작시키게 하는 것
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	@Inject
	private MemberDAO memberDAO;
	
	@Test
	public void testTime() {
		System.out.println(memberDAO.getTime());
	}
	
//	@Test
//	public void testInsertMember() {
//		MemberVO vo = new MemberVO();
//		vo.setUid("스레기");
//		vo.setPwd("1234");
//		vo.setUsername("조반석");
//		vo.setEmail("오철민@trash.com");
//		
//		memberDAO.insertMember(vo);
//	}
	

}
