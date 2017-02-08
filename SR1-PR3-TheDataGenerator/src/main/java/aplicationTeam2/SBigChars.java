package aplicationTeam2;

import java.util.Random;

/*Created by Marius. User story :5
Creates object of String
Takes integer value from the field "myString" then get text from the this class.
The result will be printed in to myOutput.*/



public class SBigChars {
	
	public String gBigChars(int length){
	
	String names[] = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	Random MyS = new Random();
	int n = MyS.nextInt(6); 
	System.out.println(names[n]);
	
	return (names[n]);

	}
	
}
