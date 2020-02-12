package com.cg.forestmanagementspringrest.testormconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cg.forestmanagementspringrest.dao.ContractDao;
import com.cg.forestmanagementspringrest.dao.ContractDaoImpl;
import com.cg.forestmanagementspringrest.dao.CustomerDao;
import com.cg.forestmanagementspringrest.dao.CustomerDaoImpl;
import com.cg.forestmanagementspringrest.dao.HaulierDao;
import com.cg.forestmanagementspringrest.dao.HaulierDaoImpl;
import com.cg.forestmanagementspringrest.dao.OrderDao;
import com.cg.forestmanagementspringrest.dao.OrderDaoImpl;
import com.cg.forestmanagementspringrest.dao.ProductDao;
import com.cg.forestmanagementspringrest.dao.ProductDaoImpl;
import com.cg.forestmanagementspringrest.dao.UserDao;
import com.cg.forestmanagementspringrest.dao.UserDaoImpl;
import com.cg.forestmanagementspringrest.service.ContractService;
import com.cg.forestmanagementspringrest.service.ContractServiceImpl;
import com.cg.forestmanagementspringrest.service.CustomerService;
import com.cg.forestmanagementspringrest.service.CustomerServiceImpl;
import com.cg.forestmanagementspringrest.service.HaulierService;
import com.cg.forestmanagementspringrest.service.HaulierServiceImpl;
import com.cg.forestmanagementspringrest.service.OrderService;
import com.cg.forestmanagementspringrest.service.OrderServiceImpl;
import com.cg.forestmanagementspringrest.service.ProductService;
import com.cg.forestmanagementspringrest.service.ProductServiceImpl;
import com.cg.forestmanagementspringrest.service.UserService;
import com.cg.forestmanagementspringrest.service.UserServiceImpl;

@Configuration
public class SpringRestTestConfig {
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	@Bean
	public ContractDao contractDao() {
		return new ContractDaoImpl();
	}
	@Bean
	public ContractService contractService() {
		return new ContractServiceImpl();
	}
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoImpl();
	}
	@Bean
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}
	@Bean
	public HaulierDao haulierDao() {
		return new HaulierDaoImpl();
	}
	@Bean
	public HaulierService haulierService() {
		return new HaulierServiceImpl();
	}
	@Bean
	public OrderDao orderDao() {
		return new OrderDaoImpl();
	}
	@Bean
	public OrderService OrderService() {
		return new OrderServiceImpl();
	}
	@Bean
	public ProductDao productDao() {
		return new ProductDaoImpl();
	}
	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}
}
