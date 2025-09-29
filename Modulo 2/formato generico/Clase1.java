public class Clase1
{
    private int VariableA;
    private int VariableB;
    private int VariableC;
    
    public Clase1(){};
    public Clase1(int va, int vb, int vc){
        this.VariableA = va;
        this.VariableB = vb;
        this.VariableC = vc;
    }
    
    public int getMetodoA()
    {
        return VariableA;
    }   
    public int getMetodoB()
    {
        return VariableB;
    }
    public int getMetodoC()
    {
        return VariableC;
    }
    public void setMetodoA(int LadoA)
    {
        VariableA = LadoA;
    }
    public void setMetodoB(int LadoB)
    {
        VariableB = LadoB;
    }
    public void setMetodoC(int LadoC)
    {
        VariableC = LadoC;
    }
}