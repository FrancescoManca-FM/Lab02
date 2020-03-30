package it.polito.tdp.alien;

import java.awt.FontFormatException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dictionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTranslate;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClearText;

    @FXML
    void doReset(ActionEvent event) {
    	dictionary.getDizionario().clear();
    	txtTranslate.clear();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) throws FontFormatException {
    	String s = txtTranslate.getText().toLowerCase();
    	if(s.contains("0") || s.contains("1") || s.contains("2") ||s.contains("3") ||s.contains("4") ||s.contains("5") ||s.contains("6") ||s.contains("7") ||s.contains("8") ||s.contains("9")) {
    		txtResult.setText("Puoi inserire solo lettere minuscole o maiuscole\n");
    		throw  new FontFormatException ("Puoi inserire solo lettere minuscole o maiuscole");
    	}
    	if(s.contains(" ")) {
    		String alienWord = s.substring(0, s.indexOf(" "));
    		String translation = s.substring(s.indexOf(" ")+1);
    		dictionary.addWord(alienWord, translation);
    		txtTranslate.clear();
    		return;
    	}else {
    		String a = dictionary.translateWord(s);
    		txtTranslate.clear();
    		txtResult.setText(a);
    	}

    }

    @FXML
    void initialize() {
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        dictionary  = new AlienDictionary();
    }
}
