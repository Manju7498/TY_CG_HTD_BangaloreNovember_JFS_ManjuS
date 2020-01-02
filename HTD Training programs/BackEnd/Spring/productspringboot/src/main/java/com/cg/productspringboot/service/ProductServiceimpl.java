package com.cg.productspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.productspringboot.dao.ProductDao;
import com.cg.productspringboot.dto.ProductBean;

@Service
public class ProductServiceimpl implements ProductService {

		@Autowired
		private ProductDao dao;

		@Override
		public boolean addProduct(ProductBean product) {

			return dao.addProduct(product);
		}

		@Override
		public ProductBean getProduct(int id) {
			
			return dao.getProduct(id);
		}

		@Override
		public List<ProductBean> getAllProducts() {
			
			return dao.getAllProducts();
		}

		@Override
		public boolean deleteProduct(int id) {
			
			return dao.deleteProduct(id);
		}
}
