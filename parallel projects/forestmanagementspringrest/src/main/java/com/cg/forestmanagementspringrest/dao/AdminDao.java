package com.cg.forestmanagementspringrest.dao;

import com.cg.forestmanagementspringrest.dto.AdminBean;

public interface AdminDao {
	public AdminBean login(AdminBean bean);

	public boolean register(AdminBean bean);

}
