import java.util.Scanner;

public class app {
    public static void main( String [] args ) {
        int patente;
        int total = 0;
        int pueden = 0;
        Scanner in = new Scanner(System.in);
        patente = in.nextInt();     
        while( patente != 0 ) {
            if( patente % 2 == 0 ) {
                System.out.println("El auto puede pasar.");
                pueden++;
            } else {
                System.out.println("El auto NO puede pasar.");            
            }
            total++;
            patente = in.nextInt();
        }
        System.out.println("Total: " + total);
        System.out.println("Pueden: " + pueden);
        System.out.println("Porcentaje: " + (((double)pueden/(double)total)*(double)100) + "%");
    }
}