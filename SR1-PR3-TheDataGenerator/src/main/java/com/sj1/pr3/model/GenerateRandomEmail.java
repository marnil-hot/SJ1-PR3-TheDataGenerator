package com.sj1.pr3.model;

import java.util.Random;

public class GenerateRandomEmail {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
	
		public String generateRandomEmail(int length) {
			
		    StringBuilder buffer = new StringBuilder(length);
		   
		    for (int i = 0; i <= length; i++) {
		    	
		        int randomLimitedInt = leftLimit + (int) 
		          (new Random().nextFloat() * (rightLimit - leftLimit));
		        buffer.append((char) randomLimitedInt);
		    }
		    
		    String generatedString = buffer.toString();
		    
		    return generatedString;
		}
		
	}

