import java.util.Scanner;
public class ejer1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String Nombre;
        int DNI;
        int Edad;
        String Texto;
        Persona P= new Persona();
        
        System.out.print("ingrese su nombre: ");
        Nombre = in.next();
        System.out.print("ingrese su DNI: ");
        DNI = in.nextInt();
        System.out.print("ingrese su edad: ");
        Edad = in.nextInt();
        P.setNombre(Nombre);
        P.setDNI(DNI);
        P.setEdad(Edad);
        Texto = P.toString();
        System.out.print(Texto);
    }
}
