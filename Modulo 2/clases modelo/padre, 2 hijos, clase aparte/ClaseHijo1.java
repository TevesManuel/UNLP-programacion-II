public class ClaseHijo1 extends ClasePadre
{
    private int clientes;
    private int clientesMax;
    
    public ClaseHijo1(){};
    public ClaseHijo1(int VariableA, String VariableB, String VariableC, int VariableD, int VariableE, int VariableF, int VariableG){
        super(VariableA, VariableB, VariableC, VariableD, VariableE);
        this.clientes = clientes;
        this.clientesMax = VariableG;
    }
    
    public int getVariables()
    {
        return clientes;
    }
    public int getVariablex()
    {
        return clientesMax;
    }
    
    public String toString()
    {
        return super.toString() + " cargo a " + clientes + " clientes, " + "su maximo de clientes es de " + clientesMax;
    }
}
