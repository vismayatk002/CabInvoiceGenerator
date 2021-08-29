package com.cabinvoice_generator_day_30;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabServiceTest {
	
	CabService service = new CabService();
    @Test
    public void validateInvoiceForOneRideShouldAnswerWithTrue() {
    	
    	ArrayList<Ride> cabList = new  ArrayList<>(); 
    	Ride cabObject = new Ride(1, 2, 10, "Normal");
    	cabList.add(cabObject);
    	service.invoiceGenerator(cabList);
        Assertions.assertEquals(30, service.getAggregateTotal());
    }
    
    @Test
    public void validateInvoiceForMultipleRidesShouldAnswerWithTrue() {
    	
    	ArrayList<Ride> cabList = new  ArrayList<>(); 
    	Ride cabObject1 = new Ride(1, 2, 10, "Normal");
    	cabList.add(cabObject1);
    	Ride cabObject2 = new Ride(1, 2, 10, "Premium");
    	cabList.add(cabObject2);
    	service.invoiceGenerator(cabList);
        Assertions.assertEquals(80, service.getAggregateTotal());
    }  
    
    @Test
    public void validateInvoiceForParticularUserIdShouldAnswerWithTrue() {
    	
    	ArrayList<Ride> cabList = new  ArrayList<>(); 
    	Ride cabObject1 = new Ride(1, 2, 10, "Normal");
    	cabList.add(cabObject1);
    	Ride cabObject2 = new Ride(2, 2, 10, "Normal");
    	cabList.add(cabObject2);    	
    	List<Ride> filteredList = service.getUserList(cabList, 1);
		service.invoiceGenerator(filteredList);
    	
        Assertions.assertEquals(30.0, service.getAggregateTotal());
    }  
}
