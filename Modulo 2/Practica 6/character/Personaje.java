public abstract class Personaje
{
    private int vida;
    private int vidaMax;
    private int nivel;
    private String nombre;
    private boolean derrotado = false;
    private boolean veneno;
    private int dañoPotencial;
    
    public Personaje(){};
    public Personaje(int vidaMax, int nivel, String nombre, boolean veneno){
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
        this.nivel = nivel;
        this.nombre = nombre;
        this.veneno = veneno;
    }
    
    public int getVidaMax()
    {
        return vidaMax;
    } 
    public int getVida()
    {
        return vida;
    }   
    public int getNivel()
    {
        return nivel;
    }
    public String getNombre()
    {
        return nombre;
    }
    public boolean getVeneno()
    {
        return veneno;
    }
    public boolean getDerrotado()
    {
        return derrotado;
    }
    public int getDañoPotencial()
    {
        return dañoPotencial;
    } 
    
    
    public void setVida(int vida)
    {
        this.vida = vida;
    }
    public void setVidaMax(int vidaMax)
    {
        this.vidaMax = vidaMax;
    }
    public void setNivel(int nivel)
    {
        this.nivel = nivel;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setVeneno(boolean veneno)
    {
        this.veneno = veneno;
    }
    public void getDañoPotencial(int dañoPotencial)
    {
        this.dañoPotencial = dañoPotencial;
    } 

    public void subaNivel()
    {
        nivel++;
        vida += 10;
        vidaMax += 10;
    }
    
    public void recibiDdaño(int daño)
    {
        if (veneno) 
        {
            daño -= 5;
        }
        if (daño > vida)
        {
            daño = vida;
            derrotado = true;
        }
        vida -= daño;
    }
    
    public abstract void ataqueEspecial();
}