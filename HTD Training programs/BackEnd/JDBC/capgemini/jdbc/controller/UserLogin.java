package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UserLogin {

	public static void main(String[] args) {
		UserServices services=UserFactory.instanceofUserServices();
		UserBean user=new UserBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		user.setUsername(sc.nextLine());
		System.out.println("enter password");
		user.setPassword(sc.nextLine());
		UserBean user1=services.userLogin(user.getUsername(),user.getPassword());
		if(user1!=null) {
			System.out.println("Userid : "+user1.getUserid());
			System.out.println("Username : "+user1.getUsername());
			System.out.println("UserEmail : "+user1.getEmail());
			System.out.println("Password : "+user1.getPassword());
		}else {
			System.err.println("details not found");
		}
	}
}
