package com.cabinvoice_generator_day_30;

import java.util.ArrayList;
import java.util.stream.Collectors;  
import java.util.List;
import java.util.Scanner;

public class CabService {

	float totalFare;
	int totalRides;
	float avgFarePerRide;
	float aggregateTotal;
	final int NOR_PRICE_PER_KM = 10;
	final int NOR_PRICE_PER_MIN = 1;
	final int NOR_MIN_FARE = 5;
	final int PRE_PRICE_PER_KM = 15;
	final int PRE_PRICE_PER_MIN = 2;
	final int PRE_MIN_FARE = 20;
	
	public int getTotalRides() {
    	return totalRides;
    }
	public float getAvgFarePerRide() {
    	return avgFarePerRide;
    }
	public float getAggregateTotal() {
    	return aggregateTotal;
    }
	
    public void invoiceGenerator(List<Ride> cabList) {
		
    	int minFare;
    	int pricePerKm;
    	int pricePerMin;
    	
    	this.aggregateTotal = 0;
    	for(Ride object : cabList) {
    		
    		if(object.rideType.equals("Normal")) {
				 minFare = NOR_MIN_FARE;
		    	 pricePerKm = NOR_PRICE_PER_KM;
		    	 pricePerMin = NOR_PRICE_PER_MIN;
    		}
    		else {
    			minFare = PRE_MIN_FARE;
   	    	 	pricePerKm = PRE_PRICE_PER_KM;
   	    	 	pricePerMin = PRE_PRICE_PER_MIN;
    		}
	    	if(object.distance < 1) {
	    		totalFare = minFare;
	    	}
	    	else {
	    		totalFare = object.distance * pricePerKm + object.time * pricePerMin;
	    	}
	    	this.aggregateTotal += totalFare;
    	}
    	this.totalRides = cabList.size();
    	this.avgFarePerRide = aggregateTotal/cabList.size();
	}
    
    public List<Ride> getUserList(List<Ride> cabList, int searchUserId){
    	List<Ride> userList =  cabList.stream()  
                .filter(cabObject -> cabObject.getUserId() == searchUserId)   
                .collect(Collectors.toList()); 
    	return userList;
    }
    
  	public static void main( String[] args ) {
    	
		List<Ride> cabList = new  ArrayList<>();
		CabService service = new CabService();
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.print("\nEnter Ride Type (Normal or Premium): ");
			String rideType = sc.nextLine();
			System.out.print("Enter the UserId: ");
			int userId = sc.nextInt();
			System.out.print("Enter the Distance (Km): ");
			float distance = sc.nextFloat();
			System.out.print("Enter the Time (min) : ");
			float time = sc.nextFloat();
			Ride cabObject = new Ride(userId, distance, time, rideType);
			cabList.add(cabObject);
			System.out.print("Do you want to continue press 1:");
			option = sc.nextInt();
			sc.nextLine();
			
		}while(option == 1);
		
		System.out.print("Enter the UserId to generate Invoice : ");
		int searchUserId = sc.nextInt();
		List<Ride> filteredList = service.getUserList(cabList, searchUserId);
		service.invoiceGenerator(filteredList);
		
		System.out.print("\n----Invoice----");
		System.out.print("\nTotal Number of Rides : " + service.getTotalRides());
		System.out.print("\nAggregate Total : " + service.getAggregateTotal());
		System.out.print("\nAverage Total Fare per Ride : " + service.getAvgFarePerRide());
    }
}
