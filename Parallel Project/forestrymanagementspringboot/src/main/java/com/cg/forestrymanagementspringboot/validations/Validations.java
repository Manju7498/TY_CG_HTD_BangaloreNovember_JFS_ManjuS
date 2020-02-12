package com.cg.forestrymanagementspringboot.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public boolean idValidation(String id) {
		Pattern pattern = Pattern.compile("^[0-9]{4}$");
		Matcher matcher = pattern.matcher(id);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	public boolean townValidation(String town) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]{0,20}$");
		Matcher matcher = pattern.matcher(town);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean pincodeValidation(String pincode) {
		Pattern pattern = Pattern.compile("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$");
		Matcher matcher = pattern.matcher(pincode);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean nameValidation(String name) {
		Pattern pattern = Pattern.compile("^[A-Za-z]{1,8}$");
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidation(String password) {
		Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean emailValidation(String email) {
		Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean phoneNumberValidation(String phoneNumber) {
		Pattern pattern = Pattern.compile("^[7-9][0-9]{9}$");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean dateValidation(String date) {
		Pattern pattern = Pattern.compile("^((0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|2[0-9])[0-9]{2})$");
		Matcher matcher = pattern.matcher(date);
		if (matcher.matches()) {
			Date date1=null;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				System.out.println("Please enter valid date");
			}
			if (new Date().before(date1)) {
			return true;
			}
		}
		return false;
	}


	public boolean addressValidation(String address) {
		Pattern pattern = Pattern.compile("^[#.0-9a-zA-Z,-]+$");
		Matcher matcher = pattern.matcher(address);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
