
/**
 *
 * @author (Manuel Tomas Teves)
 * 
 */

import java.util.Scanner;

public class app
{
    final static String patenteCorte = "ZZZ000";
    public static void main(String args[]) {
        Flota flota = new Flota();
        String patente = "";
        String destino = "";
        String horaSalida = "";
        Scanner scanner = new Scanner(System.in);
        while(!flota.estaLlena() && !(patente.equals(patenteCorte))) {
            System.out.print("Ingrese la patente: ");
            patente = scanner.nextLine();
            if(!patente.equals(patenteCorte)) {
                System.out.print("Ingrese el destino: ");
                destino    = scanner.nextLine();
                System.out.print("Ingrese la hora de salida: ");
                horaSalida = scanner.nextLine();
                flota.agregarMicro(new Micro(patente, destino, horaSalida));        
            }
        }
        
        System.out.println(flota);
    
        System.out.print("Ingrese la patente a eliminar:");
        patente = scanner.nextLine();
        if(flota.eliminarMicro(patente)) {
            System.out.println("Micro eliminado, flota actualizada:");
            System.out.println(flota);
        } else {
            System.out.println("La patente seleccionada no existe.");
        }
        
        System.out.print("Ingrese el destino que desea buscar:");
        destino = scanner.nextLine();
        Micro m = flota.buscarDestino(destino);
        if(m != null) {
            System.out.println(m);
        } else {
            System.out.println("No se encontraron micros para ese destino");
        }
        
        scanner.close();
    }
}