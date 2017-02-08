package com.sj1.pr3.datagenerator;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * Create PNG File class
 * User Story 10
 * @author Anna
 */

public class PNGFile {

	public static WritableImage writableImage;
	public static int fileNumber = 1;

	//Method for creating a png file based on user input for width, height and color
	public static File createPNG(int width, int height, Color color) {

		//Empty WritableImage. A subclass of Image for writing pixels directly to an image.
		writableImage = new WritableImage(width, height);

		//Use Pixelwriter to write pixels to the writableImage
		PixelWriter pixelWriter = writableImage.getPixelWriter();

		//Write pixels to the writableImage by using the pixelwriter
		//Fills whole image with color
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				pixelWriter.setColor(x, y, color);
			}
		}

		//Counter for fileName, starts as "snapshot1.png"
		int number = fileNumber++;
		String name = "snapshot"+number+".png";

		//writing the WritableImage to file as png and saves it
		File file = new File(name);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
			System.out.println("Saved as: " + file.getName() + "\nPath: " + file.getAbsolutePath());

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 
		return file;
	}
}
