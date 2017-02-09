package com.sj1.pr3.model;

import java.util.Random;

/* 
 * Developed by Ibrahim Ibrahim. User Story 8_GenerateGibberish
 * This is my module class for GenerateGibberish
 * It contains declarations of variables and an string array that is used to generate random letters and returned as a result variable.  
 */
public class GenerateGibberish {
	
	// declared some variables that will be used later on in my generateGibberish method. 
	String result = "";           
	String s2 = " ";
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + s2;
	Random random = new Random(); 
									
	StringBuilder sb = new StringBuilder(); 

	/*  For loop with an int in parameters. It loops through the array index and generates a random character each time 
	 *  It then save the string to a variable called result, that is called in the controller.
	 * */    
	public String generateGibberish(int length) {

		for (int i = 0; i < length; i++) {     
			sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
			result = sb.toString();      
		}
		return result;               
	}
}
