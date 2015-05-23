/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Carpet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Richard
 */
public class PintaFuncionesJavaFX extends Application {
    LineChart.Series<Double, Double> series;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        Parent rootPane =(Parent)loader.load();
        SampleController controller = loader.getController();
        controller.setListObservable(series);
        Scene scene = new Scene(rootPane);
        stage.setTitle("Pinta Funciones");
        stage.setScene(scene);
        stage.show();
        
        
    }
public void Lista(LineChart.Series<Double, Double> series){
 this.series = series;

}
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
   
}
