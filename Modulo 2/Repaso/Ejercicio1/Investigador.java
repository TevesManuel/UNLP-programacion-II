public class Investigador
{
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio [] subsidios = new Subsidio[5];
    private int cantSubsidios = 0;
    
    public Investigador(){};
    public Investigador(String nombre, int categoria, String especialidad){
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
    }
    
    public String getNombre()
    {
        return nombre;
    }   
    public int getCategoria()
    {
        return categoria;
    }
    public String getEspecialidad()
    {
        return especialidad;
    }
    public Subsidio getSubsidio(int i)
        {
            return subsidios[i];
        }
    public int getCantSubsidios()
        {
            return cantSubsidios;
        }
    
    public void setNombre(String nombre)
    {
    this.nombre = nombre;
    }
    public void setCategoria(int categoria)
    {
        this.categoria = categoria;
    }
    public void setEspecialidad(String especialidad)
    {
        this.especialidad = especialidad;
    }
    public void agregarSubsidio(Subsidio subsidio, int i)
    {
        this.subsidios[i] = subsidio;
        cantSubsidios++;
    }
    
    public String toString()
    {
        return (" nombre " + nombre + " categoria " + categoria + " especialidad " + especialidad);
    }
}
