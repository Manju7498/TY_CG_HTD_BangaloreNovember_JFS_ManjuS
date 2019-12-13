package phonesimulatorapplication;

import java.util.Scanner;

import com.cg.phonesimulatorapplication.phone.controller.Contact;

public class PhoneMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 to show all contacts");
			System.out.println("Press 2 to search for contact(using name)");
			System.out.println("Press 3 to operate on contact");
			int choice=sc.nextInt();
			Contact c=new Contact();
			switch(choice) {
			case 1 : 
				c.allContacts();
				break;
			case 2 :
				c.getContact();
				c.search();
			case 3 : 
				c.contact();
			
			}
		}
	}

}
