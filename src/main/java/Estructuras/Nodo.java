
package Estructuras;

import java.util.ArrayList;


public class Nodo {
    
    private String token;
    private String lexema;
    private boolean anulable;
    private Nodo hijoI, hijoD;
    private ArrayList<Nodo> hijos;
    private ArrayList<Integer> primeros;
    private ArrayList<Integer> ultimos;

    public Nodo(String token, String lexema, boolean anulable, Nodo hijoI, Nodo hijoD) {
        
        this.token = token;
        this.lexema = lexema;
        this.hijoD = hijoD;
        this.hijoI = hijoI;
        this.anulable = anulable;
        hijos = new ArrayList<Nodo>();
        if (this.hijoI != null){
            this.hijos.add(hijoI);
            
        }
        if (this.hijoD != null){
            this.hijos.add(hijoD);
        } 
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public Nodo getHijoI() {
        return hijoI;
    }

    public void setHijoI(Nodo hijoI) {
        this.hijoI = hijoI;
    }

    public Nodo getHijoD() {
        return hijoD;
    }

    public void setHijoD(Nodo hijoD) {
        this.hijoD = hijoD;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(ArrayList<Integer> primeros) {
        this.primeros = primeros;
    }

    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }

    public void setUltimos(ArrayList<Integer> ultimos) {
        this.ultimos = ultimos;
    }
    
}
