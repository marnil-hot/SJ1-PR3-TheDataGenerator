package com.sj1.pr3.datagenerator;

import javafx.scene.paint.Color;

/**
 * PNG File class
 * User Story 10
 * @author Anna
 */

public class PNGFile {
	private int width;
	private int height;
	private Color color;
	
	public PNGFile(int width, int height, Color color) {
		this.width=width;
		this.height=height;
		this.color=color;	
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
