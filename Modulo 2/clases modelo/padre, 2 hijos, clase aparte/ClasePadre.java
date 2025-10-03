public abstract class ClasePadre
{
    private int VariableA;
    private int VariableB;
    Clase1 playero = new Clase1(0," ", " ");
    
    public ClasePadre(){};
    public ClasePadre(int dni,String nombre,String apellido, int VariableA, int VariableB){
        this.playero.setVariableA(dni);
        this.playero.setVariableB(nombre);
        this.playero.setVariableC(apellido);
        this.VariableA = VariableA;
        this.VariableB = VariableB;
    }
    
    public int getVariableD()
    {
        return VariableA;
    }   
    public int getVariableE()
    {
        return VariableB;
    }
    
    public void setVariableD(int VariableA)
    {
        this.VariableA = VariableA;
    }
    public void setVariableE(int VariableB)
    {
        this.VariableB = VariableB;
    }
    
    public String toString()
    {
        return "playero:" + playero.toString() + ". ClasePadre: " + " VariableA: " + VariableA + ".";
    }
}