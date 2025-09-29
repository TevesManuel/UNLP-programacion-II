public class Micro
{
    private boolean [] asientos;
    private String patente;
    private String destino;
    private String horario;
    private int asientosOcupados;
    
    public Micro(){};
    public Micro(String p, String d, String h)
    {
        this.patente = p;
        this.destino = d;
        this.horario = h;
        asientosOcupados = 20;
        asientos = new boolean[20];
        for (int i = 0; i < 20; i++)
        {
            liberarAsiento(i);
        }
    }
    
    public String getPatente()
    {
        return patente;
    }   
    public String getDestino()
    {
        return destino;
    }
    public String getHorario()
    {
        return horario;
    }
    public void setPatente(String P)
    {
        patente = P;
    }
    public void setDestino(String D)
    {
        destino = D;
    }
    public void setHorario(String H)
    {
        horario = H;
    }
    public int getAsientosOcupados()
    {
        return asientosOcupados;
    }
    
    
    public boolean estaLleno()
    {
        return asientosOcupados == 19;
    }
    public boolean validarAsiento(int i)
    {
        return (((i>=0) && (i<20)) || (i == -1));
    }
    public boolean estadoAsiento(int i)
    {
        return asientos[i];
    }
    public void ocuparAsiento(int i)
    {
        asientos[i] = false;
        asientosOcupados++;
    }
    public void liberarAsiento(int i)
    {
        asientos[i] = true;
        asientosOcupados--;
    }
    public int primerAsientoLibre()
    {
        int i = 0;
        while((asientos[i] == false) && (i<20))
        {
            i++;
        }
        asientos[i] = false;
        return i;
    }
    
}