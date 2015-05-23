/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carpet;

import javafx.beans.property.*;

/**
 *
 * @author ROMMEL
 */
public class PojoSecond {
    
    private IntegerProperty iter;
    private DoubleProperty xr,porcentaje;

    public PojoSecond() {
    }

    public PojoSecond(int iter, double xr, double porcentaje) {
        this.iter = new SimpleIntegerProperty(iter);
        this.xr = new SimpleDoubleProperty(xr);
        this.porcentaje = new SimpleDoubleProperty(porcentaje);
    }
    
    
    
    
}
