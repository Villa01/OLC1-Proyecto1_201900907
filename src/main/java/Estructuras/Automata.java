/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javil
 */
public class Automata {

    public ArrayList<Estado> getTablaTransiciones() {
        return tablaTransiciones;
    }

    public void setTablaTransiciones(ArrayList<Estado> tablaTransiciones) {
        this.tablaTransiciones = tablaTransiciones;
    }

    public String[] getLexemas() {
        return lexemas;
    }

    public void setLexemas(String[] lexemas) {
        this.lexemas = lexemas;
    }
    
    private final ArbolSintactico arbolGenerador;
    private ArrayList<Estado> tablaTransiciones;
    private final HashMap<Integer, ArrayList> tablaSiguientes;
    private String[] lexemas;
    
    public Automata(ArbolSintactico arbolGenerador, HashMap<Integer, ArrayList> tablaSiguientes){
        this.arbolGenerador = arbolGenerador;
        this.tablaSiguientes = tablaSiguientes;
        this.tablaTransiciones = new ArrayList<>();
        generarListaLexemas();
    }
    
    public void generarListaLexemas(){
        Set<Integer> llaves = tablaSiguientes.keySet();
        ArrayList<String> listaLexemas = new ArrayList<String>();
        String validar = "";
        for (Integer llave : llaves){
            Nodo temp = arbolGenerador.obtenerNodoConId(llave, arbolGenerador.raiz);
            String lexema = temp.getToken();
            if ( !lexema.equals(validar) && !lexema.equals("#")){
                listaLexemas.add(lexema);
                validar = lexema;
            }
        }
        this.lexemas = new String[listaLexemas.size()];
        for (int i = 0; i < this.lexemas.length; i++) {
            this.lexemas[i] = listaLexemas.get(i);
        }
    }
    
    public void generarTablaTransiciones(){
        
        System.out.println("\n\nNueva tabla \n\n");
        
        // Primer estado son los primeros del nodo raiz
        Estado primero = new Estado(0);
        primero.setSiguientes(arbolGenerador.raiz.getPrimeros());
        
        // Se agregan los lexemas que corresponden al estado
        for (Object idHoja : arbolGenerador.raiz.getPrimeros()){
            Integer id = (Integer)idHoja;
            Nodo nodo = arbolGenerador.obtenerNodoConId(id, arbolGenerador.raiz);
            
            primero.agregarLexema(nodo.getToken());
        }
        this.tablaTransiciones.add(primero);// Obtener los siguientes estados
        LinkedList cola = new LinkedList();
        cola.add(1);
        int contador = 0;
        ArrayList<Integer> siguientes = null;
        do{
            
            Estado estado = this.tablaTransiciones.get(contador);
            if (estado.getSiguientes() ==null){
                break;
            }
            for (int i = 0; i < estado.getSiguientes().size(); i++) {
                siguientes = tran(estado,(int)cola.getFirst());
                cola.removeFirst();
                if(siguientes != null ){
                    
                    for (int j = 0; j < siguientes.size(); j++) {
                        cola.add(siguientes.get(j));
                    }
                }
            }
            contador ++;
        } while( cola.size() > 0 );
        
    }
    
    
    public ArrayList<Integer> tran(Estado estado, int i){
        ArrayList<Integer> siguientes = sig(i);
        Estado estadoPrueba = existeEstado(siguientes);
        String lexema = this.arbolGenerador.obtenerNodoConId(i, arbolGenerador.raiz).getToken();
        System.out.println("Existe el estado? " + estadoPrueba);
        if (lexema == "#"){
            return null;
        }
            
        if (estadoPrueba == null){ // SI el estado no existe
            Estado nuevoEstado = new Estado(this.tablaTransiciones.size());
            nuevoEstado.setSiguientes(siguientes);
            Transicion nuevaTranscion = new Transicion(estado, nuevoEstado,lexema );
            System.out.println("Cree el estado "+ nuevoEstado + " sus siguientes son " + siguientes);
            int posicion = obtenerPosicionLexemas(lexema);
            estado.agregarTransicion(nuevaTranscion, posicion);
            this.tablaTransiciones.add(nuevoEstado);
            
        } else { // Si el estado ya existe
            Transicion nuevaTranscion = new Transicion(estado, estadoPrueba,lexema );
            int posicion = obtenerPosicionLexemas(lexema);
            estado.agregarTransicion(nuevaTranscion, posicion);
            //estado.agregarTransicion(nuevaTranscion, i);
            return null;
        }
        //System.out.println("El estado es " + estado.getNombre() + " y sus siguientes son " + estado.getSiguientes());
        return siguientes;
    }
    // Si ya existe el estado lo devuelve, sino devuelve null
    private Estado existeEstado(ArrayList<Integer> siguientes) {
        //System.out.println("Tabla de transiciones "+ this.tablaTransiciones);
        Estado retorno = null;
        int iteraciones = 0;
        if (siguientes == null){ // Para el ultimo nodo
            return retorno;
        }
        for (Estado estTemp : this.tablaTransiciones){
                System.out.println("Evaluando el estado " + estTemp + " que tiene los siguientes " + estTemp.getSiguientes());
            if ( estTemp.getSiguientes().size() == siguientes.size()){
                System.out.println(this.tablaTransiciones);
                for ( Estado estado : this.tablaTransiciones){
                    
                    System.out.print(" " + estado.getSiguientes());
                    System.out.println("");
                }
                System.out.println("Los siguientes son "+ siguientes + " y los siguientes del estado son "+ estTemp.getSiguientes());
                boolean esIgual = false;
                
                
                int limite = (siguientes.size()>=estTemp.getSiguientes().size())?siguientes.size():estTemp.getSiguientes().size();
                for (int i = 0; i < limite; i++) {
                    if ((int)estTemp.getSiguientes().get(i) == (int)siguientes.get(i)){
                        System.out.println((int)estTemp.getSiguientes().get(i) + " es igual a " + (int)siguientes.get(i) + " " + ((int)estTemp.getSiguientes().get(i) == (int)siguientes.get(i)));
                        esIgual = true;
                    } else {
                        esIgual = false;
                    }
                }
                System.out.println("El contador es  " + limite);
                if (esIgual){
                    retorno = estTemp;
                    break;
                }
            } 
            iteraciones ++;
        }
        return retorno;
    }
    
