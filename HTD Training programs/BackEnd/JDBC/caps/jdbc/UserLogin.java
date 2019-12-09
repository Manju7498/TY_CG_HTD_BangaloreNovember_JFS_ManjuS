package com.caps.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class UserLogin {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		/*--------------------Load the driver--------------------------*/
		try {
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded.....");
			/*-----------------Get the DB Connection via Driver-------------*/
			/*localhost or 127.0.0.1*/
			String dburl="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("Enter Username and Password");
			String dbuser=sc.nextLine();
			String dbpassword=sc.nextLine();
			conn=DriverManager.getConnection(dburl,dbuser,dbpassword);
			System.out.println("connection established");
			/*--------------------Issue the SQL queries via Connection-------------*/
			String query="SELECT * FROM USERS_INFO WHERE userid= ? AND password= ? ";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter Userid : ");
			pstmt.setInt(1,Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Password : ");
			pstmt.setString(2,sc.nextLine());
			rs=pstmt.executeQuery();
			System.out.println("query issued executed");
			/*-------------------Process the results via returned by SQL queries----------------*/
			if(rs.next()) { //IF QUERY RETURNS 0 OR 1 ROW
				System.out.println("userid is "+rs.getInt(1));
				System.out.println("username is "+rs.getString(2));
				System.out.println("email is "+rs.getString(3));
				System.out.println("password is "+rs.getString(4));
			}else {
				System.err.println("Can't find ur account :(");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*------------------------------Close all JDBC Objects--------------------------*/
			try {
				if(conn!=null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) 
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs!=null) 
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}




}


