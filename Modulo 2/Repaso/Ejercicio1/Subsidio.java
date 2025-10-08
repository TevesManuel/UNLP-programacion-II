public class Subsidio
{
    private String nombre;
    private double monto;
    private boolean otorgado;
    
    public Subsidio(){};
    public Subsidio(String nombre, int monto){
        this.nombre = nombre;
        this.monto = monto;
        this.otorgado = false;
    }
    
    public String getNombre()
    {
        return nombre;
    }   
    public double getMonto()
    {
        return monto;
    }
    public boolean geteOtorgado()
    {
        return otorgado;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setMonto(double monto)
    {
        this.monto = monto;
    }
    public void setOtorgado(boolean otorgado)
    {
        this.otorgado = otorgado;
    }
    public String toString()
    {
        return (" nombre " + nombre + " monto " + monto + " otorgado " + otorgado);
    }
}
