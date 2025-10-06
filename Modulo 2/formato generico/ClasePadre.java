public abstract class ClasePadre
{
    private int VariableA;
    private int VariableB;
    private int VariableC;
    
    public ClasePadre(){};
    public ClasePadre(int VariableA, int VariableB, int VariableC){
        this.VariableA = VariableA;
        this.VariableB = VariableB;
        this.VariableC = VariableC;
    }
    
    public int getVariableA()
    {
        return VariableA;
    }   
    public int getVariableB()
    {
        return VariableB;
    }
    public int getVariableC()
    {
        return VariableC;
    }
    public void setVariableA(int VariableA)
    {
        this.VariableA = VariableA;
    }
    public void setVariableB(int VariableB)
    {
        this.VariableB = VariableB;
    }
    public void setVariableC(int VariableC)
    {
        this.VariableC = VariableC;
    }
    public String toString()
    {
		return (" VariableA " + VariableA + " VariableB " + VariableB + " VariableC " + VariableC);
    }
}
