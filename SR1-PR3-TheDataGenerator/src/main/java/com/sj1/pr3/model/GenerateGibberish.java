package com.sj1.pr3.model;

import java.util.Random;

public class GenerateGibberish {
	
	// declared some variables that will be used later on in my generateGibberish method. 
	String result = "";           
	String s2 = " ";
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + s2;
	Random random = new Random(); 
									
	StringBuilder sb = new StringBuilder(); // declared my stringbuilder beforehand

	public String generateGibberish(int length) {

		for (int i = 0; i < length; i++) { /*  For loop with an int in parameters. It loops through the array index and generates a random character each time */        
			sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
			result = sb.toString();      // result saved to a variable and formated to String
		}
		System.out.println(result);  // prints out the result in the console
		return result;               // the method returns the result
	}
}
