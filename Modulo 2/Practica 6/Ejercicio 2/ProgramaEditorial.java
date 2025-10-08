
/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */
public class ProgramaEditorial
{
    private final static int DIMF = 1000;
    private int dimL;
    private Ejemplar [] ejemplares;
    
    public ProgramaEditorial() {
        this.ejemplares = new Ejemplar[this.DIMF];
        this.dimL = 0;
    }
    
    public void run() {
        //Basicamente hago un read de todo y despues lo guardo, despues hago un for por la dimL y voy imprimiendo
    }
    
    public static void main(String args[]) {
        ProgramaEditorial program = new ProgramaEditorial();
        program.run();
    }
}