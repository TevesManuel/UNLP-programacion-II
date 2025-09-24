import java.util.Scanner;
public class ejer5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String vector [] = new String[10];
        int i;
        String respuesta = " ";
        
        System.out.print("ingrese una frase: ");
        for (i = 0; (i < 10); i++)
             vector[i] = in.next();
        for (i = 0; (i < 10); i++)
            respuesta = respuesta + vector[i].charAt(0);
        System.out.print(respuesta);
    }
}