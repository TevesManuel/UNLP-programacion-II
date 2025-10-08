import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        // Variables y clases//
        Scanner in = new Scanner(System.in);
        int VariableA;
        String VariableB;
        String VariableC;
        int VariableD;
        int VariableE;
        int VariableF;
        int VariableG;
        int VariableH;
        int opcion;
        
       System.out.print("Ingresar Variable A:");
        VariableA = in.nextInt();
        in.nextLine(); // limpiar buffer

        System.out.print("Ingresar VariableB: ");
        VariableB = in.nextLine();

        System.out.print("Ingresar VariableC: ");
        VariableC = in.nextLine();

        System.out.print("Ingresar número de surtidor: ");
        VariableD = in.nextInt();

        System.out.print("Ingresar VariableE: ");
        VariableE = in.nextInt();

        System.out.print("Ingresar número de VariableF: ");
        VariableF = in.nextInt();

        System.out.print("Ingresar VariableF máximo: ");
        VariableG = in.nextInt();
        
        ClaseHijo1 nameClase1 = new ClaseHijo1(VariableA, VariableB, VariableC, VariableD, VariableE, VariableF, VariableG);

        System.out.println("ClasePadre cargado correctamente.");
        System.out.println(nameClase1.toString());
        
        in.close();
    }
}