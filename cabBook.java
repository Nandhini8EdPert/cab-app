package com.nandhini;
import java.util.*;
import java.time.*;

public class cabBook {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		/******** LEVEL 1 ********/
		
		 ShortModules.userId();
		 ShortModules.pwd();
		
		/****** GETTING DATE FOR PICKUP *****/
		System.out.println("Enter date of your journey: ");
	    String datestr =ip.next();
		LocalDate bdate = LocalDate.parse(datestr);
		ShortModules.dateChecking(bdate);
		
		/****** GETTING TIME FOR PICKUP *****/
		System.out.println("Enter your travel timing(hh:mm:ss): ");
		String btime = ip.next();
		LocalTime bookingtime = LocalTime.parse(btime);
		int h = bookingtime.getHour(); // GETTING HOUR SEPERATELY FROM A TIME STAMP
		
		/******* CAB TYPES AVAILABLE ********/
		System.out.println("Cab types Available");
		System.out.println("1.Mini -- Rs 10 per Km");
		System.out.println("2.Macro -- Rs 15 per Km");
		System.out.println("3.Prime -- Rs 20 per Km");

		/******* FOR NORMAL HOURS *******/
		System.out.println("Enter your mode of travel you wish either 1 or 2 or 3");
		int wish = ip.nextInt();
		System.out.println("Enter the number of Kms you wanted to travel");
		int kms = ip.nextInt();
		double z=0;
		double gst=0;
			switch (wish) {
			case 1: {z = kms * 10;// CALCULATING RS FOR CERTAIN Km
				     gst = z + (z * 0.07);// ADDING 7% GST TO BILL AMOUNT
				     break;}
			case 2: {z = kms * 15;
				     gst = z + (z * 0.07);
			        	break;}
			case 3: {z = kms * 20;
			        gst = z + (z * 0.07);
			    	break;}
			default:System.out.println("Kindly refresh and Try Again");
			}
			
			
		/******* CHECKING FOR PEAK HOURS *******/
		double amt=0;
		if(h >= 17 && h <= 19) {
			amt=gst + (gst * 0.0125);
			System.out.println("Your travel charge estimate is " + z);
			System.out.println("Your travel charge estimate with GST is " + gst);
			System.out.println("Your travel charge estimate with GST and peak hours charge is "+amt);
		}
		else {
			amt=gst;
			System.out.println("Your travel charge estimate is " + z);
			System.out.println("Your travel charge estimate with GST is " + amt);
		}
		
		
		/******* GETTING DATE OF BIRTH *******/
		System.out.println("Enter your date of birth(yyyy-mm-dd): ");
		String dob = ip.next(); // GETTING DATE OF BIRTH
		LocalDate dob3 = LocalDate.parse(dob);// STRING INTO DATE FORMAT
		
		
		/******* CALCULATING AGE *******/
		int age = ShortModules.ageCalculator(dob3);
		 ShortModules.seniorcitizenDiscount( amt, age);

		
		 /******* BOOKING CONFIRMATION *******/
		System.out.println("Your journey confirmed on " + bdate + " in " + bookingtime);
		
		
		/******* CARD EXPIRY CHECK *******/
		System.out.println("Enter your card Expiry date(yyyy-mm): ");
		String cardex = ip.next();
		ShortModules.creditcardValidyear(cardex);
		System.out.println("Thank you for visiting");
		System.out.println("Have a bliss!!");
		ip.close();
	}
}