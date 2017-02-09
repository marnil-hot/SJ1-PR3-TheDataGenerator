package aplicationTeam2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


			
public class FXController implements Initializable {
	
    @FXML
    private Label answerNr;
    @FXML
    private Button mySavetofile;
    @FXML
    private RadioButton myNumbers;
    @FXML
    private RadioButton mySpecialChars;
    @FXML
    private RadioButton mySmallChars;
    @FXML
    private RadioButton myBigChars;
     @FXML
    private TextField myString;
     @FXML
     private TextArea myOutput;
    @FXML
    private TextField myRows;
    @FXML
    private TextField myColumns;
    @FXML
    private Button myGenerateExcel;
    @FXML
    private Button myFeach;
    @FXML
    private Button mySave;
    @FXML
    private TextField myHeight;
    @FXML
    private TextField myWidth;
    @FXML
    private Button myCreateImage;
    @FXML
    private ColorPicker myColor;
    @FXML
    private Button gibbutton;
	  @FXML
	  private Label errorMessage;
	  @FXML
	  private Button Generate;

 
 
 
    


@FXML
private void handleButtonAction(ActionEvent event) throws IOException {
    
   
}


@FXML
private void handleTextFieldanswerAction(ActionEvent event) {
	if (myString.getText().trim().equals("")) {
		errorMessage.setText("Please fill in length of a string.");
		myString.clear();
		}
	else{
	answerNr.setText("Your number is:  " + myString.getText());
	myString.clear();
	}


}

/*
 * Created by Namir Wesaf. User story : 8 Generate gibberish words.
 * Creates object of GibberishGenerator.
 * Takes integer value from the field "myString" then get text from the gibberishGenerator class.
 * The result will be printed in to myOutput.
 */
@FXML
void gibberishEvent(ActionEvent event) {
	errorMessage.setText("");
	
	if (myString.getText().trim().equals("")) {
		errorMessage.setText("Please fill in length of a string.");
		myString.clear();
	}  else {
		// Error handeling if the input is a integer.
		try {
			GibberishGenerator gibberishGenerator = new GibberishGenerator();
			String result = gibberishGenerator.generateRandomWords(Integer.parseInt(myString.getText()));
			myOutput.setText(result);
		} catch (final NumberFormatException ex) {
			errorMessage.setText("Please fill in a valid number in length of a string.");
			myString.clear();
		}
	}
	
	
}
/**Created by Marius. User story :5
Creates object of String
Takes integer value from the field "myString" then get text from the this class.
The result will be printed in to myOutput.
 */

  		@FXML
		private void handleBigCharRadioButtonAction(ActionEvent event) {
  					errorMessage.setText("");
  				
  					if (myString.getText().trim().equals("")) {
  						answerNr.setText("Please fill in length of a string.");
  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SBigChars randombigChar = new SBigChars();
	 			String resultBigChar=randombigChar.gBigChars(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultBigChar);
	 		}
	 		catch (final NumberFormatException ex) {
				errorMessage.setText("Please fill in a valid number in length of a string.");
				myString.clear();
	 		
	 			}
	 		}
  		}
  		
  		/**Created by Marius. User story :5
  		Creates object of String
  		Takes integer value from the field "myString" then get text from the this class.
  		The result will be printed in to myOutput.*/
  		@FXML
		private void handleNumbersRadioButtonAction(ActionEvent event) {
  					errorMessage.setText("");
  				
  					if (myString.getText().trim().equals("")) {
  						answerNr.setText("Please fill in length of a string.");
  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SNumbers randomNumbers = new SNumbers();
	 			String resultNumbers=randomNumbers.gNumbers(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultNumbers);
	 		}
	 		catch (final NumberFormatException ex) {
				errorMessage.setText("Please fill in a valid number in length of a string.");
				myString.clear();
	 		
	 			}
	 		}
  		}
  		/**Created by Marius. User story :5
  		Creates object of String
  		Takes integer value from the field "myString" then get text from the this class.
  		The result will be printed in to myOutput.*/
  		@FXML
		private void handleSpeciallCharRadioButtonAction(ActionEvent event) {
  					errorMessage.setText("");
  				
  					if (myString.getText().trim().equals("")) {
  						answerNr.setText("Please fill in length of a string.");
  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SSpeciallChars randomSpeciallChar = new SSpeciallChars();
	 			String resultSpeciallChar=randomSpeciallChar.gSpeciallChars(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultSpeciallChar);
	 		}
	 		catch (final NumberFormatException ex) {
				errorMessage.setText("Please fill in a valid number in length of a string.");
				myString.clear();
	 		
	 			}
	 		}
  		}
  		/**Created by Marius. User story :5
  		Creates object of String
  		Takes integer value from the field "myString" then get text from the this class.
  		The result will be printed in to myOutput.*/
  		
  		
  		@FXML
		private void handleSmallCharRadioButtonAction(ActionEvent event) {
  					errorMessage.setText("");
  				
  					if (myString.getText().trim().equals("")) {
  						answerNr.setText("Please fill in length of a string.");
  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SSmallChars randomSmallChar = new SSmallChars();
	 			String resultSmallChar=randomSmallChar.gSmallChars(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultSmallChar);
	 		}
	 		catch (final NumberFormatException ex) {
				errorMessage.setText("Please fill in a valid number in length of a string.");
				myString.clear();
	 		
	 			}
	 		}
  		}



/* Developed by Marius in User Story .
Method to fill a number for how many times you wish to generate the String and to show in output 
@FXML
private void handleTextFieldanswerAction(ActionEvent event) {
    //System.out.println("Done");
	 if (answerNr!= null && myString != null) {
    answerNr.setText("Your number is:  "+myString.getText());
   // myOutput.setText(myString.getText());
    myOutput.setText(RandomStringLenght.repeat((Integer.parseInt(myString.getText())), "c"));
	 }
	 else{
		 answerNr.setText("Write a number.");
	 }
   
}*/

/* Developed by Marius in User Story .
 Method which save to a file */

@FXML
private void handleOutputAction(ActionEvent event) throws IOException {
	//Metod för att skapa en fil med texten från TextArean.
	//information = myOutput.getText();
	//Kolla om det finns innehåll i textArean
	if(myOutput.getText().isEmpty() || myOutput.getText().length() > 200){
		//Felmeddelanden om man inte skriver in något eller har över 20
		errorMessage.setText("Must have a minimum of 1 character and a maximum of 200!");
	} else {
		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter("generatedText.txt"));
		    out.write(myOutput.getText());
		    System.out.println("En fil som heter generatedText.txt har genererats!");
		    //Reset the textarea
		    myOutput.setText("");
		    out.close();
		}
		//Hanterar exception
		catch (IOException e)
		{
		    System.out.println("Exception ");
		}
	}
}
    

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	
}    

}