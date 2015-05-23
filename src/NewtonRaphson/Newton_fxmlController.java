/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewtonRaphson;

import Carpet.Method;
import Carpet.Pila;
import Carpet.PojoPrimary;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ROMMEL
 */
public class Newton_fxmlController implements Initializable {

   @FXML TableView<PojoPrimary> tableview;
   @FXML TableColumn<PojoPrimary,Number> iter,xr,porcentaje;
   
   @FXML TextField txtecuacion,txtxo,txtporcentaje;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    @FXML public void generarButtonAction(ActionEvent e){
    
    Method metodo = new Method();
        JOptionPane.showMessageDialog(null, txtecuacion.getText());
        JOptionPane.showMessageDialog(null, metodo.DerivadaFuncion(txtecuacion.getText().trim()));
    
    }
}
