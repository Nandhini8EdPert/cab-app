# cab-app
Cab booking app
package com.nandhini;
import java.util.*;
import java.time.*;

public class cabBook {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		/******** LEVEL 1 ********/
		
	    userId();
	    pwd();
		
		/******* LEVEL 5 ******** GETTING DATE AND TIME FOR PICKUP *****/
		System.out.println("Enter date of your journey: ");
	    String datestr =ip.next();
		LocalDate bdate = LocalDate.parse(datestr);
		dateChecking(bdate);
	
		System.out.println("Enter your travel timing(hh:mm:ss): ");
		String btime = ip.next();
		LocalTime bookingtime = LocalTime.parse(btime);
		int h = bookingtime.getHour(); // GETTING HOUR SEPERATELY FROM A TIME STAMP
		
		/******* LEVEL 2 ********/
		System.out.println("Cab types Available");
		System.out.println("1.Mini -- Rs 10 per Km");
		System.out.println("2.Macro -- Rs 15 per Km");
		System.out.println("3.Prime -- Rs 20 per Km");

		/******* LEVEL 3 ******* CHECKING PEAK HOURS *******/
		System.out.println("Enter your mode of travel you wish either 1 or 2 or 3");
		int wish = ip.nextInt();
		System.out.println("Enter the number of Kms you wanted to travel");
		int kms = ip.nextInt();
		double amt = 0;
		// IF IT IS PEAK HOURS
		if (h >= 17 && h <= 19)/******* LEVEL 6 *******/
		{
			switch (wish) {
			case 1: {
				double z = kms * 10;// CALCULATING RS FOR CERTAIN Km
				double gst1 = z + (z * 0.07);// ADDING GST TO BILL AMOUNT
				amt = gst1 + (gst1 * 0.0125);// INCLUDING THE PEAK HOURS CHARGE
				System.out.println("Your travel charge estimate is " + z);
				System.out.println("Your travel charge estimate with GST is " + gst1);/******** LEVEL 4 ********/
				System.out.println("Your travel charge estimate with GST and peak hours charge is "
						+ amt);/******** LEVEL 6 ********/
				break;
			}
			case 2: {
				double x = kms * 15;
				double gst2 = x + (x * 0.07);
				amt = gst2 + (gst2 * 0.0125);
				System.out.println("Your travel charge estimate is " + x);
				System.out.println("Your travel charge estimate with GST is " + gst2);/******** LEVEL 4 ********/
				System.out.println("Your travel charge estimate with GST and peak hours charge is "
						+ amt);/******** LEVEL 6 ********/
				break;
			}
			case 3: {
				int y = kms * 20;
				double gst3 = y + (y * 0.07);
				amt = gst3 + (gst3 * 0.0125);
				System.out.println("Your travel charge estimate is " + y);
				System.out.println("Your travel charge estimate with GST is " + gst3);/******** LEVEL 4 ********/
				System.out.println("Your travel charge estimate with GST and peak hours charge is "
						+ amt);/******** LEVEL 6 ********/
				break;
			}
			default:
				System.out.println("Thank You for visiting");
			}

		}
		// OTHER THAN PEAK HOURS
		else {
			switch (wish) {
			case 1: {
				double z = kms * 10;// CALCULATING RS FOR CERTAIN Km
				amt = z + (z * 0.07); // ADDING GST TO BILL AMOUNT
				System.out.println("Your travel charge estimate is " + z);
				System.out.println(
						"Your travel charge estimate with GST is " + amt);/******** LEVEL 4 *** ADDING GST *****/
				break;
			}
			case 2: {
				double x = kms * 15;
				amt = x + (x * 0.07);
				System.out.println("Your travel charge estimate is " + x);
				System.out.println("Your travel charge estimate with GST is " + amt);/******** LEVEL 4 ********/
				break;
			}
			case 3: {
				int y = kms * 20;
				amt = y + (y * 0.07);
				System.out.println("Your travel charge estimate is " + y);
				System.out.println("Your travel charge estimate with GST is " + amt);/******** LEVEL 4 ********/
				break;
			}
			default:
				System.out.println("Thank You for visiting");
			}
		
		}
		System.out.println("Enter your date of birth(yyyy-mm-dd): ");
		String dob = ip.next(); // GETTING DATE OF BIRTH
		LocalDate dob3 = LocalDate.parse(dob);// STRING INTO DATE FORMAT
		int age = ageCalculator(dob3);
		seniorcitizenDiscount( amt, age);

		/******** LEVEL 5 ********/
		System.out.println("Your journey confirmed on " + bdate + " in " + bookingtime);
		System.out.println("Enter your card Expiry date(yyyy-mm): ");
		String cardex = ip.next();
		
	    creditcardValidyear(cardex);
	}

   /******* CHECK DATE ******/
	public static void dateChecking(LocalDate bdate) {
		if (bdate.isAfter(LocalDate.now())) // TO CHECK THE DATE IS VALID OR NOT
		{
			System.out.println("Date entered is after the today's date");
		} else if (bdate.isBefore(LocalDate.now())) {
			System.out.println("Date entered is before the today's date");
		} else {
			System.out.println("You've entered the current date");
		}
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
			System.out.println("Enter your password (number)");
			pwd = ip.nextInt();
			pwd1 = Integer.toString(pwd);
			if (pwd1.length() != 8)// TO CHECK THE LENGTH OF A STRING
		{
				System.out.println("Enter a digit valid password");
			}

			
		}while(pwd1.length() != 8);
		return pwd;	
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

	
	/********** AGE CALCULATOR **********/
	
	public static int ageCalculator(LocalDate dob3) {
		LocalDate today = LocalDate.now();// GETTING TODAY'S DATE
		Period p = Period.between(dob3, today);// FINDING DIFFERENCE BETWEEN TWO DATES
		int age = p.getYears();// GETTING THE YEAR SEPERATELY
		System.out.println("Your age is "+ age);
		return age;
	}
   
	
	/*********** CARD EXPIRE CHECK **********/
	public static void creditcardValidyear(String cardex) {
	
	YearMonth cardexpirydate = YearMonth.parse(cardex);
	YearMonth now=YearMonth.now();
	if (cardexpirydate.isBefore(now)) {
		System.out.println("Card expired");
	}
	else {
		System.out.println("Card is valid");
	}
	

	//ip.close(); // CLOSING SCANNER
	
}
}
