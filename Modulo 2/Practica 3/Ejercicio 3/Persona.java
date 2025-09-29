public class Persona {
    private String nombre;
    private int sueldo;
    private int campeonatos; 
    
    public Persona(String unNombre, int unSueldo, int unaCantidad){
        nombre = unNombre;
        sueldo = unSueldo;
        campeonatos = unaCantidad; 
    }
    
    public Persona(){
     
    }

    public int getSueldo() {
        return sueldo;
    }

    public int getCantidad() {
        return campeonatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSueldo(int unSueldo) {
        sueldo = unSueldo;
    }

    public void setCantidad(int unaCantidad) {
        campeonatos = unaCantidad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi sueldo es " + calcularSueldoACobrar() + " y tengo " + campeonatos + " campeonatos ganados.";
        return aux;
    } 
    
    private int Plus()
    {
        int p = 0; 
        if ((1<=campeonatos) && (campeonatos<=4))
            p = 5000;
        else
        {
            if ((5<=campeonatos) && (campeonatos<=10))
                p = 30000;
            else
            {
                if (10<campeonatos)
                    p = 50000;
            }
        }
        return p;
    }
    
    public int calcularSueldoACobrar()
    {
        int r = sueldo + Plus();
        return r;
    }
}