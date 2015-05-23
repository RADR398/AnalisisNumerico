/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewtonRaphson;

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
public class NewtonRaphson extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = null;
        try {
            scene = new Scene((Parent)FXMLLoader.load(NewtonRaphson.class.getResource("Newton_fxml.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(NewtonRaphson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        primaryStage.setTitle("Newton Raphson");
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
