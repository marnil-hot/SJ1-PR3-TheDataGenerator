package com.sj1.pr3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.concurrent.Task;
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
	 * @return the CounterString
	 */
	//Problem med låga och höga tal, tror jag måste skapa olika funktioner för olika storlekar på tal man skickar in i parametern och sen utgå från det
	//Skapa callback som kallar på andra funktioner i funktionen när ett value blir lika med eller högre tröskeln för nästa tal cykel.
	private static String generateCounterString(long length, String delimeter) {
		String counterString = null;
		int nextValue;
		int counter = 0;
		
		if((length % 2) != 0){
			counterString = "2";
			nextValue = 2;
		}
		else{
			counterString = delimeter;
			nextValue = 3;
		}
		
		if(nextValue == 2){
			for(int i = 2; i < length; i++){
				if((i % 2) == 0 && nextValue <= 8){
					counterString += delimeter;
				}
				else{
					nextValue = (i + 1);
					counterString += nextValue;
				}
				if(nextValue == 8){
					break;
				}
			}
			
			for(int n = nextValue; n < length; n++){
				if((n % 2) == 0 && nextValue <= 98){
					counterString += delimeter;
				}
				else{
					nextValue += 3;
					counterString += nextValue;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
			
			for(int j = nextValue; j < length; j++){
				if(nextValue == 98 && (j % 2) == 0 && nextValue <= 998){
					counterString += delimeter;
				}
				else{
					nextValue += 4;
					counterString += nextValue;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
				counter++;
			}
			
			for(int k = nextValue; k < length; k++){
				if((k % 2) == 0 && nextValue <= 9998){
					counterString += delimeter;
				}
				else{
					nextValue += 5;
					counterString += nextValue;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
			
			for(int v = nextValue; v < length; v++){
				if((v % 2) == 0 && nextValue <= 99998){
					counterString += delimeter;
				}
				else{
					nextValue += 6;
					counterString += nextValue;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
		}
		else if(nextValue == 3){
			counterString += nextValue;
			
			for(int i = 3; i < length; i++){
				if((i % 2) == 0 && nextValue <= 9){
					nextValue = (i + 1);
					counterString += nextValue;
				}
				else{
					counterString += delimeter;
				}
				if(nextValue == 9){
					break;
				}
			}
			
			for(int n = nextValue; n < length; n++){
				if((n % 2) == 0 && nextValue <= 99){
					nextValue += 3;
					counterString += nextValue;
				}
				else{
					counterString += delimeter;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
			
			for(int j = nextValue; j < length; j++){
				if((j % 2) == 0 && nextValue <= 999){
					nextValue += 4;
					counterString += nextValue;
				}
				else{
					counterString += delimeter;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
			
			for(int k = nextValue; k < length; k++){
				if((k % 2) == 0 && nextValue <= 9999){
					nextValue += 5;
					counterString += nextValue;
				}
				else{
					counterString += delimeter;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
			
			for(int v = nextValue; v < length; v++){
				if((v % 2) == 0 && nextValue <= 99999){
					nextValue += 6;
					counterString += nextValue;
				}
				else{
					counterString += delimeter;
				}
				if(nextValue == length){
					counterString += delimeter;
					break;
				}
			}
		}
		
		return counterString;
	}
	
	/**
	 * Developed by Kevin Nemec in User Story 5.
	 * Some error handling to check input values in all the input fields connected to this method. Also running the actual method on a thread to not block
	 * the UI thread on big number calculations.
	 */
	@FXML
	private void getCounterString(){
		final long length;
		if(lengthFld.getText().equals("") && delimiterFld.getText().equals("")){
			errorLabel.setText("");
			errorLabel.setText("Length and Delimiter must be specified");
		}
		else if(lengthFld.getText().equals("") || delimiterFld.getText().equals("") || !isNumber(lengthFld.getText())){
			if(lengthFld.getText().equals("")){
				errorLabel.setText("");
				errorLabel.setText("Length can not be empty");
			}
			else if(delimiterFld.getText().equals("")){
				errorLabel.setText("");
				errorLabel.setText("You have to specify delimiter character");
			}
			else{
				errorLabel.setText("");;
				errorLabel.setText("Length must be a number");
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
	 * Developed by Kevin Nemec in User Story 5.
	 * Method to check if an input in a input field is a number or not.
	 * @param input
	 * @return
	 */
	public static boolean isNumber(String input){
		for(int i = 0; i < input.length(); i++){
			if(!Character.isDigit(input.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
