package com.cg.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.cg.forestrymanagementjdbc.bean.UserBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;

public class UserDaoImpl implements UserDao {
	FileReader reader;
	Properties prop;
	UserBean bean;
	Scanner scanner = new Scanner(System.in);

	public UserDaoImpl() {
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
	public boolean deleteUser(String email) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteUserQuery"));) {
			pstmt.setString(1, email);
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
	public boolean addUser(UserBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addUserQuery"));

		) {
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getRole());
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
	public UserBean login(String email, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("userLoginQuery"))) {
			pstmt.setString(1, email);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new UserBean();
				bean.setEmail(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setRole(rs.getString(3));
				return bean;
			}
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}
}
