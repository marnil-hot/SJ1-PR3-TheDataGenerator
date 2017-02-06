package com.sj1.pr3.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PNGCreator {
	
	/**
	 * Developed by Kevin Nemec in User Story 10 and Edited/Extended by Kevin Nemec in User Story 11.
	 * Method to create a new PNG file with a width, height and color specified by the user.
	 * @param width = The width of the picture.
	 * @param height = The height of the picture.
	 * @param color = The color of the picture.
	 * @throws Exception = If anything goes wrong, we can see the cause.
	 */
	public void createImage(Stage stage, int width, int height, String color) throws Exception {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG File", "*.png*");
		
		switch(ImageColor.valueOf(color)){
		case RED:
			graphics.setPaint(Color.RED);
			break;
		case BLACK:
			graphics.setPaint(Color.BLACK);
			break;
		case BLUE:
			graphics.setPaint(Color.BLUE);
			break;
		case GREEN:
			graphics.setPaint(Color.GREEN);
			break;
		case YELLOW:
			graphics.setPaint(Color.YELLOW);
			break;
		}
		
		graphics.fillRect(0, 0, width, height);
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(filter);
		File file = fileChooser.showSaveDialog(stage);
		
		if(!file.exists() && file != null){
			ImageIO.write(bufferedImage, "PNG", new File(file.getAbsolutePath() + ".png"));
		}
	}
}