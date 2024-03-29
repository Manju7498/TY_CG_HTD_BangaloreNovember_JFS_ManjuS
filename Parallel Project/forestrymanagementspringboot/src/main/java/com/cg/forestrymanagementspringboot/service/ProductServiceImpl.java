package com.cg.forestrymanagementspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.forestrymanagementspringboot.dao.ProductDao;
import com.cg.forestrymanagementspringboot.dto.ProductBean;
import com.cg.forestrymanagementspringboot.validations.Validations;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	Validations validations = new Validations();

	@Override
	public boolean addProduct(ProductBean product) {
		if (validations.idValidation(product.getProductId())) {
			if (validations.nameValidation(product.getProductName())) {
					return dao.addProduct(product);
			} else {
				System.err.println("Please enter valid name");
			}
		} else {
			System.err.println("Please enter valid id");
		}
		return false;

	}

	@Override
	public ProductBean getProduct(String productId) {
		// TODO Auto-generated method stub
		return dao.getProduct(productId);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public boolean deleteProduct(String productId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(String productId, ProductBean product) {
		if (validations.idValidation(product.getProductId())) {
			if (validations.nameValidation(product.getProductName())) {
						return dao.updateProduct(productId, product);
			} else {
				System.err.println("Please enter valid name");
			}
		} else {
			System.err.println("Please enter valid id");
		}
		return false;
	}
}
