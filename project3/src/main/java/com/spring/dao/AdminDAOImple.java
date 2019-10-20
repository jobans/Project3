package com.spring.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.spring.vo.AD_NoticeVO;
import com.spring.vo.ComVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;

@Repository
public class AdminDAOImple implements AdminDAO{

	@Inject
	private SqlSession ss;
	

	@Override
	public List<UserVO> UserList() {
		// TODO Auto-generated method stub
		return ss.selectList("UserList");
	}
	
	@Override
	public List<OwnerVO> OwnerList() {
		// TODO Auto-generated method stub
		return ss.selectList("OwnerList");
	}

	@Override
	public List<ComVO> ComList() {
		// TODO Auto-generated method stub
		return ss.selectList("ComList");
	}


	@Override
	public void ad_no_Hits(int an_no) {
		// TODO Auto-generated method stub
		ss.update("ad_no_Hits",an_no);
	}

	@Override
	public void ad_no_Write(AD_NoticeVO avo) {
		// TODO Auto-generated method stub
		ss.insert("ad_no_Write",avo);
	}
	
	@Override
	public AD_NoticeVO ad_no_Select(int an_no) {
		// TODO Auto-generated method stub
		return ss.selectOne("ad_no_Select", an_no);
	}

	@Override
	public void ad_no_Update(AD_NoticeVO avo) {
		// TODO Auto-generated method stub
		ss.update("ad_no_Update",avo);
	}

	@Override
	public void ad_no_Delete(int an_no) {
		// TODO Auto-generated method stub
		ss.delete("ad_no_Delete",an_no);
	}

	@Override
	public List<AD_NoticeVO> ad_no_List() {
		// TODO Auto-generated method stub
		return ss.selectList("ad_no_List");
	}

	
	

}
