package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UpdateUser {

	public static void main(String[] args) {
		UserServices services=UserFactory.instanceofUserServices();
		UserBean user=new UserBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter userid");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("enter username");
		user.setUsername(sc.nextLine());
		System.out.println("enter email");
		user.setEmail(sc.nextLine());
		if(services.updateUser(user.getUserid(),user.getUsername(),user.getPassword())) {
			System.out.println("User updated...........");
		}else {
			System.err.println("something went wrong");
		}
		sc.close();
	}
}

