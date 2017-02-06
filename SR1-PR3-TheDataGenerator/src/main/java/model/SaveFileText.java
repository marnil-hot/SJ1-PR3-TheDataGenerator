package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveFileText {
	public void saveOutPut(Stage stage, String outPut) throws Exception {
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
			fileName = fileChooser.getSelectedExtensionFilter().getExtensions().toString();

			if (fileName.equals("[*.txt*]")) {
				fileName = file.getAbsolutePath() + ".txt";
			} else if (fileName.equals("[*.csv*]")) {
				fileName = file.getAbsolutePath() + ".csv";
			} else {
				// This part is just for safety.
				JOptionPane.showMessageDialog(null, "Error: File name , invalid.");
			}

			try {

				String content = outPut;
				File filetxt = new File(fileName);
				bufferedWriter = new BufferedWriter(new FileWriter(filetxt, true));

				// Create .txt file.
				if (filetxt.exists()) {
					bufferedWriter.write(", end" + content);
				} else if (file.exists()) {
					JOptionPane.showMessageDialog(null, "xxxx");
				} else {
					filetxt.createNewFile();
					bufferedWriter.write(content);
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Faild to save: " + fileName);
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

		} catch (NullPointerException e) {
			// When ever the user click on Cancel button in File chooser.

		}
	}
}
