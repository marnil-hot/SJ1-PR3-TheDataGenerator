package model;

import java.util.Random;

/*
 * Developed by Rrahman Rexhepi - User Story 2.
 * This class will generate testing data.
 * Generates: Numbers,Big/small chars and special chars.
 * */

public class GenerateTestData {
	String result;
	int category;
	int indexOfRandom;
	
	// Add Alphabet & number list.
	char[] alphabetSmall = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	char[] alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	char[] numberList = "0123456789".toCharArray();
	char[] specialCharList = "¹´/®¡½¿?º|`{^¶@!·©`&¥%¼»+>ª»²µ¬=¡£º_¤¼".toCharArray();
	
	// Genrate Random number from min-max, and return value.
		public  int getRandomNumber(int min, int max) {
			Random r = new Random();
			return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

		}
	
	public String generateTestData(long size ,boolean specialChars, boolean numbers, boolean smallChars, boolean bigChars) {
		return result;
		
	}
	
	
}
