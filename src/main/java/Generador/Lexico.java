package Generador;

import java.io.File;

/**
 *
 * @author Erick Villatoro
 */
public class Lexico {
    
    public static void main(String[] args) {
        String path = "src/main/java/Analizadores/lexico.jflex";
        generarLexer(path);
    }
    
    public static void generarLexer( String path){
        File file = new File(path);
        jflex.Main.generate(file);
    }
}
