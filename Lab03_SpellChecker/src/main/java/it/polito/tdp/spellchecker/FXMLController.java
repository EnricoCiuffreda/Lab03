package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Dictionary;
import model.RichWord;

public class FXMLController {
	private Dictionary dizionario=new Dictionary();
	private ObservableList<String> listalingue = FXCollections.observableArrayList();
	private int errori=0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxscelta;

    @FXML
    private TextArea txtin;

    @FXML
    private Button btnspell;

    @FXML
    private TextArea txtout;

    @FXML
    private Label txtwords;

    @FXML
    private Button btnclear;

    @FXML
    private Label txtsecond;

    @FXML
    void doClearText(ActionEvent event) {
    	txtin.clear();
    	txtout.clear();
    	txtwords.setVisible(false);
    	txtsecond.setVisible(false);
    	dizionario.getDizionario().clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long start= System.currentTimeMillis();
    	errori=0;
    	String input= txtin.getText();
    	List <String> in=dizionario.divisione(input);
    	String lingua=boxscelta.getValue();
    	dizionario.loadDictionary(lingua);
    	List <RichWord> out=dizionario.spellCheckTextDichotomic(in);
    	for(RichWord r: out) {
    		txtout.appendText(r.toString());
    		if(r.isCorretto()==false) {
    			errori++;
    		}
    	}
    	String stampa="Hai commesso "+errori+" errori";
    	long end = System.currentTimeMillis();
    	long time=(long) ((end-start)*1000);
    	txtsecond.setVisible(true);
    	txtwords.setVisible(true);
    	txtwords.setText(stampa);
    	txtsecond.setText("speel check completed in "+time+ " seconds");
    }

    @FXML
    void initialize() {
        assert boxscelta != null : "fx:id=\"boxscelta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtin != null : "fx:id=\"txtin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnspell != null : "fx:id=\"btnspell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtout != null : "fx:id=\"txtout\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtwords != null : "fx:id=\"txtwords\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnclear != null : "fx:id=\"btnclear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtsecond != null : "fx:id=\"txtsecond\" was not injected: check your FXML file 'Scene.fxml'.";
        listalingue.addAll("English","Italian");
		boxscelta.setItems(listalingue);
		boxscelta.setValue("English");

    }
}
