package com.caps.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			// Load the driver
			/*Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);             not mostly used in industry
			                 (or)                 */
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded....");
			// Get the DB connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6"+"?user=root&password=ROOT";
			conn=DriverManager.getConnection(dbUrl);
			System.out.println("Connection Established.......");
			// Issue the SQL queries via connection
			String query="SELECT * FROM USERS_INFO";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("Query Issued....");
			//Process the result returned
			while(rs.next()) {
				System.out.println("Userid:"+rs.getInt("userid"));
				System.out.println("Username:"+rs.getString("username"));
				System.out.println("Email:"+rs.getString("email"));
				System.out.println("Password:"+rs.getString("password"));
				System.out.println("**************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) 
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(stmt!=null)
						stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				try {
					if(rs!=null)
						rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}

