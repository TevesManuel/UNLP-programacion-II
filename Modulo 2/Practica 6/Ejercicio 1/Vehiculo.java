public abstract class Vehiculo
{
    private int año;
    private double importe;
    private Propietario propietario = new Propietario();
    
    public Vehiculo (int año, double importe, int cit, String nombre, String apellido)
    {
        this.año = año;
        this.importe = importe;
        propietario.setCIT(cit);
        propietario.setApellido(apellido);
        propietario.setNombre(nombre);
    }
    
    
    public void setPropietario(Propietario propietario){
    this.propietario=propietario;
    }
    public void setAño(int año){
    this.año=año;
    }
    public void setImporte(double importe){
    this.importe=importe;
    }
    
    
    public int getAño(){
    return año;
    }
    public double getImporte(){
    return importe;
    }
    public Propietario getPropietario(){
    return propietario;
    }
    
    public abstract double calcularImporte();
}
