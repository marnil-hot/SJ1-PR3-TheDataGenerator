package com.sj1.pr3.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * Developed by Rrahman Rexhepi - User Story 2.
 * Method to print out the information from OutputArea.
 * User can select path , file name , file type for saving it.
 * @param outPut = is the text from OutPutArea.
 * @param .txt = is Text document.
 * @param .csv = is Excel document.
 * @IOException  = when ever the system fail to close bufferedWriter or FileWriter.
 * @NullPointerException = when user clicks cancel when saving file.
 * */

public class SaveFileText {
	public void saveOutPut(Stage stage, String outPut) throws Exception {
		// Filters for saving type.
		FileChooser.ExtensionFilter filterTxt = new FileChooser.ExtensionFilter("Text document (*.txt)", "*.txt*");
		FileChooser.ExtensionFilter filterCsv = new FileChooser.ExtensionFilter("Text CSV(*.csv)", "*.csv*");

		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(filterTxt);
		fileChooser.getExtensionFilters().add(filterCsv);
		File file = fileChooser.showSaveDialog(stage);
		String fileName = "";

		try {
			// Get what type of format + name of file.
			fileName = fileChooser.getSelectedExtensionFilter().getExtensions().toString();

			// Make the path name , file name and what format to save.
			if (fileName.equals("[*.txt*]")) {
				fileName = file.getAbsolutePath() + ".txt";
			} else if (fileName.equals("[*.csv*]")) {
				fileName = file.getAbsolutePath() + ".csv";
			} else {
				// This part is just for safety.
				JOptionPane.showMessageDialog(null, "Error: File name , invalid.");
			}

			try {
				// Create file & get the information that will include in the file
			
				String content = outPut;
				File filetxt = new File(fileName);
				bufferedWriter = new BufferedWriter(new FileWriter(filetxt, true));

				// Create or add new text to the file.
				if (filetxt.exists()) {
					bufferedWriter.write(content);

				} else {
					filetxt.createNewFile();
					bufferedWriter.write("," + content);
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Faild to save: " + file.getName());
				System.out.println("Faild to save: " + fileName);
				e.printStackTrace();

			} finally {

				try {

					if (bufferedWriter != null)
						bufferedWriter.close();

					if (fileWriter != null)
						fileWriter.close();

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error: Faild to close bufferedWriter or FileWriter.");
					System.out.println("Faild to close bufferedWriter or FileWriter.");
					ex.printStackTrace();

				}

			}

		} catch (NullPointerException e) {
			// When ever the user click on Cancel button in File chooser.

		}
	}
}

