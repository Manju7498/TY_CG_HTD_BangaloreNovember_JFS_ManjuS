package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EvolvedJDBC {
	public static void main(String[] args) {
		Scanner sc=new  Scanner(System.in);
		String dburl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
		System.out.println("Enter UserName and Password");
		String user=sc.nextLine();
		String password=sc.nextLine();
		String query="SELECT * FROM USERS_INFO";
		try(Connection conn=DriverManager.getConnection(dburl,user,password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)) {
			while(rs.next()) {
				System.out.println("UserId : "+rs.getInt(1));
				System.out.println("UserName : "+rs.getString(2));
				System.out.println("Useremail : "+rs.getString(3));
			}sc.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

