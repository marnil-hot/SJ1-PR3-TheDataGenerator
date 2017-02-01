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
	    private ComboBox<?> colorsComboBox;

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

	


	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
