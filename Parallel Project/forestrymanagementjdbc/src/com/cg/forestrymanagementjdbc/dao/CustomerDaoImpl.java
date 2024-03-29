package com.cg.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.cg.forestrymanagementjdbc.bean.CustomerBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;

public class CustomerDaoImpl implements CustomerDao {
	FileReader reader;
	Properties prop;
	CustomerBean bean;
	Scanner sc = new Scanner(System.in);

	public CustomerDaoImpl() {
		try {
			reader = new FileReader("forestrydatabasemanagement.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("allCustomersQuery"));) {
			while (rs.next()) {
				bean = new CustomerBean();
				bean.setCustomerId(rs.getInt(1));
				bean.setCustomerName(rs.getString(2));
				bean.setStreetAddress1(rs.getString(3));
				bean.setStreetAddress2(rs.getString(4));
				bean.setTown(rs.getString(5));
				bean.setPincode(rs.getInt(6));
				bean.setEmail(rs.getString(7));
				bean.setCustomerPhoneNumber(rs.getLong(8));
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
	}

	@Override
	public CustomerBean customerLogin(int customerId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loginCustomerQuery"))) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new CustomerBean();
				bean.setCustomerId(rs.getInt(1));
				bean.setCustomerName(rs.getString(2));
				bean.setStreetAddress1(rs.getString(3));
				bean.setStreetAddress2(rs.getString(4));
				bean.setTown(rs.getString(5));
				bean.setPincode(rs.getInt(6));
				bean.setEmail(rs.getString(7));
				bean.setCustomerPhoneNumber(rs.getLong(8));
				return bean;
			}

		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateCustomerNameQuery"));) {
			pstmt.setString(1, bean.getCustomerName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setInt(3, customerId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteCustomerQuery"));) {
			pstmt.setInt(1, customerId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}

	@Override
	public boolean insertCustomer(CustomerBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertCustomerQuery"));

		) {
			pstmt.setInt(1, bean.getCustomerId());
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getStreetAddress1());
			pstmt.setString(4, bean.getStreetAddress2());
			pstmt.setString(5, bean.getTown());
			pstmt.setInt(6, bean.getPincode());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getCustomerPhoneNumber());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return false;
	}
}
