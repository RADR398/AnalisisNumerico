/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carpet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Delgado
 */
public class Pila {
	
	class Nodo {
	    char simbolo;
	    Nodo sig;
	}
	
    private Nodo raiz;
    
    public Pila () {
            try {
                raiz=null;
                Contenido();
            } catch (IOException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void insertar(char x) {
    	Nodo nuevo;
        nuevo = new Nodo();
        nuevo.simbolo = x;
        if (raiz==null)
        {
            nuevo.sig = null;
            raiz = nuevo;
        }
        else
        {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }
    
    public char extraer ()
    {
        if (raiz!=null)
        {
            char informacion = raiz.simbolo;
            raiz = raiz.sig;
            return informacion;
        }
        else
        {
            return Character.MAX_VALUE;
        }
    }  
    
    public boolean vacia() {
        if (raiz==null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean balanceada(String cadena) {
        Pila pila1;  
    	pila1 = new Pila ();    
    	
    	for (int f = 0 ; f < cadena.length() ; f++)
    	{
    	    if (cadena.charAt(f) == '(' || cadena.charAt(f) == '[' || cadena.charAt(f) == '{') {
    	    	pila1.insertar(cadena.charAt(f));
    	    } else {
    	    	if (cadena.charAt(f)==')') {
    	    	    if (pila1.extraer()!='(') {
    	    	        return false;
    	    	    }
    	     	} else {
    	    	    if (cadena.charAt(f)==']') {
    	    	        if (pila1.extraer()!='[') {
    	    	            return false;
    	    	        }
    	    	    } else {
    	    	        if (cadena.charAt(f)=='}') {
    	    	            if (pila1.extraer()!='{') {
    	    	                return false;
    	    	            }
    	    	        }
    	    	    }
    	        }
   	    }   
        }
    	if (pila1.vacia()) {
    	    return true;
    	} else {
   	    return false;
    	}
    }
    private String contenido="";
    public void Contenido() throws FileNotFoundException, IOException {
      
      String cadena,archivo=new File ("").getAbsolutePath ()+"\\src\\Carpet\\Funciones.txt";
      
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
         contenido+=cadena+"\n";
      }
      b.close();
      
}
    
    public String Modificacion(String cadena){
    int inicio=0,medio=0,val=0;
    String signo="";
    
    for(int i=0;i<cadena.length();i++){
    
        String temp=cadena.substring(i, i+1);
        if(temp.equals("^")){
        
            val=1;
            medio=i;
        
        }
        
        if(temp.equals("+") || temp.equals("*") || temp.equals("/") || temp.equals("-") || temp.equals("(")){
        
        if(val==1){
        
            cadena=cadena.substring(0,inicio)+"Math.pow("+cadena.substring(inicio,medio)+","+cadena.substring(medio+1, i)+")"+cadena.substring(i, cadena.length());
            val=0;
            inicio=i+1;
        }else{
        
            inicio=i+1;
            
        }
        
        
        }
        if(val==1 && cadena.length()==(i+1)){
        
        
        cadena=cadena.substring(0,inicio)+"Math.pow("+cadena.substring(inicio,medio)+","+cadena.substring(medio+1, cadena.length())+")";
        
        val=0;
        
        }
    
    
    }
        System.out.println(cadena);
    return cadena;
    }
    
    public double Ecuacion(String funcion,double val){
                double ret=0;
            try {
                
                String cadena = contenido+Modificacion(funcion);
                System.out.println(contenido);
                ScriptEngineManager manager=new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName ("js");
                engine.put("x", val);
                
                ret = Double.parseDouble(engine.eval(cadena).toString());
            } catch (ScriptException ex) {
                Logger.getLogger(Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    return ret;
    }
}

