import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        // Variables y clases//
        Scanner in = new Scanner(System.in);int Va;
        String nombre;
        int DNI;
        int edad; 
        int sueldo;
        int goles;
        int partidos;
        int torneos;

        System.out.print("Ingrese nombre: ");
        nombre = in.nextLine();
        System.out.print("Ingrese Dni: ");
        DNI = in.nextInt();
        System.out.print("Ingrese Edad: ");
        edad = in.nextInt();
        System.out.print("Ingrese Sueldo: ");
        sueldo = in.nextInt();
        System.out.print("Ingrese cantidad de Goles: ");
        goles = in.nextInt();
        System.out.print("Ingrese la cantidad de Partidos: ");
        partidos = in.nextInt();
        Persona J = new Jugador(nombre,DNI,edad,sueldo,goles,partidos);
        
        System.out.print("Ingrese nombre: ");
        nombre = in.nextLine();
        System.out.print("Ingrese Dni: ");
        DNI = in.nextInt();
        System.out.print("Ingrese Edad: ");
        edad = in.nextInt();
        System.out.print("Ingrese Sueldo: ");
        sueldo = in.nextInt();
        System.out.print("Ingrese catidad de torneos: ");
        torneos = in.nextInt();
        Persona E = new Entrenador(nombre,DNI,edad,sueldo,torneos);
        
        System.out.println("Entrenador: " + E.calcularSueldoACobrar());
        System.out.println("Jugador: " + J.calcularSueldoACobrar());        
    }
}