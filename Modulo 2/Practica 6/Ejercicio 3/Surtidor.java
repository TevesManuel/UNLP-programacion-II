public abstract class Surtidor
{
    private int numero;
    private int importe;
    Playero playero = new Playero(0," ", " ");
    
    public Surtidor(){};
    public Surtidor(int dni,String nombre,String apellido, int numero, int importe){
        this.playero.setDNI(dni);
        this.playero.setNombre(nombre);
        this.playero.setApellido(apellido);
        this.numero = numero;
        this.importe = importe;
    }
    
    public int getNumero()
    {
        return numero;
    }   
    public int getImporte()
    {
        return importe;
    }
    
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    public void setImporte(int importe)
    {
        this.importe = importe;
    }
    
    public String toString()
    {
		return "playero:" + playero.toString() + ". Surtidor: " + " numero: " + numero + "; importe final: $" + calcularImpuesto() + ";";
    }
    
    public abstract int calcularImpuesto();
}