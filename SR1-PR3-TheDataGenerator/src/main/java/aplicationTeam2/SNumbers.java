package aplicationTeam2;
import java.util.Random;

/*Created by Marius. User story :5
 Creates object of String
 Takes integer value from the field "myString" then get text from the this class.
The result will be printed in to myOutput.*/

public class SNumbers {
	
		public String gNumbers(int length){
		
		String names[] = { "1","2","3","4","5","6","7","8","9","10"};
		Random MyS = new Random();
		int n = MyS.nextInt(6); 
		System.out.println(names[n]);
		
		return (names[n]);

		}
		

}