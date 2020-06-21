
 package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.SimulationResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> boxRiver;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtNumMeasurements;

    @FXML
    private TextField txtFMed;

    @FXML
    private TextField txtK;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doSimula(ActionEvent event) {
    	try {
        	double k = Double.parseDouble(txtK.getText());
        	
        	SimulationResult sr = model.simulate(boxRiver.getValue(), k);
        	
        	txtResult.setText("Numero di giorni critici: "
        			+sr.getNumeroDiGiorni()+ "\n");
        	
        	txtResult.appendText("Occupazione media del bacino: " +(int) sr.getAvgC() + "m^3\n");
        	
        	txtResult.appendText("\n SIMULAZIONE TERMINATA \n");
        
        		
        	}catch (NumberFormatException e ) {
        		txtResult.setText("Devi inserire un valore numerico per il fattore k");
        	}
    }

    @FXML
    void setData(ActionEvent event) {
    	River newValue = boxRiver.getValue();
    	if(newValue != null) {
    		txtStartDate.setText(model.getStartDate(newValue).toString());
    		txtEndDate.setText(model.getEndDate(newValue).toString());
    		txtNumMeasurements.setText(String.valueOf(model.getNumMeasurements(newValue)));
    		txtFMed.setText(String.format("%.3f", model.getFMed(newValue)));
    	}
    }

    @FXML
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Model model) {
    	this.model = model;
    	this.boxRiver.getItems().addAll(this.model.getRivers());
    }
}
    	/**/
    
  
    	/**/

    


