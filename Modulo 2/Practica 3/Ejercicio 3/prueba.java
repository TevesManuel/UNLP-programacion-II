import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Persona Entrenador = new Persona();
        String nombre;
        int sueldo;
        int campeonatos;
        
        System.out.print("Ingrese el nombre: ");
        nombre = in.next();
        Entrenador.setNombre(nombre);
        System.out.print("Ingrese el suedo sin el plus: ");
        sueldo = in.nextInt();
        Entrenador.setSueldo(sueldo);
        System.out.print("Ingrese la cantidad de campeonatos ganados: ");
        campeonatos = in.nextInt();
        Entrenador.setCantidad(campeonatos);
        
        String texto = Entrenador.toString();
        System.out.print(texto);
        
    }
}