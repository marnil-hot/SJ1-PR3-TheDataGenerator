package com.sj1.pr3.datagenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		System.out.println("Team4 - Testverktyg. Medlemmar: Rrahman Rexhepi , Hampus Bohlin, Kevin Nemec, Ibrahim Ibrahim"); // Show Developer name + project name
		Parent root = FXMLLoader.load(getClass().getResource("../view/TestVerktyg.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Team4 - Testverktyg"); 
		primaryStage.setResizable(false); 
		primaryStage.show();
	}
	
	public static void main(String[] start)
	{
		Application.launch(start);
	}
}
