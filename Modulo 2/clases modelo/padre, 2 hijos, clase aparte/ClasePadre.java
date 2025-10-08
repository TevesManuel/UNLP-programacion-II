public abstract class ClasePadre
{
    private int VariableA;
    private int VariableB;
    Clase1 nameClase1 = new Clase1(0," ", " ");
    
    public ClasePadre(){};
    public ClasePadre(int VariableP1,String VariableP2,String VariableP3, int VariableA, int VariableB){
        this.nameClase1.setVariableA(VariableP1);
        this.nameClase1.setVariableB(VariableP2);
        this.nameClase1.setVariableC(VariableP3);
        this.VariableA = VariableA;
        this.VariableB = VariableB;
    }
    
    public int getVariableA()
    {
        return VariableA;
    }   
    public int getVariableB()
    {
        return VariableB;
    }
    
    public void setVariableA(int VariableA)
    {
        this.VariableA = VariableA;
    }
    public void setVariableB(int VariableB)
    {
        this.VariableB = VariableB;
    }
    
    public String toString()
    {
        return "nameClase1:" + nameClase1.toString() + ". ClasePadre: " + "; VariableA: " + VariableA + "; VariableB: " + VariableB + ".";
    }
}