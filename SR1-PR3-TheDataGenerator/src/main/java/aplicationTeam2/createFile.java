package aplicationTeam2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class createFile {
	
	public static String information;
	public static void printInformation(){
		//Metod för att skapa en fil med texten från TextArean.
		String myString = myOutput.getText();
		information = myString;
		//Kolla om det finns innehåll i textArean
		if(information.isEmpty() || information.length() > 200){
			//Felmeddelanden om man inte skriver in något eller har över 20
			FXController.answerNr.setText("Måste innehålla något och ha max 200 tecken!");
		} else {
			try {
			    BufferedWriter out = new BufferedWriter(new FileWriter("generatedText.txt"));
			    out.write(information);
			    System.out.println("En fil som heter generatedText.txt har genererats!");
			    out.close();
			}
			//Hanterar exception
			catch (IOException e)
			{
			    System.out.println("Exception ");
			}
		}
	}
}
