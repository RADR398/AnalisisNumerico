/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ROMMEL
 */
public class Principal_fxmlController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML protected void biseccionItemsAction(ActionEvent e){
     
      new Biseccion.Biseccion().start(new Stage());
    
    }
    
    @FXML protected void falsaPosicionItemsAction(ActionEvent e){
    
        new FalsaPosicion.FalsaPosicion().start(new Stage());
    
    }
    
    @FXML protected void newtonRaphsonItemsAction(ActionEvent e){
    
    new NewtonRaphson.NewtonRaphson().start(new Stage());
    
    }
    @FXML protected void secanteItemsAction(ActionEvent e){
    
    new Secante.Secante().start(new Stage());
    
    
    }
    
}
