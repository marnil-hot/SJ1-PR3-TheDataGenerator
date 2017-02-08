package com.sj1.pr3.model;

import java.util.Random;

public class GenerateGibberish {
	
	String result = "";
	String s2 = " ";
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + s2;
	Random random = new Random(); 
									
	StringBuilder sb = new StringBuilder();

	public String generateGibberish(int length) {

		for (int i = 0; i < length; i++) { /* */
			sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
			result = sb.toString();
		}
		System.out.println(result);
		return result;
	}
}
