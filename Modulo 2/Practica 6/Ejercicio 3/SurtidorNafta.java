public class SurtidorNafta extends Surtidor
{
    private int litros;
    
    public SurtidorNafta(){};
    public SurtidorNafta(int dni, String nombre, String apellido, int numero, int importe, int litros){
        super(dni, nombre, apellido, numero, importe);
        this.litros = litros; 
    }
    
    public int getLitros()
    {
        return litros;
    }
    
    public String toString()
    {
		return super.toString() + " tiene " + litros + " litros";
    }
    
    public int calcularImpuesto()
    {
        int importe = super.getImporte();
        return importe - importe * litros * 2 / 100;
    }
}
