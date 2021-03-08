
package Estructuras;


public class ExpresionRegular {
    
    public ArbolSintactico arbol;
    public String id;

    public ExpresionRegular(ArbolSintactico arbol, String id) {
        this.arbol = arbol;
        this.id = id;
    }

    public ArbolSintactico getArbol() {
        return arbol;
    }

    public void setArbol(ArbolSintactico arbol) {
        this.arbol = arbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
