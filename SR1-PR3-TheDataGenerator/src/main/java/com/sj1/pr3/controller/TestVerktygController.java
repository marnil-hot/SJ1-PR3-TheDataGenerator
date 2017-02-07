package com.sj1.pr3.controller;


import java.net.URL;
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
	String result = "";

	/*
	 * Developed by Rrahman Rexhepi - User Story 2.
	 * @Generate random string = When user clicks on "Save output to file" button.
	 * Error handling also warning if the amount is to high that will make the application freeze.
	 * After every thing is good,  it calls on the method : @startGenerate.
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
		// Output field, and length.
		outPutArea.setText("12341231233");
		outPutLengthLable.setText("Length: " + outPutArea.getLength() + " characters.");
	}

}
