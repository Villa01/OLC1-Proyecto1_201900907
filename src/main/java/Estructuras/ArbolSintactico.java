
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Estructuras.Hoja;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        nodoTerm = nodoTerm.replace("\n", "\\ n");
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
                case "+":
                    if (!nodo.getHijoI().isAnulable()){
                        nodo.setAnulable(false);
                    } else {
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
    
    public String generarTablaSiguientes(String nombre){
        String texto = "digraph Arbol_Sintactico{arset [label=<\n" +
"        <TABLE ALIGN=\"LEFT\">\n" +
"            <TR>\n" +
"                <TD>Hojas</TD>\n" +
"                <TD>Lexema</TD>\n" +
"                <TD>Siguientes</TD>\n      "+
"            </TR>";
        HashMap siguientes = generarSiguientesEnTabla(this.raiz);
        Set<Integer> llaves = siguientes.keySet();
        for (Integer llave : llaves ){
            texto+= "<TR>\n" +
        "                <TD>"+llave+"</TD>\n" +
        "                <TD>"+this.obtenerNodoConId(llave, raiz).getToken()+"</TD>\n" +
        "                <TD>"+siguientes.get(llave)+"</TD>\n" +
        "            </TR>";
        }
        
        texto += "</TABLE>\n" +
                    "    >, ];}";
        
        this.GenerarDot(texto, nombre);
        try {
            ejecutarDotTablaSiguientes(nombre);
        } catch (IOException ex) {
            Logger.getLogger(ArbolSintactico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArbolSintactico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
    
    
    public HashMap generarSiguientesEnTabla(Nodo nodo){
        HashMap<Integer, ArrayList> siguientes = new HashMap();
        
        if ( nodo != null) {
            if (nodo.getClass() == Hoja.class){

                Hoja hoja = (Hoja)nodo;
                siguientes.put(hoja.getId(), null);
            }
            HashMap sigIz = generarSiguientesEnTabla(nodo.getHijoI());
            HashMap sigDer = generarSiguientesEnTabla(nodo.getHijoD());
            
            Set<Integer> llavesIz = sigIz.keySet();
            Set<Integer> llavesDer = sigDer.keySet();
            Set<Integer> llavesSig = siguientes.keySet();
            
            Set<Integer> llaves = new HashSet<Integer>();
            
            llaves.addAll(llavesIz);
            llaves.addAll(llavesDer);
            llaves.addAll(llavesSig);
            
            System.out.println("Las llaves son " + llaves + " en el nodo con lexema " + nodo.getToken());
            for (Integer llave : llaves ){
                if (siguientes.get(llave)!= null){
                    ArrayList datosSigIz = (ArrayList)sigIz.get(llave);
                    ArrayList lista = siguientes.get(llave);
                    if ( datosSigIz != null){
                        lista.addAll(datosSigIz);
                    }
                    
                    siguientes.put(llave, lista);
                } else {
                    siguientes.put(llave, (ArrayList)sigIz.get(llave));
                }
                if (siguientes.get(llave)!= null){
                    ArrayList datosSigDer = (ArrayList)sigDer.get(llave);
                    ArrayList lista = siguientes.get(llave);
                    if ( datosSigDer != null){
                        lista.addAll(datosSigDer);
                    }
                    siguientes.put(llave, lista);
                } else {
                    siguientes.put(llave, (ArrayList)sigDer.get(llave));
                }
            }
            
             switch (nodo.getToken()) {
                case "*": 
                    
                    ArrayList ultimosN = nodo.getUltimos();
                    for ( Object ultimo : ultimosN){
                        Integer i  = (Integer)ultimo;
                        
                        if (siguientes.get(i) != null){
                            ArrayList ultimosAnt = siguientes.get(ultimo);
                            ultimosN.addAll(ultimosAnt);
                            
                        }
                        siguientes.put(i, ultimosN);
                    }
                    
                    break;
                case "+": 
                    
                    ArrayList ultimosn = nodo.getUltimos();
                    for ( Object ultimo : ultimosn){
                        Integer i  = (Integer)ultimo;
                        
                        if (siguientes.get(i) != null){
                            ArrayList ultimosAnt = siguientes.get(ultimo);
                            ultimosn.addAll(ultimosAnt);
                            
                        }
                        siguientes.put(i, ultimosn);
                    }
                    
                    break;
                case ".":
                    ArrayList ultimosC1 = nodo.getHijoI().getUltimos();
                    ArrayList primerosC2 = nodo.getHijoD().getPrimeros();
                    for ( Object ultimo : ultimosC1 ) {
                        Integer i = (Integer)ultimo;
                        
                        if (siguientes.get(i)!=null){
                            ArrayList unidos = unirArrayList(siguientes.get(i), primerosC2);
                            siguientes.put(i, unidos);
                        } else{
                            siguientes.put(i, primerosC2);
                        }
                    }
                    
                    break;
                
             }
        }
        System.out.println("Los siguientes son "+siguientes);
        return siguientes;
    }
    
    
    public void ejecutarDotTablaSiguientes(String nombre) throws IOException, InterruptedException {
        String file_input_path = nombre;
        String [] comando = {"dot", "-Tpng","Salida\\ArchivosDot\\"+nombre+".dot", "-o","Salida\\Siguientes\\"+ nombre + ".png"};
         Process p = Runtime.getRuntime().exec(comando); 
        int err = p.waitFor();
    }
    
    public Nodo obtenerNodoConId(int id, Nodo nodo){
        Nodo retorno = null;
        if (nodo != null ){
            Nodo nodoIz = obtenerNodoConId(id, nodo.getHijoI());
            Nodo nodoDer = obtenerNodoConId(id, nodo.getHijoD());
            if (nodo.getClass() == Hoja.class){
                Hoja hoja = (Hoja)nodo;
                if (hoja.getId() == id ){
                    retorno = nodo;
                }
            } else if (nodoIz != null){
                retorno = nodoIz;
            }else if (nodoDer != null){
                retorno = nodoDer;
            }
        }
        
        return retorno;
    }
    
    public ArrayList unirArrayList(ArrayList a, ArrayList b){
        
        Set setA = new LinkedHashSet<>(a);
        setA.addAll(b);
        ArrayList combinacion = new ArrayList<>(setA);
         
        
        return combinacion;
    }
    
}
