package com.cabinvoice_generator_day_30;

import java.util.Scanner;

public class CabService {
	
	float distance;
	float time;
	float totalFare;
	int PRICE_PER_KM = 10;
	int PRICE_PER_MIN = 1;
	int MIN_FARE = 5;
	
    public CabService(float distance, float time) {
		this.distance = distance;
		this.time = time;
	}
    
    public float invoiceGenerator() {
		
    	if(distance < 1) {
    		totalFare = MIN_FARE;
    	}
    	else {
    		
    		totalFare = distance * PRICE_PER_KM + time * PRICE_PER_MIN;
    	}
    	return totalFare;
	}
	public static void main( String[] args ) {
    	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Distance (Km): ");
		float distance = sc.nextFloat();
		System.out.print("Enter the Time (min) : ");
		float time = sc.nextFloat();
		CabService cab = new CabService(distance, time);
    }

	
}
