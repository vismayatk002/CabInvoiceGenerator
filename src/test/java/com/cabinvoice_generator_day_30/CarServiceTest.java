package com.cabinvoice_generator_day_30;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CarServiceTest {
    
    @Test
    public void shouldAnswerWithTrue() {
    	
    	CabService cab = new CabService(2,10);
        Assertions.assertEquals(30, cab.invoiceGenerator());
    }
}
