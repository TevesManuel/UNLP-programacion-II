public class Automotor extends Vehiculo
{
    private String patente;
    private double importePlus;
    private String descripcion;
    
    public Automotor(int año, double importe, int cit, String nombre, String apellido,String p, double ip, String d)
    {
        super(año,importe,cit,nombre,apellido);
        this.patente = p;
        this.importePlus = ip;
        this.descripcion = d;
    }
    
    public String getPatente()
    {
        return patente;
    }   
    public double getImportePlus()
    {
        return importePlus;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setPatente(String p)
    {
        patente = p;
    }
    public void setImportePlus(double ip)
    {
        importePlus = ip;
    }
    public void setDescripcion(String d)
    {
        descripcion = d;
    }
    
    public double calcularImporte()
    {
        return super.getImporte() + importePlus;
    }
}