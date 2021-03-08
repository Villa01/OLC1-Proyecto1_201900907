
package Estructuras;


public class Hoja extends Nodo{
    
    private int id;

    public Hoja(int id, String token, String lexema, boolean anulable, Nodo hijoI, Nodo hijoD) {
        super(token, "", anulable, hijoI, hijoD);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
