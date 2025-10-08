public class ClaseHijo extends ClasePadre
{
    private int VariableD;
    private int VariableE;
    private int VariableF;
    
    public ClaseHijo(){};
    public ClaseHijo(int VariableA, int VariableB, int VariableC, int VariableD, int VariableE, int VariableF){
        super (VariableA, VariableB, VariableC);
        this.VariableD = VariableD;
        this.VariableE = VariableE;
        this.VariableF = VariableF;
    }
    
    public int getVariableD()
    {
        return VariableD;
    }   
    public int getVariableE()
    {
        return VariableE;
    }
    public int getVariableF()
    {
        return VariableF;
    }
    public void setVariableD(int VariableD)
    {
        this.VariableD = VariableD;
    }
    public void setVariableE(int VariableE)
    {
        this.VariableE = VariableE;
    }
    public void setVariableF(int VariableF)
    {
        this.VariableF = VariableF;
    }
    public String toString()
    {
        return super.toString() + "; VariableD: " + VariableD + "; VariableE: " + VariableE + "; VariableF: " + VariableF;
    }
}
