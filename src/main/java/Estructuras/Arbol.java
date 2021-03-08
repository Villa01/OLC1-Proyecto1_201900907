
package Estructuras;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Arbol {
    
    public Nodo raiz;
    
    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }
    

    public String prefijo(Nodo nodo) {
        String texto = "";
        
        if (nodo != null) {
            texto += " " +  nodo.getToken();
            texto += " " + this.prefijo(nodo.getHijoI());
            texto += " " + this.prefijo(nodo.getHijoD());
        }
        
        return texto;
    }
    
    public String postfijo(Nodo nodo) {
        String texto = "";
        
        if (nodo != null) {
            texto += " " + this.prefijo(nodo.getHijoI());
            texto += " " + this.prefijo(nodo.getHijoD());
            texto += " " +  nodo.getToken();
        }
        
        return texto;
    }
    
    public String infijo(Nodo nodo) {
        String texto = "";
        
        if (nodo != null) {
            texto += " " + this.prefijo(nodo.getHijoI());
            texto += " " +  nodo.getToken();
            texto += " " + this.prefijo(nodo.getHijoD());
        }
        
        return texto;
    }
}


