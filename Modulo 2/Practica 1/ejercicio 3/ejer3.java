import java.util.Scanner;
public class ejer3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);      
        int num;
        int valor = 1;
        int i;
        System.out.print("Ingrese un numero: ");
        num = in.nextInt();
        if (num > 0)
            {
            for (i = num; i>0; i=i-1)
                valor = i * valor;
            }
        System.out.print(num + "! = " + valor);
        in.close();
    }
}
