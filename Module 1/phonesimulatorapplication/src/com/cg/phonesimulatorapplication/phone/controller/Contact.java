package com.cg.phonesimulatorapplication.phone.controller;

import java.util.List;
import java.util.Scanner;

import com.cg.phonesimulatorapplication.phone.bean.ContactBean;
import com.cg.phonesimulatorapplication.phone.factory.ContactFactory;
import com.cg.phonesimulatorapplication.phone.services.ContactServices;


public class Contact {
	Scanner sc=new Scanner(System.in);
	ContactServices services=ContactFactory.instanceofContactServices();
	ContactBean bean=new ContactBean();
	public void contact() {	
		while(true) {
			System.out.println("Press 1 to add contact");
			System.out.println("Press 2 to delete contact");
			System.out.println("Press 3 to edit contact");
			int ch=sc.nextInt();
			switch(ch) {
			case 1 : 
				System.out.println("Enter contact name");
				bean.setName(sc.next());
				System.out.println("Enter contact number");
				bean.setNumber(sc.nextLong());
				System.out.println("Enter group name");
				bean.setGroups(sc.next());
				if(services.addContact(bean)) {
					System.out.println("Contact added");
				}else {
					System.out.println("Contact is not added");
				}
				break;
			case 2 : 
				System.out.println("Enter name to be deleted");
				bean.setName(sc.next());
				if(services.deleteContact(bean.getName())) {
					System.out.println("Contact deleted");
				}else {
					System.out.println("Contact not deleted");
				}
				break;
			case 3 :
				System.out.println("Enter contact name to be edited");
				bean.setName(sc.next());
				if(services.updateContact(bean.getName())) {
					System.out.println("Contact updated");
				}else {
					System.out.println("Contact not updated");
				}
				break;
			}
		}
	}
	public void allContacts() {
		List<ContactBean> list=services.getAllContacts();
		if(list!=null) {
			for(ContactBean bean:list) {
				System.out.println(bean);
			}
		}
		else {
			System.out.println("No Contacts found");
		}
	}
	public void getContact() {
		System.out.println("Enter name to get contact");
		bean.setName(sc.next());
		ContactBean bean1=services.getContact(bean.getName());
		if(bean1!=null) {
			System.out.println("Contact name : "+bean1.getName());
			System.out.println("Contact number : "+bean1.getNumber());
			System.out.println("Contact group : "+bean1.getGroups());
		}else {
			System.out.println("Contact not found");
		}
	}
	public void search() {
		while(true) {
			System.out.println("Press 1 to call");
			System.out.println("Press 2 to message");
			System.out.println("Press 3 to go back to main menu");
			int ch=sc.nextInt();
			switch(ch) {
			case 1 :
				System.out.println("Calling "+bean.getName()+"............");
				break;
			case 2 :
				System.out.println("Messaging "+bean.getName()+".............");
				break;
			case 3 :
				return;
			}
		}
	}
}
