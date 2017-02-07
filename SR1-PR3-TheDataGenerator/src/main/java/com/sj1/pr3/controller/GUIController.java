package com.sj1.pr3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class GUIController implements Initializable {
	@FXML
	private ToggleButton btnString;
	@FXML
	private ToggleButton btnEmail;
	@FXML
	private ToggleButton btnText;
	@FXML
	private ToggleButton btnPNG;
	@FXML
	private Button btnResult;
	@FXML
	private TextArea textArea;
	@FXML
	private TextField emailTextFld;
	@FXML
	private TextField heightTextFld;
	@FXML
	private TextField widthTextFld;
	@FXML
	private TextField wordsTextFld;
	@FXML
	private RadioButton radioBtnWords;
	@FXML
	private RadioButton radioBtnLetters;
	@FXML
	private Label errorIntLabel;
	@FXML
	private VBox testCon;
	@FXML
	private VBox emailOptionsContainer;
	@FXML
	private VBox textOptionsContainer;
	@FXML
	private HBox PNGOptionsContainer;
	@FXML
	private ColorPicker colorPicker;

	@FXML
	public void selectTextButtonAction(ActionEvent event) {
		if (btnText.isSelected()) {
			textOptionsContainer.setVisible(true);
			PNGOptionsContainer.setVisible(false);
			emailOptionsContainer.setVisible(false);
		} else {
			textOptionsContainer.setVisible(false);
		}
		radioBtnWords.setSelected(true);
		btnResult.setText("Randomize");
	}

	@FXML
	public void selectEmailButtonAction(ActionEvent event) {
		if (btnEmail.isSelected()) {
			emailOptionsContainer.setVisible(true);
			textOptionsContainer.setVisible(false);
			PNGOptionsContainer.setVisible(false);
		} else {
			emailOptionsContainer.setVisible(false);
		}
		btnResult.setText("Randomize");
	}

	@FXML
	public void selectStringButtonAction(ActionEvent event) {
		if (btnString.isSelected()) {
			emailOptionsContainer.setVisible(true);
			textOptionsContainer.setVisible(false);
			PNGOptionsContainer.setVisible(false);
		} else {
			emailOptionsContainer.setVisible(false);
		}
		btnResult.setText("Randomize");
	}

	@FXML
	public void selectPNGButtonAction(ActionEvent event) {
		if (btnPNG.isSelected()) {
			PNGOptionsContainer.setVisible(true);
			textOptionsContainer.setVisible(false);
			emailOptionsContainer.setVisible(false);
			btnResult.setText("Create PNG");
		} else {
			PNGOptionsContainer.setVisible(false);
			btnResult.setText("Randomize");
		}
	}

	@FXML
	public void getResultButtonAction(ActionEvent event) {

	} 

	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup radioGroup = new ToggleGroup();
		radioBtnWords.setToggleGroup(radioGroup);
		radioBtnLetters.setToggleGroup(radioGroup);

		ToggleGroup btnToggleGroup = new ToggleGroup();
		btnString.setToggleGroup(btnToggleGroup);
		btnEmail.setToggleGroup(btnToggleGroup);
		btnText.setToggleGroup(btnToggleGroup);
		btnPNG.setToggleGroup(btnToggleGroup);

		textArea.setFocusTraversable(false);
		textArea.setEditable(false);
		errorIntLabel.setVisible(false);

		textOptionsContainer.setVisible(false);
		emailOptionsContainer.setVisible(false);
		PNGOptionsContainer.setVisible(false);
	}  
}
