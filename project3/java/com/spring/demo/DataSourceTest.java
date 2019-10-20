package com.spring.demo;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //class.forname(DRIVER) 이 없어서 에러터지므로 해줘야한다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	@Inject
	private DataSource dataSource ;
	
	@Test
	public void testConn() throws Exception{
		Connection conn = dataSource.getConnection();
		System.out.println("conn : " + conn);
	}

	
	
}
