package com.cabinvoice_generator_day_30;

import java.util.Scanner;

public class CabService {
	
	float distance;
	float time;
	float totalFare;
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
    		
    		totalFare = distance * 10 + time * 1;
    	}
    	return totalFare;
	}
	public static void main( String[] args ) {
    	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Distance (Km): ");
		System.out.println("Enter the Time (min) : ");
		CabService cab = new CabService(2,10);
    }

	
}
