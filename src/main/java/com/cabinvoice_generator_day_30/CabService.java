package com.cabinvoice_generator_day_30;

import java.util.ArrayList;
import java.util.Scanner;

public class CabService {

	float totalFare;
	int totalRides;
	float avgFarePerRide;
	float aggregateTotal;
	final int PRICE_PER_KM = 10;
	final int PRICE_PER_MIN = 1;
	final int MIN_FARE = 5;
	
	public int getTotalRides() {
    	return totalRides;
    }
	public float getAvgFarePerRide() {
    	return avgFarePerRide;
    }
	public float getAggregateTotal() {
    	return aggregateTotal;
    }

    public void invoiceGenerator(ArrayList<Cab> cabList) {
		
    	this.aggregateTotal = 0;
    	for(Cab object : cabList) {
	    	if(object.distance < 1) {
	    		totalFare = MIN_FARE;
	    	}
	    	else {
	    		
	    		totalFare = object.distance * PRICE_PER_KM + object.time * PRICE_PER_MIN;
	    	}
	    	this.aggregateTotal += totalFare;
    	}
    	this.totalRides = cabList.size();
    	this.avgFarePerRide = aggregateTotal/cabList.size();
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
		
		service.invoiceGenerator(cabList);
		System.out.print("\n----Invoice----");
		System.out.print("\nTotal Number of Rides : " + service.getTotalRides());
		System.out.print("\nAggregate Total : " + service.getAggregateTotal());
		System.out.print("\nAverage Total Fare per Ride : " + service.getAvgFarePerRide());
    }
}
