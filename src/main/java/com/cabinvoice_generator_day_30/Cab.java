package com.cabinvoice_generator_day_30;

public class Cab {
	
	int userId;
	float distance;
	float time;
	
    public Cab(int userId, float distance, float time) {
    	this.userId = userId;
		this.distance = distance;
		this.time = time;
	}
    public int getUserId() {
    	return userId;
    }
}
