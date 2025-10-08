
/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */
public class Responsable
{
    private int dni;
    private String nombre;
    private String apellido;
    
    public Responsable(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }
}