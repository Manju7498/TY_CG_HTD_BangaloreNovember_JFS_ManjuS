package com.cg.forestmanagementspringrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.AdminDao;
import com.cg.forestmanagementspringrest.dto.AdminBean;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao dao;

	

	@Override
	public boolean register(AdminBean bean) {
		// TODO Auto-generated method stub
		return dao.register(bean);
	}



	@Override
	public AdminBean login(AdminBean bean) {
		// TODO Auto-generated method stub
		return dao.login(bean);
	}

}
