//package com.capgemini.loanprocessingsystem.validator;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.Date;
//import java.util.Scanner;
//
//public class AgeChecker {
//	public static void main(String[] args) throws ParseException {
//		boolean flag =true;
//		
//		while(flag==true) {
//			try {
//			System.out.print("Please enter date of birth in YYYY-MM-DD:");
//			Scanner scanner = new Scanner(System.in);
//			String input = scanner.nextLine();
//			boolean isTrue = isValidDate(input);
//			if(isTrue!=false) {
//				LocalDate dob = LocalDate.parse(input);
//				System.out.println("Age is:" + getAge(dob));
//				flag=false;
//			}
//		} catch(Exception e) {
//			System.err.println("Enter valid date format!!!");
//		}
//		}
//			
//	
//	}
//	// Returns age given the date of birth
//	public static int getAge(LocalDate dob) {
//		LocalDate curDate = LocalDate.now();
//		return Period.between(dob, curDate).getYears();
//	} 
//
//	public static boolean isValidDate(String d) {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		sdf.setLenient(false);
//		try {
//			Date date = sdf.parse(d); //if date invalid throw exception
//			Date today = new Date();
//			return date.before(today); //return false if future date
//		} catch (Exception e) {
//			return true;
//		}
//	}
//
//}
