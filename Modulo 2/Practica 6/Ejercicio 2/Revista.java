
/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */
public class Revista extends Ejemplar
{
    private String nombre;
    private int nroVolumen;
    private int cantArt;
    
    public Revista(int codigo, int cantPags, String resumen, int anioPublicacion, 
                 Responsable responsable, String nombre, int nroVolumen, int cantArt) {
        super(codigo, cantPags, resumen, anioPublicacion, responsable);
        this.nombre = nombre;
        this.nroVolumen = nroVolumen;
        this.cantArt = cantArt;
    }
    
    public Revista(int codigo, int cantPags, String resumen, Responsable responsable,
                 String nombre, int nroVolumen, int cantArt) {
        super(codigo, cantPags, resumen, 0, responsable);
        this.nombre = nombre;
        this.nroVolumen = nroVolumen;
        this.cantArt = cantArt;
    }
    
    public String toString() {
        return "Libro:\n\tNombre: " + this.nombre + "\n\tNumero de volumen: " + this.nroVolumen;   
    }
    
    public void publicar() {
        this.setAnioPublicacion(2025);
        this.nroVolumen = Generador.getNroVolumen();
    }

}