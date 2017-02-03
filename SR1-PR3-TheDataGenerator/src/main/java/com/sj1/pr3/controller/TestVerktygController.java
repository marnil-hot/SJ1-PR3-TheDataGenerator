package com.sj1.pr3.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
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

	// Path and file name,format for saving output.
	private final String FileNametxt = "TestVerktygLog.txt";
	private final String FileNamecsv = "TestVerktygLog.csv";
	

	/*
	 * @saveToFile Saving output to file, if there is no file create new else
	 * continue where it last where. Supports .txt and .csv file. By: Rrahman
	 * Rexhepi.
	 */
	
	//TODO , vrf är det , i början ? , alertDialog . + ifall det är fel .
	@FXML
	private void saveToFile(ActionEvent event) {
		errorLabel.setText("");
		if (outPutArea.getText().equals("")) {
			errorLabel.setText("Please select something to generate before saving to file.");
		} else {
			// Write down output to .txt file.
			BufferedWriter bufferedWriter = null;
			FileWriter fileWriter = null;

			try {

				String content = outPutArea.getText();
				File filetxt = new File(FileNametxt);

				bufferedWriter = new BufferedWriter(new FileWriter(filetxt, true));

				// Create .txt file.
				if (filetxt.exists()) {
					bufferedWriter.write(", end" + content);
				} else {
					filetxt.createNewFile();
					bufferedWriter.write(content);
				}
				
				

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Faild to save: " + FileNametxt);
				e.printStackTrace();

			} finally {

				try {

					if (bufferedWriter != null)
						bufferedWriter.close();

					if (fileWriter != null)
						fileWriter.close();

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error: Faild to close bufferedWriter or FileWriter.");
					ex.printStackTrace();

				}

			}

			// Write down output to .csv file.
			bufferedWriter = null;
			fileWriter = null;

			try {

				String content = outPutArea.getText();
				File file = new File(FileNamecsv);

				bufferedWriter = new BufferedWriter(new FileWriter(FileNamecsv, true));

				// Create .txt file.
				if (file.exists() == false) {
					file.createNewFile();
					bufferedWriter.write(content);
				} else {
					bufferedWriter.write("," + content);
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Faild to save: " + FileNamecsv);
				e.printStackTrace();

			} finally {

				try {

					if (bufferedWriter != null)
						bufferedWriter.close();

					if (fileWriter != null)
						fileWriter.close();

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error: Faild to close bufferedWriter or FileWriter.");
					ex.printStackTrace();

				}

			}

		}
		JOptionPane.showMessageDialog(null, "Saving done!");

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		outPutArea.setText("1234");
	}

}
