package com.sj1.pr3.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import com.sj1.pr3.model.GenerateGibberish;

import com.sj1.pr3.ApplicationUtils.AppUtils;
import com.sj1.pr3.ApplicationUtils.NumberParser;
import com.sj1.pr3.model.GenerateRandomEmail;

import javafx.application.Platform;

import com.sj1.pr3.model.PNGCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Optional;
import java.util.ResourceBundle;
import com.sj1.pr3.ApplicationUtils.NumberParser;
import com.sj1.pr3.model.GenerateTestData;
import com.sj1.pr3.model.SaveFileText;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TestVerktygController implements Initializable {

	@FXML
	private TextArea outPutArea;

	@FXML
	private TextField lengthFld;

	@FXML
	private TextField delimiterFld;

	@FXML
	private TextField witdhColorFld;

	@FXML
	private TextField heightColorFld;

	@FXML
	private TextField excelColumnsFld;

	@FXML
	private TextField excelRowsFld;

	@FXML
	private TextField dataBaseFld;

	@FXML
	private Label errorLabel;

	@FXML
	private Button saveToFileBtn;

	@FXML
	private Button generateRandomBtn;

	@FXML
	private Button generateExcelBtn;

	@FXML
	private Button generateEmailBtn;

	@FXML
	private Button fetchDbBtn;

	@FXML
	private Button generateImgBtn;

	@FXML
	private Button counterStringBtn;

	@FXML
	private CheckBox checkBoxLetters;

	@FXML
	private CheckBox checkBoxNumbers;

	@FXML
	private CheckBox checkBoxSpecialchars;

	@FXML
	private CheckBox checkBoxSmallcharacters;

	@FXML
	private CheckBox checkBoxBigchars;

	@FXML
	private ComboBox<String> colorsComboBox;

	@FXML
	private ComboBox<String> excelComboBox;

	@FXML
	private ComboBox<String> dataBaseComboBox;


	
	/**
	 * Developed by Hampus Bohlin in User Story 3. This is a method that checks
	 * if the string you put in the "length of string" have the right length 
	 * and characters.
	 * @param event is the length of the string
	 */
	
	@FXML
	void generateEmailEvent(ActionEvent event) {
		errorLabel.setText("");
		if (lengthFld.getText().trim().equals("")) {
			errorLabel.setText("Pleace fill in a length before generating");
		} else if (!NumberParser.parseInteger(lengthFld.getText())) {
			errorLabel.setText("Please fill in only numbers ");
		} else {

			int stringLength = Integer.valueOf(lengthFld.getText());

			if (stringLength <= 5) {
				errorLabel.setText("Email standard is minimum 6 characters");
			} else if (stringLength >= 320) {
				errorLabel.setText("Email Standard is maximum 319 characters");
			} else {
				GenerateRandomEmail generateEmail = new GenerateRandomEmail();
				String emailAddress = generateEmail.generateRandomEmail(stringLength);
				outPutArea.setText(emailAddress);

			}

		}

	}

	/**
	 * Developed by Kevin Nemec in User Story 5. Method which generates a
	 * CounterString based on the parameters.
	 * 
	 * @param value the value you want to generate the CounterString from
	 * @param delimiter
	 *            which character you want between each character.
	 * @return the CounterString
	 */
	public static String generateCounterString(long length, String delimiter) {
		long currentNumber = length;
		int outLen = 0;
		List<String> numbers = new ArrayList<String>();
		String currentString = null;
		String counterString = "";

		while (outLen < length) {
			currentString = currentNumber + delimiter;
			currentNumber -= currentString.length();

			if (outLen + currentString.length() <= length) {
				numbers.add(currentString);
				outLen += currentString.length();
			} else {
				numbers.add(delimiter);
				break;
			}
		}

		Collections.reverse(numbers);
		for (String s : numbers) {
			counterString += s;
		}

		return counterString;
	}

	/**
	 * Developed by Kevin Nemec in User Story 5. Some error handling to check
	 * input values in all the input fields connected to this method. Also
	 * updating the UI in a separate thread to not block the UI and cause a
	 * spike when handling big calculations.
	 */
	@FXML
	private void getCounterString() {
		final long length;
		if (lengthFld.getText().equals("") && delimiterFld.getText().equals("")) {
			errorLabel.setText("");
			errorLabel.setText("Length and Delimiter must be specified");
		} else if (lengthFld.getText().equals("") || !AppUtils.isNumber(lengthFld.getText())) {
			if (lengthFld.getText().equals("")) {
				errorLabel.setText("");
				errorLabel.setText("Length can not be empty");
			} else {
				errorLabel.setText("");
				;
				errorLabel.setText("Length must be a number");
			}
		} else if (delimiterFld.getText().length() > 1 || delimiterFld.getText().length() == 0
				|| AppUtils.isNumber(delimiterFld.getText())) {
			if (delimiterFld.getText().length() > 1) {
				errorLabel.setText("Delimiter must be max 1 character");
			} else if (delimiterFld.getText().length() == 0) {
				errorLabel.setText("Delimiter must be 1 character");
			} else {
				errorLabel.setText("Delimiter can not be a number");
			}
		} else {
			length = Long.parseLong(lengthFld.getText());
			Platform.runLater(new Runnable() {
				public void run() {
					errorLabel.setText("");
					outPutArea.setText(generateCounterString(length, delimiterFld.getText()));
					outPutLengthLable.setText("");
				}
			});
		}
	}

  
  @FXML
	private Label outPutLengthLable;
  	String result = "";


	/*
	 * Developed by Rrahman Rexhepi - User Story 2.
	 * @GenerateRandomStrings = When user clicks on "Generate random string" button.
	 * Error handling also warning if the amount is to high that will make the application freeze.
	 * After every thing is good,  it calls on the method : @startGenerate.
	 * @NumberParser is used as a extra check if the input is correct or not.
	 */
	@FXML
	void generateRandomStrings(ActionEvent event) {
		errorLabel.setText("");
		GenerateTestData generateData = new GenerateTestData();
		// Error Handeling
		if (lengthFld.getText().trim().equals("")) {
			errorLabel.setText("Please fill in a length before generating. ");
			lengthFld.clear();
		} else if (!NumberParser.parseLong(lengthFld.getText())) {
			errorLabel.setText("Please fill in only numbers in Length of string field.");
			lengthFld.clear();

		} else if (!checkBoxBigchars.isSelected() && (!checkBoxNumbers.isSelected()
				&& (!checkBoxSmallcharacters.isSelected() && (!checkBoxSpecialchars.isSelected())))) {
			errorLabel.setText("Please select one of the alternatives in the checkboxes.");
		} else {

			if (Long.valueOf(lengthFld.getText()) >= 70000) {
				// Alert dialog.
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Team4-Testverktyg  Generate Data.");
				alert.setHeaderText("Generating huge amount of test data!");
				alert.setContentText("Are you sure you want to generate this huge amount of test data?\nThe application have to generate for a long time!");
				ButtonType buttonConfirm = new ButtonType("Confirm");
				ButtonType cancelConfirm = new ButtonType("Cancel");
				alert.getButtonTypes().setAll(buttonConfirm, cancelConfirm); 
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonConfirm) {
					// Update GUI
					startGenerate();
				} else {
					// Cancel pressed do nothing.
				}

			} else {
				startGenerate();
			}

		}
	}
	
	/*
	 * Developed by Rrahman Rexhepi - User Story 2.
	 * @GenerateTestData , takes long value, that is how many chars the generator will generate.
	 * It also takes all the checkBox values. After its done it sends back the result and prints it out to
	 * the outPutArea.
	 * */
	public void startGenerate() {
		GenerateTestData generateData = new GenerateTestData();
		String result = generateData.generateTestData(Long.valueOf(lengthFld.getText()),
				checkBoxSpecialchars.isSelected(), checkBoxNumbers.isSelected(),
				checkBoxSmallcharacters.isSelected(), checkBoxBigchars.isSelected());
		outPutArea.setText(result);
		outPutLengthLable.setText("Length: " + outPutArea.getLength() + " characters.");
	}
	
	/**
	 * Developed by Kevin Nemec in User Story 10 and Edited/Extended by Kevin Nemec in User Story 11.
	 * Method is executed when the click event for the button to create a new image fires. Input handling and method invoking below.
	 * @param event makes it visible for the FXML file.
	 */
	@FXML
	private void generateImage(ActionEvent event){
		Stage stage = (Stage)this.errorLabel.getScene().getWindow();
		
		if(witdhColorFld.getText().length() == 0 && heightColorFld.getText().length() == 0 && colorsComboBox.getValue() == null){
			errorLabel.setText("You must specify width, height and color");
		}
    
		else if(witdhColorFld.getText().length() == 0 || !AppUtils.isNumber(witdhColorFld.getText())){
			if(witdhColorFld.getText().length() == 0){
				errorLabel.setText("You must specify a width");
			}
			else{
				errorLabel.setText("Width must be a number or a non-decimal value");
			}
		}
		
		else if(heightColorFld.getText().length() == 0 || !AppUtils.isNumber(heightColorFld.getText())){
			if(heightColorFld.getText().length() == 0){
				errorLabel.setText("You must specify a height");
			}
			else{
				errorLabel.setText("Height must be a number or a non-decimal value");
			}
		}
		
		else if(colorsComboBox.getValue() == null){
			errorLabel.setText("You must select a color");
		}
		
		else{
			if (Integer.parseInt(witdhColorFld.getText()) > 1920 || !AppUtils.isInteger(witdhColorFld.getText())) {
				if(Integer.parseInt(witdhColorFld.getText()) > 1920){
					errorLabel.setText("Width can not exceed 1920");
				}
				else{
					errorLabel.setText("Width can not contain decimal numbers");
				}
			}
			
			else if (Integer.parseInt(witdhColorFld.getText()) < 1) {
				errorLabel.setText("Width can not be lower than 1");
			}
			
			else if (Integer.parseInt(heightColorFld.getText()) > 1080 || !AppUtils.isInteger(heightColorFld.getText())) {
				if(Integer.parseInt(heightColorFld.getText()) > 1080){
					errorLabel.setText("Height can not exceed 1080");
				}
				else{
					errorLabel.setText("Height can not contain decimal numbers");
				}
			}
			
			else if (Integer.parseInt(heightColorFld.getText()) < 1) {
				errorLabel.setText("Height can not be lower than 1");
			}
			
			else {
				errorLabel.setText("");
				PNGCreator creator = new PNGCreator();
				int width = Integer.parseInt(witdhColorFld.getText());
				int height = Integer.parseInt(heightColorFld.getText());
				String color = colorsComboBox.getValue().toUpperCase();
				try {
					creator.createImage(stage, width, height, color);
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	/*
	 * Developed by Rrahman Rexhepi - User Story 2.
	 * @saveToFile = When user clicks on "Save output to file" button.
	 * @SaveFileText = Object that needs "stage" and "String" that will get
	 * printed out in the file. the text will come from outPutArea.
	 */
	@FXML
	private void saveToFile(ActionEvent event) throws Exception {
		errorLabel.setText("");
		Stage stage = (Stage) this.errorLabel.getScene().getWindow();

		if (outPutArea.getText().equals("")) {
			errorLabel.setText("Please select something to generate before saving to file.");
		} else {
			try {
				// Create SaveFileText class, that i will use to create file.
				SaveFileText saveFile = new SaveFileText();
				saveFile.saveOutPut(stage, outPutArea.getText());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> imageColors = FXCollections.observableArrayList();
		imageColors.addAll("Red", "Blue", "Green", "Yellow", "Black");
		colorsComboBox.setItems(imageColors);
	}
}
