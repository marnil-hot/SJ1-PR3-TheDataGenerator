package com.sj1.pr3.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
	private TextField witdhColorFld;

	@FXML
	private TextField heightColorFld;

	@FXML
	private ComboBox<String> colorsComboBox;

	@FXML
	private Label errorLabel;

	@FXML
	private TextField excelRowsFld;

	@FXML
	private TextField excelColumnsFld;

	@FXML
	private ComboBox<?> excelComboBox;

	@FXML
	private TextField dataBaseFld;

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
	private ComboBox<?> dataBaseComboBox;

	
	
	/**
	 * Developed by Kevin Nemec - User Story 10.
	 * Method is executed when the click event for the button to create a new image fires. Input handling and method invoking below.
	 * @param event makes it visible for the FXML file.
	 */
	@FXML
	private void generateImage(ActionEvent event){
		int width = Integer.parseInt(witdhColorFld.getText());
		int height = Integer.parseInt(heightColorFld.getText());
		String color = colorsComboBox.getValue().toUpperCase();
		
		if(width > 1920 || witdhColorFld.getText().length() == 0){
			if(width > 1920){
				errorLabel.setText("Width can not exceed 1920");
			}
			else{
				errorLabel.setText("You must specify a width");
			}
		}
		else if(height > 1080 || heightColorFld.getText().length() == 0){
			if(height > 1080){
				errorLabel.setText("");
				errorLabel.setText("Height can not exceed 1080");
			}
			else{
				errorLabel.setText("");
				errorLabel.setText("You must specify a height");
			}
		}
		else if(color == null){
			errorLabel.setText("");
			errorLabel.setText("You must select a color");
		}
		else{
			PNGCreator creator = new PNGCreator();
			
			try{
				creator.createImage(width, height, color);
			}
			catch(Exception ex){
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
