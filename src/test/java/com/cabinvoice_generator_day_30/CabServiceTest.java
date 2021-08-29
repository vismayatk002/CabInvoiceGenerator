package com.cabinvoice_generator_day_30;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabServiceTest {
	
	CabService service = new CabService();
    @Test
    public void validateInvoiceForOneRideShouldAnswerWithTrue() {
    	
    	ArrayList<Cab> cabList = new  ArrayList<>(); 
    	Cab cabObject = new Cab(1, 2, 10);
    	cabList.add(cabObject);
    	service.invoiceGenerator(cabList);
        Assertions.assertEquals(30, service.getAggregateTotal());
    }
    
    @Test
    public void validateInvoiceForMultipleRidesShouldAnswerWithTrue() {
    	
    	ArrayList<Cab> cabList = new  ArrayList<>(); 
    	Cab cabObject1 = new Cab(1, 2, 10);
    	cabList.add(cabObject1);
    	Cab cabObject2 = new Cab(2, 2, 10);
    	cabList.add(cabObject2);
    	service.invoiceGenerator(cabList);
        Assertions.assertEquals(60, service.getAggregateTotal());
    }  
    
    @Test
    public void validateInvoiceForParticularUserIdShouldAnswerWithTrue() {
    	
    	ArrayList<Cab> cabList = new  ArrayList<>(); 
    	Cab cabObject1 = new Cab(1, 2, 10);
    	cabList.add(cabObject1);
    	Cab cabObject2 = new Cab(2, 2, 10);
    	cabList.add(cabObject2);    	
    	List<Cab> filteredList = service.getUserList(cabList, 1);
		service.invoiceGenerator(filteredList);
    	
        Assertions.assertEquals(30.0, service.getAggregateTotal());
    }  
}
