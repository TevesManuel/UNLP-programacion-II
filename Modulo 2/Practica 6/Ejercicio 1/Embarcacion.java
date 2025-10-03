public class Embarcacion extends Vehiculo
{
    private String REY;
    private String tipo;
    private int eslora;
    private int peso;
    private int valor;
    private double importePlus;
    
    public Embarcacion(int año, double importe, int cit, String nombre, String apellido,String r, String t, int e, int p, int v)
    {
        super(año,importe,cit,nombre,apellido);
        this.REY = r;
        this.tipo = t;
        this.eslora = e;
        this.peso = p;
        this.valor = v;
    }
    
    public String getREY()
    {
        return REY;
    }   
    public String getTipo()
    {
        return tipo;
    }
    public int getEslora()
    {
        return eslora;
    }
    public int getPeso()
    {
        return peso;
    }
    public int getValor()
    {
        return valor;
    }
    
    public void setREY(String r)
    {
        REY = r;
    }
    public void setTipo(String t)
    {
        tipo = t;
    }
    public void setEslora(int e)
    {
        eslora = e;
    }
    public void setpeso(int p)
    {
        peso = p;
    }
    public void setValor(int v)
    {
        valor = v;
    }
    
    public double calcularImporte()
    {
        
        if (valor <= 6000) {
            importePlus = valor * 0.04;
        } else if (valor <= 180000) {
            importePlus = valor * 0.02;
        } else {
            importePlus = valor * 0.05;
        }
        return super.getImporte() + importePlus;
    }
}
