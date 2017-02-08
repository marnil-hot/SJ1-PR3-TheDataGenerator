package com.sj1.pr3.model;


import java.util.Random;

/*
 * Developed by Rrahman Rexhepi - User Story 2.
 * This class will generate testing data.
 * Generates: Numbers,Big/small chars and special chars.
 * */

public class GenerateTestData {
	String result = "";
	int category;
	int indexOfRandom;

	// Alphabet & number list.
	char[] alphabetSmall = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	char[] alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	char[] numberList = "0123456789".toCharArray();
	char[] specialCharList = "¹´/®¡½¿?º|`{^¶@!·©`&¥%¼»+>ª»²µ¬=¡£º_¤¼".toCharArray();

	// Genrate Random number from min-max, and return value.
	public int getRandomNumber(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

	}

	public String generateTestData(long size, boolean specialChars, boolean numbers, boolean smallChars,
			boolean bigChars) {
		for (int i = 0; i < size; i++) {

			// Generate random number, that selects one of the checkBoxes
			// alternatives.
			category = getRandomNumber(0, 3);

			if (category == 0 && specialChars == true) {
				// Get Random index of specialCharList.
				indexOfRandom = getRandomNumber(0, specialCharList.length - 1);
				result = result + "" + specialCharList[indexOfRandom];

			} else if (category == 1 && numbers == true) {
				// Get Random index of numberList.
				indexOfRandom = getRandomNumber(0, numberList.length - 1);
				result = result + "" + numberList[indexOfRandom];

			} else if (category == 2 && smallChars == true) {
				// Get Random index of alphabetSmall
				indexOfRandom = getRandomNumber(0, alphabetSmall.length - 1);
				result = result + "" + alphabetSmall[indexOfRandom];

			} else if (category == 3 && bigChars == true) {
				// Get Random index of specialCharList
				indexOfRandom = getRandomNumber(0, alphabetBig.length - 1);
				result = result + "" + alphabetBig[indexOfRandom];

			} else {
				// When the loop cant select one of the alternatives because
				// something happend do it again.
				i -= 1;
			}

		}

		return result;

	}

}
