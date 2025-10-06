import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        // Variables y clases//
        Scanner in = new Scanner(System.in);
        int VariableA;
        int VariableB;
        int VariableC;

        //Constructor 1(mariano recomienda no usar)//
        Clase1 NameClase1 = new Clase1();

        System.out.print("Ingrese el valor A: ");
        VariableA = in.nextInt();
        NameClase1.setVariableA(VariableA);
        System.out.print("Ingrese el valor B: ");
        VariableB = in.nextInt();
        NameClase1.setVariableB(VariableB);
        System.out.print("Ingrese el valor C: ");
        VariableC = in.nextInt();
        NameClase1.setVariableC(VariableC);
        
        //Constructor 2(mariano recomienda usar este)//
        
        System.out.print("Ingrese el valor A: ");
        VariableA = in.nextInt();
        System.out.print("Ingrese el valor B: ");
        VariableB = in.nextInt();
        System.out.print("Ingrese el valor C: ");
        VariableC = in.nextInt();
        
        Clase1 Name2clase1 = new Clase1(VariableA, VariableB, VariableC);
    }
}