package aplicationTeam2;

import java.util.Random;
/*Created by Marius. User story :5
Creates object of String
Takes integer value from the field "myString" then get text from the this class.
The result will be printed in to myOutput.*/

public class SSpeciallChars {
	
	public String gSpeciallChars(int length){
	
	String names[] = { "!","#","$","%","&","\",","(",")","*","+",",","-",".","/",":",";","<","=",">","?","@","[","\\","]","^","_","`","{","|","}","~"};
	Random MyS = new Random();
	int n = MyS.nextInt(6); 
	System.out.println(names[n]);
	
	return (names[n]);

	}
	
}

		      
	