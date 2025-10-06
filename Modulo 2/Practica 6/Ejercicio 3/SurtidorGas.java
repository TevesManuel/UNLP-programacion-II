public class SurtidorGas extends Surtidor
{
    private int clientes;
    private int clientesMax;
    
    public SurtidorGas(){};
    public SurtidorGas(int dni, String nombre, String apellido, int numero, int importe, int cliente, int clienteMax){
        super(dni, nombre, apellido, numero, importe);
        this.clientes = clientes;
        this.clientesMax = clienteMax;
    }
    
    public int getClientes()
    {
        return clientes;
    }
    public int getClientesMax()
    {
        return clientesMax;
    }
    
    public String toString()
    {
		return super.toString() + " cargo a " + clientes + " clientes, " + "su maximo de clientes es de " + clientesMax;
    }
    
    public int calcularImpuesto()
    {
        int resultado = 0;
        if (clientes <= 5)
        {
            resultado = super.getImporte();
            resultado -= resultado * 5 / 100;
        }
        else if(clientes <= 15)
            {
                resultado = super.getImporte();
                resultado -= resultado * 3 / 100;
            }
            else
            {
                resultado = super.getImporte();
                resultado -= resultado * 1.5 / 100;
            }
        return resultado;
    }
}
