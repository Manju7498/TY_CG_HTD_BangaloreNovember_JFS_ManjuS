package com.capgemini.loanprocessingsystem.validator;

import java.time.LocalDate;

public class RandomDateGenerator {
	public static String main(String[] args) {
        for (int i = 0; i <1; i++) {
            LocalDate randomDate = createRandomDate(2020,2021);
            System.out.println(randomDate);
        }
		return null;
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
