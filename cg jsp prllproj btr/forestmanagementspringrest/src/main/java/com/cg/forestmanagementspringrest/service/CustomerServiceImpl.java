package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.CustomerDao;
import com.cg.forestmanagementspringrest.dto.CustomerBean;
import com.cg.forestmanagementspringrest.validations.Validations;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;
	Validations validations = new Validations();

	@Override
	public boolean addCustomer(CustomerBean customer) {
		if (validations.idValidation(customer.getCustomerId())) {
			if (validations.nameValidation(customer.getCustomerName())) {
				if (validations.addressValidation(customer.getStreetAddress1())) {
					if (validations.addressValidation(customer.getStreetAddress2())) {
						if (validations.nameValidation(customer.getTown())) {
							if (validations.pincodeValidation(customer.getPincode())) {
								if (validations.emailValidation(customer.getEmail())) {
									if (validations.phoneNumberValidation(customer.getCustomerPhoneNumber())) {
										return dao.addCustomer(customer);
									} else {
										System.err.println("Please enter valid phone number");
									}
								} else {
									System.err.println("Please enter valid email");
								}
							} else {
								System.err.println("Please enter valid pincode");
							}
						} else {
							System.err.println("Please enter valid town");
						}
					} else {
						System.err.println("Please enter valid address2");
					}
				} else {
					System.err.println("Please enter valid address1");
				}
			} else {
				System.err.println("Please enter valid name");
			}
		} else {
			System.err.println("Please enter valid id");
		}
		return false;
	}

	@Override
	public CustomerBean getCustomer(String customerId) {
		// TODO Auto-generated method stub
		return dao.getCustomer(customerId);
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	@Override
	public boolean deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(String customerId, CustomerBean customer) {
		if (validations.idValidation(customerId)) {
			if (validations.nameValidation(customer.getCustomerName())) {
				if (validations.addressValidation(customer.getStreetAddress1())) {
					if (validations.addressValidation(customer.getStreetAddress2())) {
						if (validations.nameValidation(customer.getTown())) {
							if (validations.pincodeValidation(customer.getPincode())) {
								if (validations.emailValidation(customer.getEmail())) {
									if (validations.phoneNumberValidation(customer.getCustomerPhoneNumber())) {
										return dao.updateCustomer(customerId,customer);
									} else {
										System.err.println("Please enter valid phone number");
									}
								} else {
									System.err.println("Please enter valid email");
								}
							} else {
								System.err.println("Please enter valid pincode");
							}
						} else {
							System.err.println("Please enter valid town");
						}
					} else {
						System.err.println("Please enter valid address2");
					}
				} else {
					System.err.println("Please enter valid address1");
				}
			} else {
				System.err.println("Please enter valid name");
			}
		} else {
			System.err.println("Please enter valid id");
		}
		return false;
	}

}
