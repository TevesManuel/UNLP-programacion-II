public class Guerrero extends Personaje
{
    private int fuerza;
    
    public Guerrero(){};
    public Guerrero(int vidaMax, int nivel, String nombre, boolean veneno, int fuerza)
    {
        super(vidaMax, nivel, nombre, veneno);
        this.fuerza = fuerza;
    }
     int getFuerza()
    {
        return fuerza;
    }
    
    public void ataqueEspecial()
    {
        super.getDañoPotencial(fuerza * 2);
    }
}
