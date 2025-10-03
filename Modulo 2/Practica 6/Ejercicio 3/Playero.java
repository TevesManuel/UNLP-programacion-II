public class Playero
{
    private int DNI;
    private String nombre;
    private String apellido;
    
    public Playero(){};
    public Playero(int dni, String nombre, String apellido){
        this.DNI = dni;
        this.nombre = nombre;
        this.apellido = apellido; 
    }
    
    public int getDNI()
    {
        return DNI;
    }   
    public String getNombre()
    {
        return nombre;
    }
    public String getApellido()
    {
        return apellido;
    }
    public void setDNI(int dni)
    {
        this.DNI = dni;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setApellido(String apellido)
    {
        this.apellido = apellido; 
    }
    
    public String toString()
    {
		return "nombre: " + nombre + " " + apellido + "; DNI: " + DNI;
    }
}
