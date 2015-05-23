/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carpet;

import Biseccion.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ROMMEL
 */
public class PojoPrimary {
    
    private IntegerProperty iteracion;
    private DoubleProperty xl,xu,xr,fxr,porcentaje,secante;
    private StringProperty signo;

    public PojoPrimary() {
    }

    public PojoPrimary(int iteracion, double xl, double xu, double xr, double fxr, double porcentaje, String signo) {
        this.iteracion = new SimpleIntegerProperty(iteracion);
        this.xl =new SimpleDoubleProperty(xl);
        this.xu = new SimpleDoubleProperty(xu);
        this.xr = new SimpleDoubleProperty(xr);
        this.fxr = new SimpleDoubleProperty(fxr);
        this.porcentaje = new SimpleDoubleProperty(porcentaje);
        this.signo = new SimpleStringProperty(signo);

        
    }

   

    public IntegerProperty getIteracion() {
        return iteracion;
    }

    public void setIteracion(IntegerProperty iteracion) {
        this.iteracion = iteracion;
    }

    public DoubleProperty getXl() {
        return xl;
    }

    public void setXl(DoubleProperty xl) {
        this.xl = xl;
    }

    public DoubleProperty getXu() {
        return xu;
    }

    public void setXu(DoubleProperty xu) {
        this.xu = xu;
    }

    public DoubleProperty getXr() {
        return xr;
    }

    public void setXr(DoubleProperty xr) {
        this.xr = xr;
    }

    public DoubleProperty getFxr() {
        return fxr;
    }

    public void setFxr(DoubleProperty fxr) {
        this.fxr = fxr;
    }

    public DoubleProperty getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(DoubleProperty porcentaje) {
        this.porcentaje = porcentaje;
    }

    public StringProperty getSigno() {
        return signo;
    }

    public void setSigno(StringProperty signo) {
        this.signo = signo;
    }

    

}
