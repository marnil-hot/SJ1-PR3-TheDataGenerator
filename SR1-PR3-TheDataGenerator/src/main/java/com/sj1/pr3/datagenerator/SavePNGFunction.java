package com.sj1.pr3.datagenerator;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Save PNG File class
 * User Story 10
 * @author Anna
 */
public class SavePNGFunction {
	static int startNumber = 1;

	public SavePNGFunction () {
		
	}

	public static WritableImage createWritableImage(PNGFile pngFile) {
		WritableImage writableImage = new WritableImage(pngFile.getWidth(), pngFile.getHeight());
		PixelWriter pixelWriter = writableImage.getPixelWriter();
		
		//fill whole PNGFile with color
		for(int x = 0; x < pngFile.getWidth(); x++){
			for(int y = 0; y < pngFile.getHeight(); y++){
				pixelWriter.setColor(x, y, pngFile.getColor());
			}
		}
		return writableImage;
	}
	
	public static void saveAsPNG(WritableImage wi) {
		int fileNumber = startNumber++;
	    String name ="snapshot" + fileNumber + ".png";

		File file = new File(name);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(wi, null), "png", file);
			System.out.println("Saved as: " + file.getName() + "\nPath: " + file.getAbsolutePath());

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 
	}

}
