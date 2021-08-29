package com.cabinvoice_generator_day_30;

import java.util.ArrayList;
import java.util.Scanner;

public class CabService {
	
	float distance;
	float time;
	float totalFare;
	int PRICE_PER_KM = 10;
	int PRICE_PER_MIN = 1;
	int MIN_FARE = 5;
	
    public float invoiceGenerator(ArrayList<Cab> cabList) {
		
    	float aggregateTotal = 0;
    	for(Cab object : cabList) {
	    	if(object.distance < 1) {
	    		totalFare = MIN_FARE;
	    	}
	    	else {
	    		
	    		totalFare = object.distance * PRICE_PER_KM + object.time * PRICE_PER_MIN;
	    	}
	    	aggregateTotal += totalFare;
    	}
    	return aggregateTotal;
	}
	public static void main( String[] args ) {
    	
		ArrayList<Cab> cabList = new  ArrayList<>();
		CabService service = new CabService();
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.print("Enter the Distance (Km): ");
			float distance = sc.nextFloat();
			System.out.print("Enter the Time (min) : ");
			float time = sc.nextFloat();
			Cab cabObject = new Cab(distance,time);
			cabList.add(cabObject);
			System.out.print("Do you want to continue press 1:");
			option = sc.nextInt();
			
		}while(option == 1);
		
		System.out.print("\n\n----Invoice----");
		System.out.print("\nAggregate Total : " + service.invoiceGenerator(cabList));
    }
}
