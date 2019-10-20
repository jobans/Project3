package com.spring.demo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.dao.BbsDAO;
import com.spring.vo.BbsVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BbsDAOTest {

	@Inject
	private BbsDAO bdao;
	
	private static Logger logger = LoggerFactory.getLogger(BbsDAOTest.class); // 로그기록하기 위함
	
//	@Test //org.junit
//	public void insertTest() throws Exception{
//		BbsVO bvo = new BbsVO();
//		bvo.setSubject("조반석");
//		bvo.setContents("trash");
//		bvo.setWriter("오철민");
//		
//		bdao.insert(bvo);
//	} // insert end

//	@Test
//	public void selectOneTest() throws Exception {
//		logger.info(bdao.read(2).toString()); // 좀더 자세히 볼수 있음 
//	}
	
//	@Test
//	public void selectAllTest() throws Exception {
//		//bdao.list();
//		logger.info(bdao.list().toString());
//	}
	
//	@Test
//	public void updateOneTest() throws Exception{
//		BbsVO bvo1 = new BbsVO();
//		bvo1.setContents("trash반석");
//		bvo1.setSubject("오철민say");
//		bvo1.setBid(1);
//		bdao.update(bvo1);
//	}
	
//	@Test
//	public void deleteOneTest() throws Exception{
//		bdao.delte(2);
//	}
//	
//	@Test
//	public void listPageTest() throws Exception {
//		int page = 10;
//		List<BbsVO> list = bdao.listPage(page);
//		
//		for(BbsVO bvo : list) {
//			logger.info(bvo.getBid() + " : " + bvo.getSubject());
//		}
//	}
	
//	@Test
//	public void listCriteriaTest() throws Exception{
//		PageCriteria pc = new PageCriteria();
//		pc.setPage(1);
//		pc.setNumPerPage(15);
//	
//		List<BbsVO> list = bdao.listCriteria(pc);
//		
//		for(BbsVO bvo : list) {
//			logger.info(bvo.getBid()+ " : " + bvo.getSubject());
//		}
//	}
	
//	@Test // uri를 객체로 사용이 가능한것을 확인
//	public void uriTest() throws Exception{
//		UriComponents uriComponent = UriComponentsBuilder
//									.newInstance()
//									.path("/bbs/read")
//									.queryParam("bid", 3509)
//									.queryParam("numPerPage", 8)
//									.build();
//		
//		logger.info("/bbs/read?bid=3509&numPerPage=8");
//		logger.info(uriComponent.toString());
//	}
	
//	@Test	// uri 를 동적으로 사용
//	public void uriTest() throws Exception{
//		UriComponents uri = UriComponentsBuilder
//							.newInstance()
//							.path("/{module}/{page}")
//							.queryParam("bid", 3509)
//							.queryParam("numPerPage", 8)
//							.build()
//							.expand("bbs","read")// 위 module 와 page 매칭
//							.encode();
//		
//		logger.info("/bbs/read?bid=3509&numPerPage=8");
//		logger.info(uri.toString());
//	}
	
	@Test
	public void testFind() throws Exception{
		FindCriteria fcri = new FindCriteria();
		fcri.setPage(1);
		fcri.setFindType("S");
		fcri.setKeyword("조반석");
		
		logger.info("find start ........ ");
		
		List<BbsVO> list = bdao.listFind(fcri);
		for(BbsVO bvo : list) {
			logger.info(bvo.getBid() + " : " + bvo.getSubject());
		}
		
		logger.info("find data start ........." );
		logger.info("findCountData : " + bdao.finCountData(fcri));
	}
	
}// class
