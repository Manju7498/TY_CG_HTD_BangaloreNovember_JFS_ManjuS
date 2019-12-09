package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserEmailUpdate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			/*-------------------------Load the Driver---------------------------------*/
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded..........");
			//Get the DB Connection via Driver
			String dburl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter dbuser and password");
			String dbuser=sc.nextLine();
			String password=sc.nextLine();
			conn=DriverManager.getConnection(dburl,dbuser,password);
			System.out.println("DB Connected");
			//Issue the SQL Queries via Connection
			String query="UPDATE  USERS_INFO  SET email= ? WHERE email= ? ";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter new Email");
			pstmt.setString(1,sc.nextLine());
			System.out.println("Enter old Email");
			pstmt.setString(2,sc.nextLine());
			int count=pstmt.executeUpdate();
			System.out.println("Issued the SQL Queries");
			//Process the results
			if(count>0) {
				System.out.println("Query ok,"+count+" rows effected");
			}else {
				System.err.println("User account not found to update");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Close the JDBC Objects
			try {
				if(conn!=null) {
					conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) {
					conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
