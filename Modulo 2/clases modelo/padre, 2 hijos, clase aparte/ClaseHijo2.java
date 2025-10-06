public class ClaseHijo2 extends ClasePadre
{
    private int VariableF;
    
    public ClaseHijo2(){};
    public ClaseHijo2(int VariableA, String VariableB, String VariableC, int VariableD, int VariableE, int VariableF){
        super(VariableA, VariableB, VariableC, VariableD, VariableE);
        this.VariableF = VariableF; 
    }
    
    public int getVariableF()
    {
        return VariableF;
    }
    
    public String toString()
    {
        return super.toString() + "; VariableF" + VariableF;
    }
}
