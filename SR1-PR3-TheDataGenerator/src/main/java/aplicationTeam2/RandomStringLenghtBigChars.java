package aplicationTeam2;

import java.util.Random;

public class RandomStringLenghtBigChars {
	public static String generateRandom(int length){
		String alphabet = 
		        new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); 
		int n = alphabet.length(); 

		String result = new String(); 
		Random r = new Random(); 

		for (int i=0; i<length; i++) 
		    result = result + alphabet.charAt(r.nextInt(n)); 

		return result;
		}


}
