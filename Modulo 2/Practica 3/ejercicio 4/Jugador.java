public class Jugador {
    private String nombre;
    private int DNI;
    private int edad; 
    private int partidosJugados;
    private int golesAnotados;
    
    public Jugador(String unNombre, int unDNI, int unaEdad, int partidosJugados, int golesAnotados){
        this.nombre = unNombre;
        this.DNI = unDNI;
        this.edad = unaEdad;
        this.partidosJugados = partidosJugados;
        this.golesAnotados = golesAnotados;
    }

    public int getGolesAnotados() {
        return this.golesAnotados;
    }
    
    public int getPartidosJugados() {
        return this.partidosJugados;
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

    public void setGolesAnotados(int ga) {
        this.golesAnotados = ga;
    }
    
    public void setPartidosJugados(int pj) {
        this.partidosJugados = pj;
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
    
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
        return aux;
    }
    
    
    
    
}
