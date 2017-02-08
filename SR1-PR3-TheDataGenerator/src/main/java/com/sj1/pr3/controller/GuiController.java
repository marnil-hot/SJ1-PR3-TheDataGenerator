package com.sj1.pr3.controller;

import java.util.Random;

import com.sj1.pr3.passgen.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GuiController {

	ObservableList<String> SecurityLevel = FXCollections.observableArrayList("Weak", "Medium", "Strong", "Very Strong");

	@FXML
	private Text txt;

	@FXML
	private TextArea txtArea;

	@FXML
	private TextField gibFld;

	@FXML
	private Button gibBtn;

	@FXML
	private TextField mailFld;

	@FXML
	private Button mailBtn;

	@FXML
	private Button passBtn;

	@FXML
	private ComboBox cb;

	/** Sets the combobox on Weak by default, and adds the other security
	 * levels as well. */
	@FXML
	private void initialize() {
		cb.setValue("Weak");
		cb.setItems(SecurityLevel);
	}
	
	/** Action handler for the generate random email button.
	 *  Generates a random email with the length of mail field input. */
	@FXML
	void email(ActionEvent event) {
		try {
			txtArea.setText(Email.emailRandom(Integer.parseInt(mailFld.getText())));
		} catch (IllegalArgumentException e) {
			txtArea.setText(e.getMessage() + "\nNo non-numeric characters allowed!");
			System.err.println(e.getMessage() + "\nNo non-numeric characters allowed!");
			gibFld.clear();
		}
	}
	/** Action handler for the generate gibberish button.
	 *  Generates gibberish words.
	 *  Amount of words is set in gibberish length field. */
	@FXML
	void gibberish(ActionEvent event) {
		if(txtArea.getText() != null){
			txtArea.clear();
		}
		try {
			for (String res : GibberishText.gibberize(GibberishText.getWordList(),
					Integer.parseInt(gibFld.getText()))) {
				txtArea.appendText(res + " ");
			}
		} catch (IllegalArgumentException e) {
			txtArea.setText(e.getMessage() + "\nNo non-numeric characters allowed!");
			System.err.println(e.getMessage() + "\nNo non-numeric characters allowed!");
			gibFld.clear();
		}

	}

	/** Action handler for the generate password button.
	 *  Every security level has their own amount of -
	 *  chars that will be randomised. */
	@FXML
	void password(ActionEvent event) {
			/** How many of each char for a weak password */
		if (cb.getValue() == "Weak") {
			int minLength = 6;
			int maxLength = 10;
			int nbrOfUPR = 0;
			int nbrOfLWR = 0;
			int nbrOfNBR = 0;
			int nbrOfSYM = 0;
			for (int i = 0; i < 10; i++) {
				char[] passw = PassGen.genPwd(minLength, maxLength, nbrOfUPR, nbrOfLWR, nbrOfNBR, nbrOfSYM);
				txtArea.setText(new String(passw));
			}
			/** How many of each char for a medium password */
		}
		if (cb.getValue() == "Medium") {
			int minLength = 8;
			int maxLength = 15;
			int nbrOfUPR = 1;
			int nbrOfLWR = 0;
			int nbrOfNBR = 1;
			int nbrOfSYM = 0;
			for (int i = 0; i < 10; i++) {
				char[] passw = PassGen.genPwd(minLength, maxLength, nbrOfUPR, nbrOfLWR, nbrOfNBR, nbrOfSYM);
				txtArea.setText(new String(passw));
			}
		}   /** How many of each char for a strong password */
		if (cb.getValue() == "Strong") {
			int minLength = 10;
			int maxLength = 20;
			int nbrOfUPR = 1;
			int nbrOfLWR = 0;
			int nbrOfNBR = 1;
			int nbrOfSYM = 1;
			for (int i = 0; i < 10; i++) {
				char[] passw = PassGen.genPwd(minLength, maxLength, nbrOfUPR, nbrOfLWR, nbrOfNBR, nbrOfSYM);
				txtArea.setText(new String(passw));
			}
		}	/** How many of each char for a very strong password */
		if (cb.getValue() == "Very Strong") {
			Random rnd = new Random();
			int r = rnd.nextInt(3) + 1;
			int minLength = 10;
			int maxLength = 20;
			int nbrOfUPR = r;
			int nbrOfLWR = 0;
			int nbrOfNBR = r;
			int nbrOfSYM = r;
			for (int i = 0; i < 10; i++) {
				char[] passw = PassGen.genPwd(minLength, maxLength, nbrOfUPR, nbrOfLWR, nbrOfNBR, nbrOfSYM);
				txtArea.setText(new String(passw));
			}
		}

	}
}
