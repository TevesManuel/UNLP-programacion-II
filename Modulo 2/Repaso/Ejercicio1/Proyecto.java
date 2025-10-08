public class Proyecto
{
    private String nombre;
    private int codigo;
    private String nombreDir;
    private Investigador [] investigadores = new Investigador[50];
    private int cantInvestigadores = 0;
    
    public Proyecto(){};
    public Proyecto(String nombre, int codigo, String nombreDir){
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreDir = nombreDir;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    public int getCodigo()
    {
        return codigo;
    }
    public String getNombreDir()
    {
        return nombreDir;
    }
    public Investigador getInvestigador(int i)
        {
            return investigadores[i];
        }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public void setNombreDir(String nombreDir)
    {
        this.nombreDir = nombreDir;
    }
    public void agregarInvestigador(Investigador investigador, int i)
    {
        this.investigadores[i] = investigador;
        cantInvestigadores++;
    }
    
    public String toString()
    {
        return (" nombre " + nombre + " codigo " + codigo + " nombreDir " + nombreDir);
    }
    
    private double dineroTotalOtorgado()
    {
        double sum = 0; 
        for(int i = 0; i <= cantInvestigadores; i++)
        {
            int j = investigadores[i].getCantSubsidios();
            int x;
            for (x = 0; x <= j; x++);
            {
                sum += investigadores[i].getSubsidio(x).getMonto();
            }
        }
        return sum;
    }
}
