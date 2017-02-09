package aplicationTeam2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.result.Output;

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
	public static Label answerNr;
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
private void handleButtonAction(ActionEvent event) throws IOException {
    
   
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
			myString.clear();
		
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
  						errorMessage.setText("Please fill in length of a string.");
  						myString.clear();	
  						}
  						else	if (myString.getText().trim().equals("0")) {
  	  						errorMessage.setText("Please fill in length of a string but not zero.");
  	  						myString.clear();
	 	}
	 	else{
	 		try{
	 			
	 			SBigChars randombigChar = new SBigChars();
	 			String resultBigChar=randombigChar.gBigChars(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultBigChar);
	 			myString.clear();
	 			
	 			
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
  						errorMessage.setText("Please fill in length of a string.");
  						myString.clear();	}
  						else	if (myString.getText().trim().equals("0")) {
  	  						errorMessage.setText("Please fill in length of a string but not zero.");
  	  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SNumbers randomNumbers = new SNumbers();
	 			String resultNumbers=randomNumbers.gNumbers(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultNumbers);
	 			myString.clear();
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
  						errorMessage.setText("Please fill in length of a string.");
  						myString.clear();
  						}
  						else	if (myString.getText().trim().equals("0")) {
  	  						errorMessage.setText("Please fill in length of a string but not zero.");
  	  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SSpeciallChars randomSpeciallChar = new SSpeciallChars();
	 			String resultSpeciallChar=randomSpeciallChar.gSpeciallChars(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultSpeciallChar);
	 			myString.clear();
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
  						errorMessage.setText("Please fill in length of a string.");
  						myString.clear();
  					}
						else	if (myString.getText().trim().equals("0")) {
	  						errorMessage.setText("Please fill in length of a string but not zero.");
	  						myString.clear();
	 	}
	 	else{
	 		try{
	 			SSmallChars randomSmallChar = new SSmallChars();
	 			String resultSmallChar=randomSmallChar.gSmallChars(Integer.parseInt(myString.getText()));
	 			myOutput.setText(resultSmallChar);
	 			myString.clear();

	 		}
	 		catch (final NumberFormatException ex) {
				errorMessage.setText("Please fill in a valid number in length of a string.");
				myString.clear();
	 		
	 			}
	 		}
  		}


@FXML
private void handleOutputAction(ActionEvent event) throws IOException {
           
            }
    

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	
}    

}