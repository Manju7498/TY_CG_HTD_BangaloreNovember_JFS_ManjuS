package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class EvolvedJDBC1v2 {

	public static void main(String[] args) {
		FileReader reader=null;
		Properties prop=null;
		String dburl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
		String query="SELECT * FROM USERS_INFO";
		try {
			reader=new FileReader("db1.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded.......");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try(
				Connection conn=DriverManager.getConnection(dburl,prop);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)
				) {
			while(rs.next()) {
				System.out.println("UserId : "+rs.getInt(1));
				System.out.println("UserName : "+rs.getString(2));
				System.out.println("Useremail : "+rs.getString(3));
				System.out.println("**********************************");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
