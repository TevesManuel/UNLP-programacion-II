
/**
 * Write a description of class app here.
 *
 * @author (Manuel Tomas Teves)
 *
 */

import java.util.Scanner;

public class app
{
    final static int DIMF = 3;
    public static void main(String [] args) {
        Jugador [] jugadores = new Jugador[DIMF];
        String nombre;
        int dni, edad, ga, pj;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < DIMF; i++) {
            System.out.print("Ingresar el nombre del jugador: ");
            nombre = scanner.nextLine();
            System.out.print("Ingresar el dni: ");
            dni = scanner.nextInt();
            System.out.print("Ingresar la edad: ");
            edad = scanner.nextInt();
            System.out.print("Ingresar cantidad de goles anotados: ");
            ga = scanner.nextInt();
            System.out.print("Ingresar cantidad de partidos jugados: ");
            pj = scanner.nextInt();
            jugadores[i] = new Jugador(nombre, dni, edad, pj, ga);
            scanner.nextLine();
        }
        scanner.close();
        
        int total = 0;
        
        for(int i = 0; i < DIMF; i++) {
            if(jugadores[i].getPartidosJugados() >= 100) {
                total++;
            }
        }
        
        System.out.println("En total " + total + " jugadores jugaron mas de 100 partidos.");
    }
}