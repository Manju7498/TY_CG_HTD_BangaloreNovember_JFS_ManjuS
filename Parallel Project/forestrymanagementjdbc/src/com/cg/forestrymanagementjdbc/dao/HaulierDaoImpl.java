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

import com.cg.forestrymanagementjdbc.bean.HaulierBean;
import com.cg.forestrymanagementjdbc.exceptions.ForestryExceptions;

public class HaulierDaoImpl implements HaulierDao {
	FileReader reader;
	Properties prop;
	HaulierBean bean;
	Scanner sc = new Scanner(System.in);

	public HaulierDaoImpl() {
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
	public List<HaulierBean> getAllHauliers() {
		List<HaulierBean> list = new ArrayList<HaulierBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("allHauliersQuery"));) {
			while (rs.next()) {
				bean = new HaulierBean();
				bean.setHaulierId(rs.getInt(1));
				bean.setHaulierName(rs.getString(2));
				bean.setStreetAddress1(rs.getString(3));
				bean.setStreetAddress2(rs.getString(4));
				bean.setTown(rs.getString(5));
				bean.setPostcode(rs.getInt(6));
				bean.setEmail(rs.getString(7));
				bean.setPhonenumber(rs.getLong(8));
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new ForestryExceptions();
		}
	}

	@Override
	public HaulierBean haulierLogin(int haulierId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loginHaulierQuery"))) {
			pstmt.setInt(1, haulierId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new HaulierBean();
				bean.setHaulierId(rs.getInt(1));
				bean.setHaulierName(rs.getString(2));
				bean.setStreetAddress1(rs.getString(3));
				bean.setStreetAddress2(rs.getString(4));
				bean.setTown(rs.getString(5));
				bean.setPostcode(rs.getInt(6));
				bean.setEmail(rs.getString(7));
				bean.setPhonenumber(rs.getLong(8));
				return bean;
			}

		} catch (Exception e) {
			throw new ForestryExceptions();
		}
		return null;
	}

	@Override
	public boolean updateHaulier(int haulierId, HaulierBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateHaulierNameQuery"));) {
			pstmt.setString(1, bean.getHaulierName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setInt(3, haulierId);
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
	public boolean deleteHaulier(int haulierId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteHaulierQuery"));) {
			pstmt.setInt(1, haulierId);
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
	public boolean insertHaulier(HaulierBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertHaulierQuery"));

		) {
			pstmt.setInt(1, bean.getHaulierId());
			pstmt.setString(2, bean.getHaulierName());
			pstmt.setString(3, bean.getStreetAddress1());
			pstmt.setString(4, bean.getStreetAddress2());
			pstmt.setString(5, bean.getTown());
			pstmt.setInt(6, bean.getPostcode());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getPhonenumber());
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
