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

@SuppressWarnings("static-access")
@FXML
private void handleTextFieldanswerAction(ActionEvent event) {
	System.out.println("Done");
	answerNr.setText("Your number is:  " + myString.getText());
	// RandomStringLenghtBigChars.generateRandom(myString.getAnchor());
	RandomStringLenghtBigChars myrandom = new RandomStringLenghtBigChars();
	myrandom.generateRandom(myString.getLength());
	// myOutput.textProperty().bind(myrandom.generateRandom(8));
	System.out.println(myrandom);

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
            if (myString!= null && myOutput != null) {
                 try (PrintWriter result = new PrintWriter(new BufferedWriter(new FileWriter("  /Users/mariusilie/Desktop/document.pages", true))))
                 {
                    if (myString.getText().equals("")) {
                     answerNr.setText("Nummer behöver");
                     return; 
                    } 
                    else{
                    result.println("You chose the number: " + myString.getText() + " " + "That will generate: " + myOutput.getText());   
                        answerNr.setText(" Klart");
                        myString.clear(); 
                        System.out.println("Done Writing"); 
                    }
                    } 
                 	catch (IOException ex) {
                      answerNr.setText("Fel har uppstått ");     
                    	}
            }       
            		else  {                     
                    answerNr.setText("Göra om.");
            		}
            }
          


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	
}    

}