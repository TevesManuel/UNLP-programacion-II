
/**
 * Write a description of class app here.
 *
 * @author (Manuel Tomas Teves)
 *
 */

import java.util.Scanner;

public class app
{
    public static void main(String args[]) {
        Balance balance = new Balance();
        balance.iniciarCompra();
        double price, weight = 1.0;
        Scanner scanner = new Scanner(System.in);
        while(weight != 0) {
            System.out.print("Ingresa el peso: ");
            weight = scanner.nextDouble();
            if (weight != 0) {
                System.out.print("Ingresa el precio por kilo: ");
                price = scanner.nextDouble();
                balance.registrarProducto(weight, price);
            }
        }
        scanner.close();
        System.out.println(balance.devolverResumenDeCompra());
    }
}