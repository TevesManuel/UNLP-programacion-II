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
        
        System.out.println("ingresar el VariableD correspondiente al surtidor requerido: ");
        System.out.println("1. ClasePadre de Gasoil");
        System.out.println("2. ClasePadre de Nafta");
        System.out.println("Ingresar opcion: ");
        opcion = in.nextInt();
        
        switch (opcion)
        {
            case 1:
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
                
                ClaseHijo1 surtidor1 = new ClaseHijo1(VariableA, VariableB, VariableC, VariableD, VariableE, VariableF, VariableG);
        
                System.out.println("ClasePadre cargado correctamente.");
                System.out.println(surtidor1.toString());
                
                break;
                
            case 2:
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
        
                System.out.print("Ingresar VariableH: ");
                VariableH = in.nextInt();
        
                ClaseHijo2 surtidor2 = new ClaseHijo2(VariableA, VariableB, VariableC, VariableD, VariableE, VariableH);
        
                System.out.println("ClaseHijo2 cargado correctamente.");
                System.out.println(surtidor2.toString());
                
                break;
        }
        in.close();
    }
}