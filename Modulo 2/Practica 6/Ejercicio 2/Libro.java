
/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */
public class Libro extends Ejemplar
{
    private String titulo;
    private int cantidadCapitulos;
    private boolean esEdicionBolsillo;
    
    public Libro(int codigo, int cantPags, String resumen, int anioPublicacion, 
                 Responsable responsable, String titulo, int cantidadCapitulos, boolean esEdicionBolsillo) {
        super(codigo, cantPags, resumen, anioPublicacion, responsable);
        this.titulo = titulo;
        this.cantidadCapitulos = cantidadCapitulos;
        this.esEdicionBolsillo = esEdicionBolsillo;
    }
    
    public Libro(int codigo, int cantPags, String resumen, Responsable responsable, 
                 String titulo, int cantidadCapitulos, boolean esEdicionBolsillo) {
        super(codigo, cantPags, resumen, responsable);
        this.titulo = titulo;
        this.cantidadCapitulos = cantidadCapitulos;
        this.esEdicionBolsillo = esEdicionBolsillo;
    }
    
    public String toString() {
        Responsable responsable = this.getResponsable();
        return "Libro:\n\tCodigo identificatorio: " + this.getCodigo() + "\n\tTitulo: " + this.titulo + "\n\tResponsable"
        + responsable.getNombre() + " " + responsable.getApellido();
    }
    
    public void publicar() {
        this.setAnioPublicacion(2025);
        if (this.esEdicionBolsillo) {
            this.titulo += " - De Bolsillo";    
        }
    }
    
}