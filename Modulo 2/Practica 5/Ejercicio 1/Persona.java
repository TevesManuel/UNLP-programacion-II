public abstract class Persona {
    private String nombre;
    private int DNI;
    private int edad; 
    private int sueldo;
    
    public Persona(String unNombre, int unDNI, int unaEdad, int unsueldo){
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad;
        sueldo = unsueldo;
    }
    public Persona(){
     
    }
    
    public int getDNI() {
        return DNI;
    }
    public int getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getSueldo() {
        return sueldo;
    }
    
    public void setDNI(int unDNI) {
        DNI = unDNI;
    }
    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }
    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    public void setSueldo(int unSueldo) {
        sueldo = unSueldo;
    }
    
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años, mi sueldo es de " + calcularSueldoACobrar() + ".";
        return aux;
    }
    
    public abstract int Plus();
    
    public int calcularSueldoACobrar()
    {
       return sueldo + Plus();
    }
}