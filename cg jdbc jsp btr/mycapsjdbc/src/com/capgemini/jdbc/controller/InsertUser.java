package com.capgemini.jdbc.controller;
import java.util.Scanner;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class InsertUser {

	public static void main(String[] args) {
		UserServices services=UserFactory.instanceofUserServices();
		UserBean user=new UserBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter new userid");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("enter new  username");
		user.setUsername(sc.nextLine());
		System.out.println("enter new  useremail");
		user.setEmail(sc.nextLine());
		System.out.println("enter new password");
		user.setPassword(sc.nextLine());
//		System.out.println("Enter new Location");
    	if(services.insertUser(user)) {
			System.out.println("User inserted...........");
		}else {
			System.err.println("something went wrong");
		}
		sc.close();
	}

}
