package com.sj1.pr3.ApplicationUtils;

/**
 * Developed by Kevin Nemec - User Story 10.
 * @author Nesho
 * Having a class with static methods such as checking if a string is a number or not makes it much easier to unit test it and also provides
 * better structure in the code.
 */
public class AppUtils {
	/**
	 * Developed by Kevin Nemec in User Story 5.
	 * Method to check if an input in a input field is a number or not.
	 * @param input the text you want to check if there are only numbers are not.
	 * @return
	 */
	public static boolean isNumber(String input){
		for(int i = 0; i < input.length(); i++){
			if(!Character.isDigit(input.charAt(i))){
				return false;
			}
		}
		return true;
	}
}
