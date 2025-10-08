
/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */
public abstract class Ejemplar
{
    private int codigo;
    private int cantPags;
    private String resumen;
    private int anioPublicacion;
    private Responsable responsable;
    
    public Ejemplar(int codigo, int cantPags, String resumen, int anioPublicacion, Responsable responsable) {
        this.codigo = codigo;
        this.cantPags = cantPags;
        this.resumen = resumen;
        this.anioPublicacion = anioPublicacion;
        this.responsable = responsable;
    }
    
    public Ejemplar(int codigo, int cantPags, String resumen, Responsable responsable) {
        this(codigo, cantPags, resumen, 0, responsable);
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public Responsable getResponsable() {
        return this.responsable;
    }
    
    public void setAnioPublicacion(int anio) {
        this.anioPublicacion = anio;
    }
    
    public boolean estaPublicado() {
        return (this.anioPublicacion == 0);
    }
    
    public abstract void publicar();
    public abstract String toString();
}