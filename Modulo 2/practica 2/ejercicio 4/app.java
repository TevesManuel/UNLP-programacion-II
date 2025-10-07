import java.util.Scanner;

/**
 * Write a description of class app here.
 *
 * @author (your name)
 * 
 */
public class app
{
    final static int DIMF = 325;//325//Puedes probar el programa reduciendo este numero a uno mas bajo como por ej 3 o 5.
    static Partido [] partidos;
    private static void cargarPartidos() {
        String l, v;
        int gl, gv;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < DIMF; i++) {
            System.out.print("Ingrese el nombre del equipo local: ");
            l = scanner.nextLine();
            System.out.print("Ingrese el nombre del equipo visitante: ");
            v= scanner.nextLine();
            System.out.print("Ingrese los goles de el equipo local: ");
            gl = scanner.nextInt();
            System.out.print("Ingrese los goles de el equipo visitante: ");
            gv = scanner.nextInt();
            scanner.nextLine();//Limpia el \n del buffer
        }
        scanner.close();
    }
    public static int howMuchGamesWin(String team) {
        int total = 0;
        for(int i = 0; i < DIMF; i++) {
            if(partidos[i].hayGanador() && (partidos[i].getGanador() == team)) {
                total++;
            }
        }
        return total;
    }
    public static int howMuchGamesWinLocal(String team) {
        int total = 0;
        for(int i = 0; i < DIMF; i++) {
            if(partidos[i].hayGanador() && (partidos[i].getLocal() == team) && (partidos[i].getGanador() == team)) {
                total++;
            }
        }
        return total;
    }
    public static double percentajeTie() {
        int total = 0;
        for(int i = 0; i < DIMF; i++) {
            if(partidos[i].hayEmpate()) {
                total++;
            }
        }
        return (((double)total/(double)DIMF)*100.0);
    }
    public static void main(String [] args) {
        cargarPartidos();
        System.out.println("River gano " + howMuchGamesWin("River") + " partidos.");
        System.out.println("River gano " + howMuchGamesWin("Boca") + " partidos de local.");
        System.out.println("Porcentaje de empates: " + percentajeTie());
    }
}