
/**
 * Write a description of class app here.
 *
 * @author (Manuel Tomas Teves)
 *
 */

import java.util.Scanner;

public class app
{
    final static int DIMF = 15;
    
    private static void register(Persona [] p) {
        String n;
        int dni, edad;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < DIMF; i++) {
            System.out.print("Ingrese nombre: ");
            n = in.nextLine();
            System.out.print("Ingrese dni: ");
            dni = in.nextInt();
            System.out.print("Ingrese edad: ");
            edad = in.nextInt();
            p[i] = new Persona(n, dni, edad);
            in.nextLine();//Limpio el \n que deja en el buffer in.nextInt()
        }        
    }
    
    private static int olderThan(Persona [] p, int max) {
        int total = 0;
        for(int i = 0; i < DIMF; i++) {
            if(p[i].getEdad() > 65) {
                total += 1;
                System.out.println(p[i]); // Como esta definido el metodo toString se puede imprimir directamente
            }
        }
        return total;
    }
    
    private static Persona min(Persona [] p) {
        Persona m = new Persona("null", 0, 0);
        for(int i = 0; i < DIMF; i++) {
            if(p[i].getDNI() < m.getDNI()) {
                m = p[i];
            }
        }
        return m;
    }
    
    public static void main(String args[]) {
        Persona []p = new Persona[DIMF];
        register(p);
        System.out.println("Personas mayores a : " + olderThan(p, 65));
        System.out.println("Persona con menor DNI");
        System.out.println(min(p));
    }
}