package com.cg.springrest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.springrest.dao.EmployeeDao;
import com.cg.springrest.dto.EmployeeAddressBean;
import com.cg.springrest.dto.EmployeeBean;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Override
	public EmployeeBean auth(String email, String password) {
		return dao.auth(email,password);
	}

	@Override
	public boolean register(EmployeeBean bean) {
		
		String encodedPassword=encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
		List<EmployeeAddressBean> addressBeans = bean.getAddressBeans();
		for (EmployeeAddressBean employeeAddressBean : addressBeans) {
			employeeAddressBean.setBean(bean);
		}
		return dao.register(bean);
	}

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		return dao.getEmployees(key);
	}

	@Override
	public boolean changePassword(int employeeId, String password) {
		return dao.changePassword(employeeId,encoder.encode(password));
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return dao.deleteEmployee(employeeId);
	}

}
