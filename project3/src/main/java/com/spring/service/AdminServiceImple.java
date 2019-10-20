package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.AdminDAO;
import com.spring.vo.AD_NoticeVO;
import com.spring.vo.ComVO;
import com.spring.vo.NoticeVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;

@Service
public class AdminServiceImple implements AdminService {

	@Inject
	private AdminDAO adao;
	

	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return adao.UserList();
	}
	
	@Override
	public List<OwnerVO> ownerList() {
		// TODO Auto-generated method stub
		return adao.OwnerList();
	}

	@Override
	public List<ComVO> comList() {
		// TODO Auto-generated method stub
		return adao.ComList();
	}

	@Override
	public void ad_no_hits(int an_no) {
		// TODO Auto-generated method stub
		adao.ad_no_Hits(an_no);
	}

	@Override
	public void ad_no_write(AD_NoticeVO avo) {
		// TODO Auto-generated method stub
		adao.ad_no_Write(avo);
	}
	

	@Override
	public AD_NoticeVO ad_no_select(int an_no) {
		// TODO Auto-generated method stub
		return adao.ad_no_Select(an_no);
	}

	@Override
	public void ad_no_update(AD_NoticeVO avo) {
		// TODO Auto-generated method stub
		adao.ad_no_Update(avo);
	}

	@Override
	public void ad_no_delete(int an_no) {
		// TODO Auto-generated method stub
		adao.ad_no_Delete(an_no);
	}

	@Override
	public List<AD_NoticeVO> ad_no_list() {
		// TODO Auto-generated method stub
		return adao.ad_no_List();
	}

}
