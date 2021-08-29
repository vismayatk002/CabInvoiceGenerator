package com.cabinvoice_generator_day_30;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabServiceTest {
	
	CabService service = new CabService();
    @Test
    public void validateInvoiceForOneRideShouldAnswerWithTrue() {
    	
    	ArrayList<Cab> cabList = new  ArrayList<>(); 
    	Cab cabObject = new Cab(2, 10);
    	cabList.add(cabObject);
    	service.invoiceGenerator(cabList);
        Assertions.assertEquals(30, service.getAggregateTotal());
    }
    
    @Test
    public void validateInvoiceForMultipleRidesShouldAnswerWithTrue() {
    	
    	ArrayList<Cab> cabList = new  ArrayList<>(); 
    	Cab cabObject1 = new Cab(2, 10);
    	cabList.add(cabObject1);
    	Cab cabObject2 = new Cab(2, 10);
    	cabList.add(cabObject2);
    	service.invoiceGenerator(cabList);
        Assertions.assertEquals(60, service.getAggregateTotal());
    }  
}
