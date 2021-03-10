/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javil
 */
public class Automata {
    
    private ArbolSintactico arbolGenerador;
    private ArrayList<Estado> tablaTransicioens;
    
    public Automata(ArbolSintactico arbolGenerador, HashMap<Integer, ArrayList> tablaSiguientes){
        this.arbolGenerador = arbolGenerador;
    }
    
    private void generarTablaTransiciones(){
        
        // Primer estado son los primeros del nodo raiz
        Estado primero = new Estado(0);
        primero.setSiguientes(arbolGenerador.raiz.getPrimeros());
        
        // Se agregan los lexemas que corresponden al estado
        for (Object idHoja : arbolGenerador.raiz.getPrimeros()){
            Integer id = (Integer)idHoja;
            Nodo nodo = arbolGenerador.obtenerNodoConId(id, arbolGenerador.raiz);
            
            primero.agregarLexema(nodo.getToken());
        }
        this.tablaTransicioens.add(primero);
        // Obtener los siguientes estados
        
        generarEstados(primero.getSiguientes());
        
    }
    
    // Genera los estados 
    public Integer agregarEstado(ArrayList<Integer> siguientes){
        
        // Si el estado para esos siguientes ya existe no se crea
        
        for ( Estado estado : estados){
            if (siguientes == estado.getSiguientes()){
                return estado.getNombre();
            }
        }
        
        Integer nombreEstado = this.estados.size();
        Estado nuevoEstado = new Estado(nombreEstado);
        nuevoEstado.setSiguientes(siguientes);
        
        estados.add(nuevoEstado);
        return nuevoEstado.getNombre();
    }
    
    public Estado buscarEstados(ArrayList<Integer> siguientesHojas){
        
    }
    
    // Retorna el siguiente estado
    private Integer tran(Integer estado, int siguiente){
        Set<Integer> llaves = transiciones.keySet();
        // Si no se han añadido estados
        if (llaves.size() == 0 ){
            return 0;
        } else {
            for ( Integer llave: llaves ){
                if ( sig(siguiente) == transiciones.get(llave)){
                    return llave;
                }
            }
            
            return llaves.size();
        }
    }
    
    private ArrayList sig(int i){
        return this.tablaSiguientes.get(i);
    }
    
    public void ejecutarDotTablaTransiciones(String nombre) throws IOException, InterruptedException {
        String file_input_path = nombre;
        String [] comando = {"dot", "-Tpng","Salida\\ArchivosDot\\"+nombre+".dot", "-o","Salida\\Transiciones\\"+ nombre + ".png"};
         Process p = Runtime.getRuntime().exec(comando); 
        int err = p.waitFor(); 
    }
    
    public String generarTablaTransiciones(String nombre){
        String texto = "digraph Transiciones{arset [label=<\n" +
"        <TABLE ALIGN=\"LEFT\">\n";
        
        Set<Integer> llaves = this.tablaSiguientes.keySet();
        
        for ( Integer llave : llaves) {
            texto += "<TR> \n" + 
        "               <TD>" + this.arbolGenerador.obtenerNodoConId(llave, arbolGenerador.raiz).getToken() + "</TD>";
        }
        Set<Integer> estados = this.transiciones.keySet();
        for (Integer estado : estados ){
            texto+= "<TR>\n" +
        "                <TD>"+llave+"</TD>\n" +
        "                <TD>"+this.obtenerNodoConId(llave, raiz).getToken()+"</TD>\n" +
        "                <TD>"+siguientes.get(llave)+"</TD>\n" +
        "            </TR>";
        }
        
        texto += "</TABLE>\n" +
                    "    >, ];}";
        
        return texto;
    }
}
