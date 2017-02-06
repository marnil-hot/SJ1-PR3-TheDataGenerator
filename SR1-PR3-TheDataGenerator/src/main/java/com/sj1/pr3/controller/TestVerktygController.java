package com.sj1.pr3.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import ApplicationUtils.NumberParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.GenerateTestData;
import model.SaveFileText;

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
	private CheckBox checkBoxNumbers;

	@FXML
	private CheckBox checkBoxSpecialchars;

	@FXML
	private CheckBox checkBoxSmallcharacters;

	@FXML
	private CheckBox checkBoxBigchars;

	@FXML
	private Label outPutLengthLable;

	@FXML
	private ComboBox<?> dataBaseComboBox;

	/*
	 * Developed by Rrahman Rexhepi - User Story 2.
	 * 
	 * @Generate random string = When user clicks on "Save output to file"
	 * button.
	 *
	 * 
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
			errorLabel.setText("Please fill in only numbers in Length of string.");
			lengthFld.clear();
			
		} else if (!checkBoxBigchars.isSelected() && (!checkBoxNumbers.isSelected()
				&& (!checkBoxSmallcharacters.isSelected() && (!checkBoxSpecialchars.isSelected())))) {
			errorLabel.setText("Please select one of the alternatives in the checkboxes.");
		} else {
			// Update GUI
			String result = generateData.generateTestData(Long.valueOf(lengthFld.getText()),
					checkBoxSpecialchars.isSelected(), checkBoxNumbers.isSelected(),
					checkBoxSmallcharacters.isSelected(), checkBoxBigchars.isSelected());

			outPutArea.setText(result);
			outPutLengthLable.setText("Length: " + outPutArea.getLength() + " characters.");
		}

	}

	/*
	 * Developed by Rrahman Rexhepi - User Story 2.
	 * 
	 * @saveToFile = When user clicks on "Save output to file" button.
	 * 
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
		// Output field, and length.
		outPutArea.setText("12341231233");
		outPutLengthLable.setText("Length: " + outPutArea.getLength() + " characters.");
	}

}
