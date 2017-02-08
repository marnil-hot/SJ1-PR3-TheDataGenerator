package aplicationTeam2;

import java.util.Random;
/*Created by Marius. User story :5
Creates object of String
Takes integer value from the field "myString" then get text from the this class.
The result will be printed in to myOutput.*/


public class SSmallChars {
	
	public String gSmallChars(int length){
	
	String names[] = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	Random MyS = new Random();
	int n = MyS.nextInt(6); 
	System.out.println(names[n]);
	
	return (names[n]);

	}
	
}

		