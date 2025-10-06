public class Mago extends Personaje
{
    private int poderMAgico;
    
    public Mago(){};
    public Mago(int vidaMax, int nivel, String nombre, boolean veneno, int poderMAgico)
    {
        super(vidaMax, nivel, nombre, veneno);
        this.poderMAgico = poderMAgico;
    }
     int getPoderMAgico()
    {
        return poderMAgico;
    }
    
    public void ataqueEspecial()
    {
        super.getDañoPotencial(poderMAgico * 2);
    }
}
