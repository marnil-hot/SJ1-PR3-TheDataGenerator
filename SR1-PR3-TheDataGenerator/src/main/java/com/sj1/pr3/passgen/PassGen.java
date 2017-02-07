package com.sj1.pr3.passgen;

import java.util.Random;

public class PassGen {

	/** Variables for UPPER case, lower case letters, numbers and symbols */
	private static final String UPR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LWR = "abcdefghijklmnopqrstuvwxyz";
	private static final String NBR = "0123456789";
	private static final String SYM = "!@#$%^&*_=+-/";

	
	
	public static char[] genPwd(int minLength, int maxLength, int nbrOfUPR, int nbrOfLWR, int nbrOfNBR, int nbrOfSYM) {
		
		
		
		/** Randomizes a length between minLength and maxLength */
		Random rnd = new Random();
		int length = rnd.nextInt(maxLength - minLength + 1) + minLength;
		int sumChars = (nbrOfUPR + nbrOfLWR + nbrOfNBR + nbrOfSYM);
		char[] passw = new char[length];

		
		
		/** Throws an exception if minLength > maxLength */
		if (minLength > maxLength) {
			throw new IllegalArgumentException("Min length cannot be larger than max.");
		}

		
		
		/** Throws an exception if sumChars > length */
		if ((sumChars) > length) {
			throw new IllegalArgumentException("Enter larger minLength or fewer type of chars to avoid this error."
					+ "\nPassword length = " + length + "\nChar ammount = " + sumChars);
		}

		
		
		/** Function that fills the password with random upper case letters. */
		int index = 0;
		for (int i = 0; i < nbrOfUPR; i++) {
			index = getNextIndex(rnd, length, passw);
			passw[index] = UPR.charAt(rnd.nextInt(UPR.length()));
		}
		/** Function that fills the password with random numbers. */
		for (int i = 0; i < nbrOfNBR; i++) {
			index = getNextIndex(rnd, length, passw);
			passw[index] = NBR.charAt(rnd.nextInt(NBR.length()));
		}
		/** Function that fills the password with random symbols. */
		for (int i = 0; i < nbrOfSYM; i++) {
			index = getNextIndex(rnd, length, passw);
			passw[index] = SYM.charAt(rnd.nextInt(SYM.length()));
		}
		/**
		 * Function that fills the password with random lower case letters.
		 * Lower case letters will fill up the password if password length >
		 * amount of chars
		 */
		for (int i = 0; i < length; i++) {
			if (passw[i] == 0) {
				passw[i] = LWR.charAt(rnd.nextInt(LWR.length()));
			}
		}

		return passw;
	}

	
	
	/**
	 * A static method that takes 3 parameters to return next password index.
	 */
	private static int getNextIndex(Random rnd, int length, char[] passw) {
		int index = rnd.nextInt(length);
		while (passw[index = rnd.nextInt(length)] != 0)
			;
		return index;

	}
}
