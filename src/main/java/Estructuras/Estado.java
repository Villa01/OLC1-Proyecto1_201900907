/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author javil
 */
public class Estado {
    private int nombre;
    private ArrayList<String> lexemas;
    private ArrayList<Integer> siguientes;
    private ArrayList<Transicion> transiciones;

    public Estado(int nombre) {
        this.nombre = nombre;
        this.lexemas = new ArrayList<String>();
        this.transiciones = new ArrayList<Transicion>();
        this.siguientes = new ArrayList<Integer>();
    }
    
    public void agregarTransicion(Transicion tran, int posicion){
        if ( posicion > this.transiciones.size()){
            for (int i = 0; i < posicion; i++) {
                try{
                    Transicion prueba = this.transiciones.get(i);
                } catch( Exception e){
                    this.transiciones.add(null);
                }
            }
        }
        this.transiciones.add(posicion, tran);
    }
    
    public void agregarLexema(String lexema){
        this.lexemas.add(lexema);
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getLexemas() {
        return lexemas;
    }

    public void setLexemas(ArrayList<String> lexemas) {
        this.lexemas = lexemas;
    }

    public ArrayList<Integer> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<Integer> siguientes) {
        this.siguientes = siguientes;
    }

    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(ArrayList<Transicion> transiciones) {
        this.transiciones = transiciones;
    }
    
    
}