    public ArrayList<Integer> sig(int i){
        return this.tablaSiguientes.get(i);
    }
    
    public Integer obtenerPosicionLexemas(String texto){
        
        String imprimir = "Los lexemas son [";
        for(String lexema : this.lexemas){
            imprimir += " "+ lexema;
        }
        System.out.println(imprimir);
        Integer contador = 0;
        String validar = "";
        
        while(contador < this.lexemas.length && !texto.equals( this.lexemas[contador])){
            contador++;
        }
        //System.out.println("La posicion del siguiente estado "+ texto+" es "+ contador);
        
        return contador;
    }
    
    public void ejecutarDotTablaTransiciones(String nombre) throws IOException, InterruptedException {
        String file_input_path = nombre;
        String [] comando = {"dot", "-Tpng","Salida\\ArchivosDot\\"+nombre+".dot", "-o","Salida\\Transiciones\\"+ nombre + ".png"};
         Process p = Runtime.getRuntime().exec(comando); 
        int err = p.waitFor(); 
    }
    
    public String generarTablaTransicionesDot(String nombre){
        String texto = "digraph Transiciones{arset [style=\"dotted\" label=<\n" +
        "<TABLE ALIGN=\"LEFT\">\n";
        
        texto += "\t<TR>\n\r\t\t<TD> Estado</TD>\n ";
        String verificador = "";
        for ( String lexema : this.lexemas) {
            if ( !lexema.equals(verificador) && !lexema.equals("#")){
                texto += "\t\t<TD>" + lexema + "</TD>\n";
                verificador = lexema;
            }
        }
        texto += "\t</TR>\n";
        imprimirTablaTransiciones();
        for (Estado estado : this.tablaTransiciones ){
            texto+= "\t<TR>\n" +
            "\t\t<TD>S"+estado.getNombre() + estado.getSiguientes() + "</TD>\n";
            for ( int i = 0; i < this.lexemas.length-1; i++){
                Transicion tran = null;
                if (estado.getTransiciones().size()-1 > i){
                    tran = estado.getTransiciones().get(i);
                }
                
                if ( tran == null){
                    texto += "\t\t<TD> - </TD>\n";
                } else {
                    texto += "\t\t<TD>"+tran.getSiguiente().getNombre()+"</TD>\n";
                }
            }
            texto += "\t</TR>\n";
        }
        
        texto += "</TABLE>\n" +
                    "    >, ];}";
        //System.out.println(texto);
        this.GenerarDot(texto, nombre);
        try {
            ejecutarDotTablaTransiciones(nombre);
        } catch (IOException ex) {
            Logger.getLogger(Automata.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Automata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return texto;
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
            ejecutarDotTablaTransiciones(nombre);
        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }

    private void imprimirTablaTransiciones(){
        System.out.println("Imprimiendo una tabla de tansiciones");
        for(Estado estado: tablaTransiciones){
            System.out.print("S"+estado.getNombre()+ "  ");
            for(Transicion tran : estado.getTransiciones()){
                if (tran != null) {
                    Estado siguiente = tran.getSiguiente();
                    System.out.print(siguiente.getNombre() + "  ");
                }else{
                    System.out.print(" - ");
                }
            }
                    
                System.out.println("");
        }
    }
    
    private int[][] convertirAMatriz(){
        int[][] matriz = new int[this.tablaTransiciones.size()][this.lexemas.length];
        
        for (int i = 0; i < this.tablaTransiciones.size(); i++) {
            for (int j = 0; j < this.lexemas.length; j++) {
                Estado estado = this.tablaTransiciones.get(i);
                Transicion trans = estado.getTransiciones().get(j);
                Estado estadoSiguiente = trans.getSiguiente();
                if (trans == null ){
                    matriz[i][j] = -1;
                } else{
                    matriz[i][j] = estadoSiguiente.getNombre();
                }
                
            }
        }
        
        return matriz;
    }
    

}
