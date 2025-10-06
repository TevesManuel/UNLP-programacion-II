public class Jugador extends Persona
{
    private int partidos;
    private int goles;
    
    public Jugador(){};
    public Jugador(String n, int d,int e, int s, int g, int p)
    {
        super (n,d,e,s);
        this.goles = g;
        this.partidos = p;
    }
    
    public int getGoles()
    {
        return goles;
    }   
    public int getPartidos()
    {
        return partidos;
    }
    
    public void setGoles(int G)
    {
        goles = G;
    }
    public void setMetodoB(int P)
    {
        partidos = P;
    }
    
    private double promedio()
    {
        return goles / partidos;
    }
    
    public int Plus()
    {
        if (promedio() > 0.5)
        {
           return getSueldo(); 
        }
        else
            return 0;
    }
}