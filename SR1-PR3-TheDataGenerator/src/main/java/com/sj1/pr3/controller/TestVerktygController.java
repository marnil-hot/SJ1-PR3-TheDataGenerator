package com.sj1.pr3.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
	
	private String getCounterString(int value){
		String counterString = null;
		int counter = 0;
		int prevValue = 0;
		
		if(value % 2 != 0){
			counterString = "*";
		}
		else{
			counterString = "2";
		}
		
		for(int i = 2; i < value; i++){
			if(prevValue <= 9 && (counter % 2 == 0) && i < value){
				prevValue = Integer.parseInt(String.valueOf(i - 1)) + 2;
				counterString += prevValue;
			}
			else if(prevValue <= 9 && (counter % 2 != 0) && i <= value){
				counterString += "*";
			}
			else if(prevValue > 10 && (counter % 2 == 0) && i <= value){
				prevValue = Integer.parseInt(String.valueOf(i - 1)) + 3;
				counterString += prevValue;
			}
			else if(prevValue > 10 && (counter % 2 != 0) && i < value){
				counterString += "*";
			}
			counter++;
		}
		return counterString;
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		String s = getCounterString(35);
		System.out.println(s);
	}

}
