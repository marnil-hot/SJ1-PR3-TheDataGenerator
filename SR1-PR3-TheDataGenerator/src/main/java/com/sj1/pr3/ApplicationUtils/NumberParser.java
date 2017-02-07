package com.sj1.pr3.ApplicationUtils;


/*
 * ErrorHandeling for NumberFormatExcepion.
 * Made by Rrahman Rexhepi.
 * Pars the input and returns true or false if it succeed or not.
 * */

public class NumberParser {
	
	// Long
	public static  boolean parseLong(final  String s1 ) {
		try {
		       Long.parseLong(s1);
		       return true;
		       
		    } catch (final NumberFormatException ex) {
		    	return false;
		    }
		}
	
	// Double
	public static  boolean parseDouble(final  String s1 ) {
		try {
		       Double.parseDouble(s1);
		       return true;
		       
		    } catch (final NumberFormatException ex) {
		    	return false;
		    }
		}
	
	// Integer
	public static  boolean parseInteger(final  String s1 ) {
		try {
		       Integer.parseInt(s1);
		       return true;
		       
		    } catch (final NumberFormatException ex) {
		    	return false;
		    }
		}
}
