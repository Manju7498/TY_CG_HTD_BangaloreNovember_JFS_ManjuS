package com.cg.forestmanagementspringrest.service;

import com.cg.forestmanagementspringrest.dto.AdminBean;

public interface AdminService {
	public AdminBean login(AdminBean bean);

	public boolean register(AdminBean bean);

}
