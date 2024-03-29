package com.cg.forestmanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestmanagementspringrest.dao.CustomerDao;
import com.cg.forestmanagementspringrest.dao.HaulierDao;
import com.cg.forestmanagementspringrest.dao.OrderDao;
import com.cg.forestmanagementspringrest.dao.ProductDao;
import com.cg.forestmanagementspringrest.dto.OrderBean;
import com.cg.forestmanagementspringrest.validations.Validations;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	HaulierDao haulierDao;
	Validations validations = new Validations();

	@Override
	public boolean addOrder(OrderBean order) {
		try {
			if (customerDao.getCustomer(order.getCustomerId()) != null) {
				if (haulierDao.getHaulier(order.getHaulierId()) != null) {
					if (productDao.getProduct(order.getProductId()) != null) {
						if (validations.idValidation(order.getOrderNo())) {
							if (validations.idValidation(order.getCustomerId())) {
								if (validations.idValidation(order.getProductId())) {
									if (validations.idValidation(order.getHaulierId())) {
										if (validations.dateValidation(order.getDeliveryDate())) {
											if (validations.idValidation(order.getQuantity())) {
												return dao.addOrder(order);
											} else {
												System.err.println("Please enter valid quantity");
											}
										} else {
											System.err.println("Please enter valid date");
										}
									} else {
										System.err.println("Please enter valid haulier id");
									}
								} else {
									System.err.println("Please enter valid product id");
								}
							} else {
								System.err.println("Please enter valid customer id");
							}
						} else {
							System.err.println("Please enter valid order id");
						}
					} else {
						System.err.println("Product Id not found");
					}
				} else {
					System.err.println("Haulier Id not found");
				}
			} else {
				System.err.println("Customer Id not found");
			}
		} catch (Exception e) {
			System.err.println("Something went wrong!!!");
		}
		return false;
	}

	@Override
	public OrderBean getOrder(String orderNo) {
		// TODO Auto-generated method stub
		return dao.getOrder(orderNo);
	}

	@Override
	public List<OrderBean> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.getAllOrders();
	}

	@Override
	public boolean deleteOrder(String orderNo) {
		// TODO Auto-generated method stub
		return dao.deleteOrder(orderNo);
	}

	@Override
	public boolean updateOrder(String orderNo, OrderBean order) {
		try {
			if (customerDao.getCustomer(order.getCustomerId()) != null) {
				if (haulierDao.getHaulier(order.getHaulierId()) != null) {
					if (productDao.getProduct(order.getProductId()) != null) {
						if (validations.idValidation(order.getOrderNo())) {
							if (validations.idValidation(order.getCustomerId())) {
								if (validations.idValidation(order.getProductId())) {
									if (validations.idValidation(order.getHaulierId())) {
										if (validations.dateValidation(order.getDeliveryDate())) {
											if (validations.idValidation(order.getQuantity())) {
												return dao.updateOrder(orderNo, order);
											} else {
												System.err.println("Please enter valid quantity");
											}
										} else {
											System.err.println("Please enter valid date");
										}
									} else {
										System.err.println("Please enter valid haulier id");
									}
								} else {
									System.err.println("Please enter valid product id");
								}
							} else {
								System.err.println("Please enter valid customer id");
							}
						} else {
							System.err.println("Please enter valid order id");
						}
					} else {
						System.err.println("Product Id not found");
					}
				} else {
					System.err.println("Haulier Id not found");
				}
			} else {
				System.err.println("Customer Id not found");
			}
		} catch (Exception e) {
			System.err.println("Something went wrong!!!");
		}
		return false;
	}
}
