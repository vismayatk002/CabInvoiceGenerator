package com.cabinvoice_generator_day_30;

public class Ride {
	
	int userId;
	float distance;
	float time;
	String rideType;
	
    public Ride(int userId, float distance, float time, String rideType) {
    	this.userId = userId;
		this.distance = distance;
		this.time = time;
		this.rideType = rideType;
	}
    public int getUserId() {
    	return userId;
    }
}
