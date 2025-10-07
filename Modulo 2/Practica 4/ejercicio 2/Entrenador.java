public class Entrenador
{
    private String nombre;
    private double sueldo;
    private int cantidadCG;
    
    public Entrenador(){
        this.sueldo = 0;
        this.nombre = "null";
        this.cantidadCG = 0;
    };
    public Entrenador(String nombre, double sueldo, int cantidadCG){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.cantidadCG = cantidadCG;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }   
    public double getSueldo()
    {
        return this.sueldo;
    }
    public int getCantidadCG()
    {
        return this.cantidadCG;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setSueldo(double sueldo)
    {
        this.sueldo = sueldo;
    }
    public void setCantidadCG(int cantidadCG)
    {
        this.cantidadCG = cantidadCG;
    }
    public String toString()
    {
		return (" nombre " + nombre + " sueldo " + sueldo + " cantidadCG " + cantidadCG);
    }
}