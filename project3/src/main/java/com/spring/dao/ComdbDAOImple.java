package com.spring.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.ComdbVO;
@Repository
public class ComdbDAOImple implements ComdbDAO {

	@Inject
	private SqlSession ss;
	
	@Override
	public ComdbVO searchCdb(String bnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("searchCdb", bnum);
	}
	
	

}
