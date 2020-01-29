package com.cg.forestrymanagementcollections.dao;

import java.util.HashMap;
import java.util.Set;

import com.cg.forestrymanagementcollections.bean.ProductBean;
import com.cg.forestrymanagementcollections.exceptions.ForestryExceptions;

import java.util.Map.Entry;

public class ProductDaoImpl implements ProductDao {
	private HashMap<Integer, ProductBean> productbeans = new HashMap<Integer, ProductBean>();
	Set<Entry<Integer, ProductBean>> s = productbeans.entrySet();
	ProductBean product1 = new ProductBean();

	@Override
	public boolean deleteProduct(int productId) {
		for (Entry<Integer, ProductBean> entry : s) {
			try {
				if (entry.getKey() == productId) {
					productbeans.remove(productId);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}

	@Override
	public ProductBean getProduct(int productId) {
		try {
			if (productbeans.containsKey(productId) == true) {
				return productbeans.get(productId);
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public boolean addProduct(int productId, ProductBean product) {
		for (Entry<Integer, ProductBean> entry : s) {
			try {
				if (entry.getKey() == productId) {
					return false;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		productbeans.put(productId, product);
		return true;
	}

	@Override
	public HashMap<Integer, ProductBean> getAllProducts() {
		for (Entry<Integer, ProductBean> entry : s) {
			try {
				if (entry != null) {
					return productbeans;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return null;
	}

	@Override
	public boolean updateProduct(int productId, ProductBean product) {
		for (Entry<Integer, ProductBean> entry : s) {
			try {
				if (entry.getKey() == productId) {
					productbeans.replace(productId, product);
					return true;
				}
			} catch (Exception e) {
				throw new ForestryExceptions();
			}
		}
		return false;
	}
}
