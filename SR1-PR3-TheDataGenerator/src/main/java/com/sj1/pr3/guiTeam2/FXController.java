package com.sj1.pr3.guiTeam2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Marius
 */
public class FXController implements Initializable {
	
   
    @FXML
    private Button mySavetofile;
    @FXML
    private RadioButton myLetters;
    @FXML
    private RadioButton myNumbers;
    @FXML
    private RadioButton mySpecialChars;
    @FXML
    private RadioButton mySmallChars;
    @FXML
    private RadioButton myBigChars;
     @FXML
    private TextField myLenghtofstring;
     @FXML
     private TextArea myOutput;
    @FXML
    private TextField myRows;
    @FXML
    private TextField myColumns;
    @FXML
    private Button myGenerateExcel;
    @FXML
    private Button myFeach;
    @FXML
    private Button mySave;
    @FXML
    private TextField myHeight;
    @FXML
    private TextField myWidth;
    @FXML
    private Button myCreateImage;
    @FXML
    private ColorPicker myColor;
 
 
 
    


@FXML
private void handleButtonAction(ActionEvent event) throws IOException {
    
    Parent p=FXMLLoader.load(getClass().getResource("/aplication/Scene.fxml"));
    Scene s= new Scene(p);
    Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow( );
    stg.setScene(s);
    stg.show();
    
}

//@Override
// I do not know why do not let me use Override?
public void initialize(URL url, ResourceBundle rb) {
    // TODO
}    

}
