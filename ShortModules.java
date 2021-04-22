package com.nandhini;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.util.Scanner;

public class ShortModules {
	public static void main(String[] args) {
		
	}

	/****** COMPARE DATE *******/
public static void  dateChecking(LocalDate bdate) 
{
	if (bdate.isAfter(LocalDate.now())) // TO CHECK THE DATE IS VALID OR NOT
	{System.out.println("Date entered is after the today's date");} 
	else if (bdate.isBefore(LocalDate.now())) {
		System.out.println("Date entered is before the today's date");}
	else {
		System.out.println("You've entered the current date");}
}


/******* CARD VALIDITY DATE CHECKING *******/
public static void creditcardValidyear(String cardex) {
	
	YearMonth cardexpirydate = YearMonth.parse(cardex);
	YearMonth now=YearMonth.now();
	if (cardexpirydate.isBefore(now)) {
		System.out.println("Card expired");
	}
	else {
		System.out.println("Card is valid");
	}
	
}


/********* AGE CALCULATING ********/
public static int ageCalculator(LocalDate dob3) {
	LocalDate today = LocalDate.now();// GETTING TODAY'S DATE
	Period p = Period.between(dob3, today);// FINDING DIFFERENCE BETWEEN TWO DATES
	int age = p.getYears();// GETTING THE YEAR SEPERATELY
	System.out.println("Your age is "+ age);
	return age;
}

/****** DISCOUNT FOR 60+ ****/
public static double seniorcitizenDiscount(double amt, int age) {
		if (age >= 60)// AGE >60 THEN 50% DISCOUNT
	{
		double bill = amt / 2;
		System.out.println("Your final bill amount with discount 50%: " + bill);
	} else {
		System.out.println("Your final bill amount: " + amt);

	}
		return amt;
	//ip.close();// CLOSING SCANNER
}


/****** GETTING USER ID ********/
public static boolean userId()	
{
	Scanner ip = new Scanner(System.in);
	String mobno= null;
	boolean valid = true;
	long ph = 0;
	do {
		System.out.println("Enter your User ID (mobile number):");
		mobno = ip.next();
	    ph = Long.parseLong(mobno);
		if (mobno.length() != 10 || ph / 1000000000 == 0) {
			valid=false;
			System.out.println("Please enter a valid mobile number");}
	    }while (mobno.length() != 10 || ph / 1000000000 == 0);
	return valid;
}


/*********GETTING PASSWORD *******/
public static int pwd()
{
	int pwd = 0;
	String pwd1= null;
	Scanner ip = new Scanner(System.in);
	do{
		System.out.println("Enter your password (8 numbers)");
		pwd = ip.nextInt();
		pwd1 = Integer.toString(pwd);
		if (pwd1.length() != 8)// TO CHECK THE LENGTH OF A STRING
	{
			System.out.println("Enter a digit valid password");
		}

		
	}while(pwd1.length() != 8);
return pwd;	
}

/***** GET THE TIME ********/
public static void getTime(String btime)
{
	LocalTime bookingtime = LocalTime.parse(btime);//parse string into time format
}

public static void ticketAmtCalc(int lessThan60, int wish, int adults) {
	double x,z,tot,amt=0;
	switch(wish){
	case 1:{ z=200*lessThan60;x=adults*100;
	tot= z+x;
	System.out.println("Total amount: " +tot);
    amt= z+(z*0.07);
	System.out.println("Total amount with GST: " +amt);
	break;}
	case 2:{z=170*lessThan60;x=adults*85;
	tot= z+x;
	System.out.println("Total amount: " +tot);
    amt= z+(z*0.07);
	System.out.println("Total amount with GST: " +amt);
	break;}
	case 3:{z=150*lessThan60;x=adults*75;
	tot= z+x;
	System.out.println("Total amount: " +tot);
    amt= z+(z*0.07);
	System.out.println("Total amount with GST: " +amt);
	break;}
	default:System.out.println("Kindly refresh and try again");
}
}
}