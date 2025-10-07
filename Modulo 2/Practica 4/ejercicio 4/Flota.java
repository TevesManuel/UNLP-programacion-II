/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */
public class Flota
{
    final static int DIMF = 15;
    
    private Micro [] micros;
    private int dimL;

    public Flota()
    {
        this.micros = new Micro[DIMF];
        this.dimL = 0;
        for(int i = 0; i < DIMF; i++) {
            this.micros[i] = null;
        }
    }
    
    public boolean estaLlena() {
        return (this.dimL == DIMF);
    }
    
    public void agregarMicro(Micro m) {
        this.micros[this.dimL] = m;
        this.dimL++;
    }
    
    public boolean eliminarMicro(String patente) {
        boolean eliminado = false;
        for(int i = 0; i < this.dimL; i++) {
            if(this.micros[i].getPatente().equals(patente)) {
                this.micros[i] = null;
                eliminado = true;
                for(i=i+1; i < this.dimL; i++) {
                    this.micros[i-1] = this.micros[i];
                }
                this.micros[i] = null;
                this.dimL--;
            }
        }
        return eliminado;
    }
    
    public Micro buscarPatente(String patente) {
        Micro salida = null;
        for(int i = 0; i < this.dimL; i++) {
            if(this.micros[i].getPatente().equals(patente))
                salida = this.micros[i];
        }
        return salida;
    }
    
    public Micro buscarDestino(String destino) {
        Micro salida = null;
        for(int i = 0; i < this.dimL; i++) {
            if(this.micros[i].getDestino().equals(destino))
                salida = this.micros[i];
        }
        return salida;
    }
    
    public String toString() {
        String salida = "Micros (" + this.dimL + "):\n";
        for(int i = 0; i < this.dimL; i++) {
            salida += this.micros[i] + "\n"; 
        }
        return salida;
    }
}