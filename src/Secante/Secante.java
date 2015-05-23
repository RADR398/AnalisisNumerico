/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secante;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ROMMEL
 */
public class Secante extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = null;
        try {
            scene = new Scene((Parent)FXMLLoader.load(Secante.class.getResource("secante_fxml.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(Secante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        primaryStage.setTitle("Metodo de biseccion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
