package com.cg.empspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.empspringboot.dto.EmployeeAddressBean;
import com.cg.empspringboot.dto.EmployeeBean;
import com.cg.empspringboot.exceptions.EmployeeException;
import com.cg.empspringboot.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Override
	public EmployeeBean auth(String email, String password) {
		EmployeeBean bean=repository.findByemployeeEmail(email);
		if(bean!=null) {
		if(encoder.matches(password, bean.getPassword())) {
		return bean;
		}
		throw new EmployeeException("Password not matching");
	}
	throw new EmployeeException("Email doesn't exist");
	}
	@Override
	public boolean register(EmployeeBean bean) {
		bean.setPassword(encoder.encode(bean.getPassword()));
		for (EmployeeAddressBean addressBean : bean.getAddressBeans()) {
			addressBean.setBean(bean);
		}
		repository.save(bean);
		return true;
	}

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		return repository.findByKey(key);
	}

	@Override
	public boolean changePassword(int employeeId, String password) {
		repository.changePassword(employeeId,encoder.encode(password));
		return true;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		repository.deleteById(employeeId);
		return true;
	}

}
