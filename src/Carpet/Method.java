package Carpet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lsmp.djep.djep.*;
import org.nfunk.jep.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.table.DefaultTableModel;
import org.nfunk.jep.ParseException;

public class Method{

public ObservableList<PojoPrimary> Biseccion(double xl,double xu,double Ea,Pila pila,String ecuacion){
double fxl=pila.Ecuacion(ecuacion, xl);
double porcentaje=100,xr,fxr,xrant=0;
String signo="";

int i=1;
ObservableList<PojoPrimary> pojos = FXCollections.observableArrayList();
do{

xr=(xl+xu)/2;
fxr=pila.Ecuacion(ecuacion, xr);

if(i!=1){

porcentaje = (xr-xrant)/xr*100; 

}
if((fxr*fxl)>0){

signo = "Positivo";
pojos.add(new PojoPrimary(i, xl, xu, xr, fxr, porcentaje, signo));
xl=xr;
fxl=fxr;

}else{

signo = "Negativo";
pojos.add(new PojoPrimary(i, xl, xu, xr, fxr, porcentaje, signo));
xu=xr;

}

i++;
xrant = xr;


}while(Math.abs(porcentaje)>Ea);



return pojos;
}



public ObservableList<PojoPrimary> MetodoFalsaPosicion(double xl,double xu,double Ea,Pila pila,String ecuacion){

    ObservableList<PojoPrimary> ppf = FXCollections.observableArrayList();
    double porcentaje=100,xr,xrant=0,fxr,fxl,fxu;
     String signo="";
    int i=1;
    fxu=pila.Ecuacion(ecuacion, xu);
    fxl=pila.Ecuacion(ecuacion, xl);
    do{
        
        xr=xu-fxu*(xl-xu)/(fxl-fxu);
        fxr=pila.Ecuacion(ecuacion, xr);
       
        
        porcentaje=(xr-xrant)/xr*100;
        
        if((fxr*fxl)>0){

        signo = "Positivo";
        ppf.add(new PojoPrimary(i, xl, xu, xr, fxr, porcentaje, signo));
        xl=xr;
        fxl=fxr;

        }else{

        signo = "Negativo";
        ppf.add(new PojoPrimary(i, xl, xu, xr, fxr, porcentaje, signo));
        xu=xr;
        fxu=fxr;
        }
        
        xrant=xr;
        i++;
        
    }while(Math.abs(porcentaje)>Ea);
    
    
return ppf;
}


public String DerivadaFuncion(String ecuacion){

    DJep dj = new DJep();
    
    dj.addStandardConstants();
    dj.addStandardFunctions();
    dj.addComplex();
    dj.setAllowUndeclared(true);
    dj.setAllowAssignment(true);
    dj.setImplicitMul(true);
    
    try {
        Node parse = dj.parse(ecuacion);
        Node diff = dj.differentiate(parse, "x");
        Node simp= dj.simplify(diff);
        ecuacion = dj.toString(simp);
        
    } catch (ParseException ex) {
        Logger.getLogger(Method.class.getName()).log(Level.SEVERE, null, ex);
    }

return ecuacion;
}

public ObservableList<PojoSecond> MetodoNewtonRaphson(String ecuacion,double xo,double porcentaje){

    ObservableList<PojoSecond> mnr= FXCollections.observableArrayList();
    
    String derivada = DerivadaFuncion(ecuacion);
    
    

return mnr;
}


public ObservableList<PojoPrimary> MetodoSecante(double x1,double x0,double Ea,Pila pila,String ecuacion){

    ObservableList<PojoPrimary> pojo = FXCollections.observableArrayList();
    
    double porcentaje=100,fx1,xr,fxr,fx0,xrant=0;
    int i=0;
    fx0=pila.Ecuacion(ecuacion, x0);
       
    do{
    
       fx1=pila.Ecuacion(ecuacion, x1);
       
       
       xr=x1-fx1*(x0-x1)/(fx0-fx1);
       fxr=pila.Ecuacion(ecuacion,xr);
       
       porcentaje = (xr-xrant)/xr*100;
       
       pojo.add(new PojoPrimary(i, x0, x1, fx1, xr, porcentaje, null));
       
       x0=x1;
       fx0=fx1;
       
       x1=xr;
       fx1=fxr;
    
       xrant=xr;
       i++;
       
    }while(Math.abs(porcentaje)>Ea);
    
    return pojo;

}

}