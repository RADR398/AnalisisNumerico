/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secante;


import Biseccion.Biseccion_fxmlController;
import Carpet.*;
import Carpet.PojoPrimary;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ROMMEL
 */
public class Secante_fxmlController implements Initializable {

   @FXML TableView<PojoPrimary> tableview;
   @FXML TableColumn<PojoPrimary,Number> iter,x0,x1,fx1,xr,porcentaje;
   Method metodo = new Method();
   @FXML Button Button1;
   @FXML TextField txtecuacion,txtx0,txtx1,txtporcentaje;
   //PojoPrimary(int iteracion, double xl, double xu, double xr, double fxr, double porcentaje, String signo)
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iter.setCellValueFactory(cellData->cellData.getValue().getIteracion());
        x0.setCellValueFactory(cellData->cellData.getValue().getXl());
        x1.setCellValueFactory(cellData->cellData.getValue().getXu());
        fx1.setCellValueFactory(cellData->cellData.getValue().getXr());
        xr.setCellValueFactory(cellData->cellData.getValue().getFxr());
        
        porcentaje.setCellValueFactory(cellData->cellData.getValue().getPorcentaje());
        Button1.setDisable(false);
    }
    
    @FXML public void generarButtonAction(ActionEvent e){
   Pila pila = new Pila();  
   if(pila.balanceada(txtecuacion.getText())==true){
    tableview.setItems(metodo.MetodoSecante(Double.parseDouble(txtx1.getText()),Double.parseDouble(txtx0.getText()), 
    Double.parseDouble(txtporcentaje.getText()), pila, txtecuacion.getText()));
    
   }
    }
    
    @FXML public void graficarFuncion(ActionEvent e){
    
        
        PintaFuncionesJavaFX grafica = new PintaFuncionesJavaFX();
    grafica.Lista(metodo.series);
       try {
           grafica.start(new Stage());
       } catch (Exception ex) {
           Logger.getLogger(Biseccion_fxmlController.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    
    
    
    }
    
}
