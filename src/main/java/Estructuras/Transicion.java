/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author javil
 */
public class Transicion {
    private Estado anterior;
    private Estado siguiente;
    private String lexema;

    public Transicion(Estado anterior, Estado siguiente, String lexema) {
        this.anterior = anterior;
        this.siguiente = siguiente;
        this.lexema = lexema;
    }

    public Estado getAnterior() {
        return anterior;
    }

    public void setAnterior(Estado anterior) {
        this.anterior = anterior;
    }

    public Estado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Estado siguiente) {
        this.siguiente = siguiente;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
    
}
