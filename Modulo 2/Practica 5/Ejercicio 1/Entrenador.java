public class Entrenador extends Persona
{
    private int torneos;
    
    public Entrenador(){};
    public Entrenador(String n, int d, int e, int s, int t)
    {
        super (n,d,e,s);
        this.torneos = t;
    }
    
    public int getTorneos()
    {
        return torneos;
    }
    
    public void setTorneos(int T)
    {
        torneos = T;
    }
    
       public int Plus()
    {
        int p = 0; 
        if ((1<=torneos) && (torneos<=4))
            p = 5000;
        else
        {
            if ((5<=torneos) && (torneos<=10))
                p = 30000;
            else
            {
                if (10<torneos)
                    p = 50000;
            }
        }
        return p;
    }
}
