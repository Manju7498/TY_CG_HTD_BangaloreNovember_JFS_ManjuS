package com.capgemini.loanprocessingsystem.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public static boolean isWord(String name) {
		return (Pattern.matches("[a-zA-Z]+",name));
	}

	public static boolean isTelePhoneNumber(String telePhNum) {
		return Pattern.matches("^[0-9]{10}$", telePhNum);
	}

	public static boolean isNumber(String number) {
		return Pattern.matches("^[0-9]{3}$+", number);
	}

	public static boolean ispan(String name) {
		return (Pattern.matches("[a-zA-Z0-9]{10}+",name));
	}
	public static boolean isAadharCard(String card) {
		return (Pattern.matches("[0-9]+{12}",card));
	}

	public static boolean valEmail(String custemail) {

		String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailpat=Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher=emailpat.matcher(custemail);
		return matcher.find();

	}

	public static int countofdigits(int number) {
		int count=0;
		while(number!=0) {
			number/=10;
			++count;
		}
		return count;
	}

	public static boolean deliveryDate(String date) throws ParseException{
		String dateValid="^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{4}$";
		Pattern exp=Pattern.compile(dateValid);
		Matcher match=exp.matcher((CharSequence)date);
		if(match.matches()) {

			SimpleDateFormat objSDF = new SimpleDateFormat("dd/mm/yyyy");
			Date date1 = objSDF.parse(date);
			Date datee = objSDF.parse("17/01/2020");
			//			DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd/mm/yyyy");
			//			LocalDateTime local=LocalDateTime.now();
			//			String datee=dateFormat.format(local);
			//			
			if (date1.compareTo(datee) > 0) {
				return true;

			} // compareTo method returns the value less than 0 if this Date is before the Date argument;
			else if (date1.compareTo(datee) == 0) {
				//				   System.out.println("Both are same dates");
				return true;
			} // compareTo method returns the value 0 if the argument Date is equal to the second Date;
			else {
				//				   System.err.println("You seem to be a time traveller!!");
				return false;
			}
			//			
			//			
			//			
			//			
			//			
			//			
			//			
			//			if(date.compareTo(datee)<0||date.compareTo(datee)==0) {
			//				System.err.println("Please Enter Future Date!!!");
			//			}else {
			//				return true;
			//			}

		}else {
			//System.err.println("Enter Valid Date Format!!!");
		}

		return false; 
	}
	public static boolean DayValid(String day) {

		if(day.equalsIgnoreCase("monday")) {
			return true;
		}else if(day.equalsIgnoreCase("tuesday")) {
			return true;
		}
		else if(day.equalsIgnoreCase("wednesday")) {
			return true;
		}
		else if(day.equalsIgnoreCase("thursday")) {
			return true;
		}
		else if(day.equalsIgnoreCase("friday")) {
			return true;
		}
		else if(day.equalsIgnoreCase("saturday")) {
			return true;
		}else if(day.equalsIgnoreCase("sunday")) {
			return true;
		}else if(day.equalsIgnoreCase("mon")) {
			return true;
		}
		else if(day.equalsIgnoreCase("tue")) {
			return true;
		}else if(day.equalsIgnoreCase("wed")) {
			return true;
		}
		else if(day.equalsIgnoreCase("thu")) {
			return true;
		}
		else if(day.equalsIgnoreCase("fri")) {
			return true;
		}
		else if(day.equalsIgnoreCase("sat")) {
			return true;
		}else if(day.equalsIgnoreCase("sun")) {
			return true;
		}
		else {
			return false;
		}

	}
	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static LocalDate createRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(1, 12);
		int year = createRandomIntBetween(startYear, endYear);
		return LocalDate.of(year, month, day);
	}

}