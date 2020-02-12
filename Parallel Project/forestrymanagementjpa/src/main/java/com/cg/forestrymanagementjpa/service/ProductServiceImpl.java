package com.cg.forestrymanagementjpa.service;

import java.util.List;

import com.cg.forestrymanagementjpa.bean.ProductBean;
import com.cg.forestrymanagementjpa.dao.ProductDao;
import com.cg.forestrymanagementjpa.factory.ProductFactory;

public class ProductServiceImpl implements ProductService {
	ProductDao dao = ProductFactory.instanceofProductDaoImpl();

	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	public ProductBean productLogin(int productid) {
		// TODO Auto-generated method stub
		return dao.productLogin(productid);
	}

	public boolean updateProductName(int productId, ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.updateProductName(productId, bean);
	}

	public boolean deleteProduct(int productid) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productid);
	}

	public boolean insertProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.insertProduct(bean);
	}

	
}
