public class ClaseHijo1 extends ClasePadre
{
    private int VariableF;
    private int VariableG;
    
    public ClaseHijo1(){};
    public ClaseHijo1(int VariableA, String VariableB, String VariableC, int VariableD, int VariableE, int VariableF, int VariableG){
        super(VariableA, VariableB, VariableC, VariableD, VariableE);
        this.VariableF = VariableF;
        this.VariableG = VariableG;
    }
    
    public int getVariables()
    {
        return VariableF;
    }
    public int getVariablex()
    {
        return VariableG;
    }
    
    public String toString()
    {
        return super.toString() + "; VariableF:  " + VariableF + "; VariableG: " + VariableG;
    }
}
