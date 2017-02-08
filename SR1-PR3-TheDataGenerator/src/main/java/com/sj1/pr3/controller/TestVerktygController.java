package com.sj1.pr3.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import com.sj1.pr3.ApplicationUtils.AppUtils;

import javafx.application.Platform;

import com.sj1.pr3.model.PNGCreator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


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
	 * Developed by Kevin Nemec in User Story 5.
	 * Method which generates a CounterString based on the parameters.
	 * @param value the value you want to generate the CounterString from
	 * @param delimiter which character you want between each character.
	 * @return the CounterString
	 */
	public static String generateCounterString(long length, String delimiter) {
		long currentNumber = length;
		int outLen = 0;
		List<String> numbers = new ArrayList<String>();
		String currentString = null;
		String counterString = "";
		
		while(outLen < length){
			currentString = currentNumber + delimiter;
			currentNumber -= currentString.length();
			
			if(outLen + currentString.length() <= length){
				numbers.add(currentString);
				outLen += currentString.length();
			}
			else{
				numbers.add(delimiter);
				break;
			}
		}
		
		Collections.reverse(numbers);
		for(String s : numbers){
			counterString += s;
		}
		
		return counterString;
	}
	
	/**
	 * Developed by Kevin Nemec in User Story 5.
	 * Some error handling to check input values in all the input fields connected to this method. Also updating the UI in a separate thread to not block
	 * the UI and cause a spike when handling big calculations.
	 */
	@FXML
	private void getCounterString(){
		final long length;
		if(lengthFld.getText().equals("") && delimiterFld.getText().equals("")){
			errorLabel.setText("");
			errorLabel.setText("Length and Delimiter must be specified");
		}
		else if(lengthFld.getText().equals("") || !AppUtils.isNumber(lengthFld.getText())){
			if(lengthFld.getText().equals("")){
				errorLabel.setText("");
				errorLabel.setText("Length can not be empty");
			}
			else{
				errorLabel.setText("");;
				errorLabel.setText("Length must be a number");
			}
		}
		else if(delimiterFld.getText().length() > 1 || delimiterFld.getText().length() == 0 || AppUtils.isNumber(delimiterFld.getText())){
			if(delimiterFld.getText().length() > 1){
				errorLabel.setText("Delimiter must be max 1 character");
			}
			else if(delimiterFld.getText().length() == 0){
				errorLabel.setText("Delimiter must be 1 character");
			}
			else{
				errorLabel.setText("Delimiter can not be a number");
			}
		}
		else{
			length = Long.parseLong(lengthFld.getText());
			Platform.runLater(new Runnable(){
				public void run(){
					errorLabel.setText("");
					outPutArea.setText(generateCounterString(length, delimiterFld.getText()));
				}
			});
		}
	}
	
	
	/**
	 * Developed by Kevin Nemec in User Story 10.
	 * Method is executed when the click event for the button to create a new image fires. Input handling and method invoking below.
	 * @param event makes it visible for the FXML file.
	 */
	@FXML
	private void generateImage(ActionEvent event){
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
					creator.createImage(width, height, color);
					errorLabel.setText("File Creates Successfully! File path: " + "\n" + creator.getAbsoluteFilePath());
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	    
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> imageColors = FXCollections.observableArrayList();
		imageColors.addAll("Red", "Blue", "Green", "Yellow", "Black");
		colorsComboBox.setItems(imageColors);
	}
}
