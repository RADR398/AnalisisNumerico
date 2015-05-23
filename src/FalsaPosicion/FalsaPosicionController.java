/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FalsaPosicion;

import Biseccion.Biseccion_fxmlController;
import Carpet.*;
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
public class FalsaPosicionController implements Initializable {

   @FXML TableView<PojoPrimary> tableview;
   @FXML TableColumn<PojoPrimary,Number> iter,xl,xu,xr,fxr,porcentaje;
   @FXML TableColumn<PojoPrimary,String> signo;
   @FXML TextField txtecuacion,txtxl,txtxu,txtporcentaje;
   Method metodo = new Method();
   @FXML Button Button1;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iter.setCellValueFactory(cellData->cellData.getValue().getIteracion());
        xl.setCellValueFactory(cellData->cellData.getValue().getXl());
        xu.setCellValueFactory(cellData->cellData.getValue().getXu());
        xr.setCellValueFactory(cellData->cellData.getValue().getXr());
        fxr.setCellValueFactory(cellData->cellData.getValue().getFxr());
        signo.setCellValueFactory(cellData->cellData.getValue().getSigno());
        porcentaje.setCellValueFactory(cellData->cellData.getValue().getPorcentaje());
        Button1.setDisable(false);
    }
    
    @FXML public void generarButtonAction(ActionEvent e){
   Pila pila = new Pila();  
   if(pila.balanceada(txtecuacion.getText())==true){
    tableview.setItems(metodo.MetodoFalsaPosicion(Double.parseDouble(txtxl.getText()),
    Double.parseDouble(txtxu.getText()),Double.parseDouble(txtporcentaje.getText()) ,
    pila, pila.Modificacion(txtecuacion.getText())));
    
   }
    }
    
    @FXML public void GraficarFuncion(ActionEvent e){
    
    
     PintaFuncionesJavaFX grafica = new PintaFuncionesJavaFX();
    grafica.Lista(metodo.series);
       try {
           grafica.start(new Stage());
       } catch (Exception ex) {
           Logger.getLogger(Biseccion_fxmlController.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    
    }
    
}
