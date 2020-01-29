package com.cg.forestrymanagementjdbc.service;

import java.util.List;

import com.cg.forestrymanagementjdbc.bean.ProductBean;
import com.cg.forestrymanagementjdbc.dao.ProductDao;
import com.cg.forestrymanagementjdbc.factory.ProductFactory;

public class ProductServiceImpl implements ProductService {
	ProductDao dao = ProductFactory.instanceofProductDaoImpl();

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public ProductBean productLogin(int productid) {
		// TODO Auto-generated method stub
		return dao.productLogin(productid);
	}

	@Override
	public boolean updateProduct(int productid, ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.updateProduct(productid, bean);
	}

	@Override
	public boolean deleteProduct(int productid) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productid);
	}

	@Override
	public boolean insertProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.insertProduct(bean);
	}

}
