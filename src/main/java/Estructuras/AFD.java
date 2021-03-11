/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author javil
 */
public class AFD extends Automata{
    
    
    public AFD(ArbolSintactico arbol, HashMap tabla){
        super(arbol, tabla);
        
    }
    
    public String escribirDot(String nombre){
        String texto = "digraph " + nombre + " {\n\trankdir = \"LR\";\n";
        for (Estado estado : this.getTablaTransiciones()){
            texto += "\tnode[shape=circle];";
            
            for(Transicion tran : estado.getTransiciones()){
                if ( tran != null ){
                    tran.setLexema(tran.getLexema().replace("\"", ""));
                    texto += "\tS"+ estado.getNombre() +" -> S"+tran.getSiguiente().getNombre() +"[label=\""+tran.getLexema()+"\"];\n";
                }
            }
        }
        
        texto += "}";
        generarDotAFD(texto, nombre);
        return texto;
    }
    
    private void generarDotAFD(String cadena, String nombre){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try{
            fichero = new FileWriter("Salida\\ArchivosDot\\"+nombre + ".dot");
            escritor = new PrintWriter(fichero);
            escritor.println(cadena);
            escritor.close();
            fichero.close();
            ejecutarDotAFD(nombre);
        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }
    
    public void ejecutarDotAFD(String nombre) throws IOException, InterruptedException {
        String file_input_path = nombre;
        String [] comando = {"dot", "-Tpng","Salida\\ArchivosDot\\"+nombre+".dot", "-o","Salida\\AFD\\"+ nombre + ".png"};
         Process p = Runtime.getRuntime().exec(comando); 
        int err = p.waitFor(); 
    }
}
