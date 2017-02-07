package com.sj1.pr3.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sj1.pr3.ApplicationUtils.AppUtils;
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
				errorLabel.setText("Width must be a number");
			}
		}
		
		else if(heightColorFld.getText().length() == 0 || !AppUtils.isNumber(heightColorFld.getText())){
			if(heightColorFld.getText().length() == 0){
				errorLabel.setText("You must specify a height");
			}
			else{
				errorLabel.setText("Height must be a number");
			}
		}
		
		else if(colorsComboBox.getValue() == null){
			errorLabel.setText("You must select a color");
		}
		
		else /*if(AppUtils.isNumber(witdhColorFld.getText()) && AppUtils.isNumber(heightColorFld.getText()))*/{
			if (Integer.parseInt(witdhColorFld.getText()) > 1920) {
				errorLabel.setText("Width can not exceed 1920");
			} 
			else if (Integer.parseInt(witdhColorFld.getText()) < 1) {
				errorLabel.setText("Width can not be lower than 1");
			} 
			else if (Integer.parseInt(heightColorFld.getText()) > 1080) {
				errorLabel.setText("Height can not exceed 1080");
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
