package com.sj1.pr3.datagenerator;

import java.util.Random;

/**
 * Developed by Nahal Arabian (User Story 3)
 * 
 * @author Nahal
 * 
 * This class takes length of the  mail address from the GUI,
 *  creates a random mail address according it 
 *  and then return it
 * 
 */
public class RandomMailGenerator {

	public static String randomMail(int inputLenght) {

		// created string consists of alphabet numbers and special characters
		String alphanum = "abcdefghijklmnopqrstuvwxyz0123456789#!$%&'*+-/=?^_`{}|~";
		String special = "#!$%&'*+-/=?^_`{}|~";

		Random rand = new Random();
		StringBuilder sb = new StringBuilder();

		while (sb.length() < inputLenght) {
			// Create randomly string
			sb.append(alphanum.charAt(rand.nextInt(alphanum.length())));
		}

		// Add dot to the mail address so that after '.' comes randomly 2 or 3 letters
		sb.setCharAt(sb.length() - (rand.nextInt(5 - 3) + 3), '.');

		for (int i = 1; i < sb.length() - 2; i++) {
			if (sb.charAt(i) == '.') {
				// @ is randomly between position 1 and position ('.') - 1
				sb.setCharAt(rand.nextInt((i - 1) - 1) + 1, '@');
			}
		}

		// This is not allowed speciall charactar lies between @ and point
		for (int i = sb.indexOf("@") + 1; i < sb.length(); i++) {
			for (int j = 0; j < special.length(); j++) {
				if (sb.charAt(i) == special.charAt(j)) {

					sb.setCharAt(i, alphanum.charAt(rand.nextInt(alphanum.length() - special.length())));
				}
			}
		}

		return sb.toString();

	}
}
