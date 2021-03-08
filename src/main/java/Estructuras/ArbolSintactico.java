
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Estructuras.Hoja;
import java.util.ArrayList;
import java.util.LinkedList;


public class ArbolSintactico extends Arbol {
    
    public ArbolSintactico(Nodo raiz) {
        super(raiz);
    }
    
    public void agregarSimboloFinal(){
        int idHoja = obtenerUltimoId(this.raiz, 1) +1;
        Hoja hoja = new Hoja(idHoja, "#", "#", false, null, null);
        Nodo nuevaRaiz = new Nodo(".", "", false, this.raiz, hoja);
        
        this.raiz = nuevaRaiz;   
    }
    
    public int obtenerUltimoId(Nodo nodo, int ultimoId){
        if(nodo != null){
            if (nodo.getClass() == Hoja.class){
                Hoja hoja = (Hoja)nodo;
                if (hoja.getId() > ultimoId){
                    ultimoId = hoja.getId();
                }
            
            }
            ultimoId = obtenerUltimoId(nodo.getHijoI(), ultimoId);
            ultimoId = obtenerUltimoId(nodo.getHijoD(), ultimoId);
        }
        
        return ultimoId;
    }
    
    public void GraficarSintactico(String nombre){
        String grafica = "digraph Arbol_Sintactico{\n\n node[style=rounded shape=record]\n" + GraficaNodos(this.raiz, "0") + "\n\n}";        
        GenerarDot(grafica, nombre);

    }
    
    private String GraficaNodos(Nodo nodo, String i){
        int k=0; 
        int id = 0;
        if (nodo.getClass() == Hoja.class){
            Hoja hoja = (Hoja)nodo;
            id = hoja.getId();
        }
        String r = "";
        String nodoTerm = nodo.getToken();
        nodoTerm = nodoTerm.replace("\"", "");
        r= "node" + i + "[label = \"{"+nodo.isAnulable()+"|{"+nodo.getPrimeros()+"|"+nodoTerm+"|"+nodo.getUltimos()+"}|"+id+"}\"];\n";
        
        System.out.println("El texto dentro de graphviz es " + r);
        for(int j =0 ; j<=nodo.getHijos().size()-1; j++){
            r += "node" + i + " -> node" + i + k + "\n";
            r += GraficaNodos(nodo.getHijos().get(j), ""+i+k);
            k++;
        }
        
        if( !(nodo.getLexema().equals("")) ){
            String nodoToken = nodo.getLexema();
            nodoToken = nodoToken.replace("\"", "");
            r += "node" + i + "c[label = \"" + nodoToken + "\"];\n";
            r += "node" + i + " -> node" + i + "c\n";
        }
        
        return r;
    }
    
    private void GenerarDot(String cadena, String nombre){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try{
            fichero = new FileWriter("Salida\\ArchivosDot\\"+nombre + ".dot");
            escritor = new PrintWriter(fichero);
            escritor.println(cadena);
            escritor.close();
            fichero.close();
            ejecutarDot(nombre);
        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }
    
    public void ejecutarDot(String nombre) throws IOException, InterruptedException {
        String file_input_path = nombre;
        String [] comando = {"dot", "-Tpng","Salida\\ArchivosDot\\"+nombre+".dot", "-o","Salida\\Imagenes\\"+ nombre + ".png"};
         Process p = Runtime.getRuntime().exec(comando); 
        int err = p.waitFor();
    }
    
    public void generarAnulables(Nodo nodo){
        if (nodo != null){
            generarAnulables(nodo.getHijoD());
            generarAnulables(nodo.getHijoI());
            switch (nodo.getToken()) {
                case "*":
                    nodo.setAnulable(true);
                    break;
                case "?":
                    nodo.setAnulable(true);
                    break;
                case "|":
                    if (nodo.getHijoD().isAnulable() || nodo.getHijoI().isAnulable()){
                        nodo.setAnulable(true);
                    }
                    break;
                case ".":
                    if (nodo.getHijoD().isAnulable() && nodo.getHijoI().isAnulable()){
                        nodo.setAnulable(true);
                    }
                    break;
                default:
                    nodo.setAnulable(false);
                    break;
            }
        }
    }
    
    public ArrayList obtenerPrimeros(Nodo nodo){
        
        ArrayList nueva = new ArrayList<Integer>();
        if (nodo != null){
            ArrayList primerosIzq = obtenerPrimeros(nodo.getHijoI());
            ArrayList primerosDer = obtenerPrimeros(nodo.getHijoD());
            switch (nodo.getToken()) {
                case "*": 
                    nueva.addAll(primerosIzq);
                    break;
                case "?":
                    nueva.addAll(primerosIzq);
                    break;
                case "+":
                    nueva.addAll(primerosIzq);
                    break;
                case "|":
                    nueva.addAll(primerosIzq);
                    nueva.addAll(primerosDer);
                    break;
                case ".":
                    if(nodo.getHijoI().isAnulable()){
                        nueva.addAll(primerosIzq);
                        nueva.addAll(primerosDer);
                        
                    } else {
                        nueva.addAll(primerosIzq);
                    }
                    break;
                
                default:
                    if (nodo.getClass() == Hoja.class){

                        Hoja hoja = (Hoja)nodo;
                        nueva.add(hoja.getId());
                    }
                    break;
            }
            nodo.setPrimeros(nueva);
        }
        return nueva;
    }
    
    public ArrayList obtenerUltimos(Nodo nodo){
        ArrayList nueva = new ArrayList<Integer>();
        if (nodo != null){
            ArrayList ultimosIzq = obtenerUltimos(nodo.getHijoI());
            ArrayList ultimosDer = obtenerUltimos(nodo.getHijoD());
            switch (nodo.getToken()) {
                case "*": 
                    nueva.addAll(ultimosIzq);
                    break;
                case "?":
                    nueva.addAll(ultimosIzq);
                    break;
                case "+":
                    nueva.addAll(ultimosIzq);
                    break;
                case "|":
                    nueva.addAll(ultimosIzq);
                    nueva.addAll(ultimosDer);
                    break;
                case ".":
                    if(nodo.getHijoD().isAnulable()){
                        nueva.addAll(ultimosIzq);
                        nueva.addAll(ultimosDer);
                        
                    } else {
                        nueva.addAll(ultimosDer);
                    }
                    break;
                
                default:
                    if (nodo.getClass() == Hoja.class){

                        Hoja hoja = (Hoja)nodo;
                        nueva.add(hoja.getId());
                    }
                    break;
            }
            nodo.setUltimos(nueva);
        }
        return nueva;
    }
}
