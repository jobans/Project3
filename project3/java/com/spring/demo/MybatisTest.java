package com.spring.demo;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// root-context.xml 에 있는 것을 불러오고 변환
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
	
	@Inject
	private SqlSessionFactory sqlFactory ;
	

	@Test //org.junit.Test;
	public void testSqlFactory() {
		System.out.println(sqlFactory); // 공장이 보이는지 확인
	}
	
	// SqlSessionTemplate test
	@Test
	public void sessionTest() throws Exception {
		SqlSession ss = sqlFactory.openSession();
		System.out.println("session : " + ss);
	}
}
