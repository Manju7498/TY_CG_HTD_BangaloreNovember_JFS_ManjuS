package com.caps.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			/*-------------------------Load the Driver---------------------------------*/
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded..........");
			//Get the DB Connection via Driver
			String dburl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter dbuser and password");
			String dbuser=sc.nextLine();
			String password=sc.nextLine();
			conn=DriverManager.getConnection(dburl,dbuser,password);
			System.out.println("DB Connected");
			//Issue the SQL Queries via Connection
			String query="INSERT INTO USERS_INFO VALUES( ? ,? ,? ,?) ";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter userid");
			pstmt.setInt(1,Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Username");
			pstmt.setString(2,sc.nextLine());
			System.out.println("Enter Email");
			pstmt.setString(3,sc.nextLine());
			System.out.println("Enter Password");
			pstmt.setString(4,sc.nextLine());
			int count=pstmt.executeUpdate();
			System.out.println("Issued the SQL Queries");
			//Process the results
			if(count>0) {
				System.out.println("User inserted...........");
			}else {
				System.err.println("UserId already present");
			}
		} catch (SQLException e) {
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
