import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        // Variables y clases//
        Scanner in = new Scanner(System.in);
        int Va;
        int Vb;
        int Vc;

        //Constructor 1(mariano recomienda no usar)//
        Clase1 NameClase1 = new Clase1();

        System.out.print("Ingrese el valor A: ");
        Va = in.nextInt();
        NameClase1.setMetodoA(Va);
        System.out.print("Ingrese el valor B: ");
        Vb = in.nextInt();
        NameClase1.setMetodoB(Vb);
        System.out.print("Ingrese el valor C: ");
        Vc = in.nextInt();
        NameClase1.setMetodoC(Vc);
        
        //Constructor 2(mariano recomienda usar este)//
        
        System.out.print("Ingrese el valor A: ");
        Va = in.nextInt();
        System.out.print("Ingrese el valor B: ");
        Vb = in.nextInt();
        System.out.print("Ingrese el valor C: ");
        Vc = in.nextInt();
        
        Clase1 Name2clase1 = new Clase1(Va, Vb, Vc);
    }
}