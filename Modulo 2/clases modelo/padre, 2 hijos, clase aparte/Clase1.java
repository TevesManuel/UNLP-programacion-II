public class Clase1
{
    private int VariableA;
    private String VariableB;
    private String VariableC;
    
    public Clase1(){};
    public Clase1(int VariableA, String VariableB, String VariableC){
        this.VariableA = VariableA;
        this.VariableB = VariableB;
        this.VariableC = VariableC; 
    }
    
    public int getVariableA()
    {
        return VariableA;
    }   
    public String getVariableB()
    {
        return VariableB;
    }
    public String getVariableC()
    {
        return VariableC;
    }
    public void setVariableA(int VariableA)
    {
        this.VariableA = VariableA;
    }
    public void setVariableB(String VariableB)
    {
        this.VariableB = VariableB;
    }
    public void setVariableC(String VariableC)
    {
        this.VariableC = VariableC; 
    }
    
    public String toString()
    {
		return "VariableB: " + VariableB + " " + VariableC + "; VariableA: " + VariableA;
    }
}
