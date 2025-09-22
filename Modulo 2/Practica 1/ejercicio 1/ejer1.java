import java.util.Scanner;
public class ejer1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);      
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        System.out.print("Ingrese a: ");
        a = in.nextDouble(); 
        System.out.print("Ingrese b: ");
        b = in .nextDouble();
        System.out.print("Ingrese c: ");
        c = in.nextDouble();
        if (( a < ( b +c )) && (b<(a+c)) && (c < (a+b)))
            System.out.println((a+b+c));
        in.close();
    }
}