/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */

public class Micro
{
    private String patente;
    private String destino;
    private String horaSalida;
    private int asientos;
    
    public Micro(String patente, String destino, String horaSalida, int asientos) {
        this.patente    = patente;
        this.destino    = destino;
        this.horaSalida = horaSalida;
        this.asientos   = asientos;
    }
    
    public Micro(String patente, String destino, String horaSalida) {
        this(patente, destino, horaSalida, 0);
    }
    
    public Micro(String patente, String destino) {
        this(patente, destino, null, 0);
    }
    
    public Micro() {
        this(null, null);
    }
    
    public void setPatente(String p) {
        this.patente = p;
    }
    
    public String getPatente() {
        return this.patente;
    }
    
    public void setDestino(String d) {
        this.destino = d;
    }
    
    public String getDestino() {
        return this.destino;
    }
    
    public String toString() {
        return "Patente: " + this.patente + ", destino: " + this.destino + ", horaSalida: " + this.horaSalida;
    }
}