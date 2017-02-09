package aplicationTeam2;

import java.util.Random;
/*Created by Marius. User story :5
Creates object of String
Takes integer value from the field "myString" then get text from the this class.
The result will be printed in to myOutput.*/


public class SSmallChars {
	private static final String CHAR_LIST =
	        "abcdefghijklmnopqrstuvwxyz";
	public String gSmallChars(int length){
		 StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<length; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	
	public int getRandomNumber() {
     int randomInt = 0;
     Random randomGenerator = new Random();
     randomInt = randomGenerator.nextInt(CHAR_LIST.length());
     if (randomInt - 1 == -1) {
         return randomInt;
     } else {
         return randomInt - 1;
     }
 }
	

}		