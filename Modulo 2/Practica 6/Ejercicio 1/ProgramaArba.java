import java.util.Scanner;
public class ProgramaArba
{
    public static void main(String[] args)
    {
        // Variables y clases//
        Scanner in = new Scanner(System.in);
        int opcion;
        int año;
        double importe;
        int cit;
        String nombre;
        String apellido;
        String p;
        double ip;
        String d;
        String r;
        String t;
        int e;
        int peso;
        int v;
        
        int lim = 2;
        Vehiculo registro[] = new Vehiculo[lim];
        
        for (int i=0; i<lim; i++){
            System.out.println("Ingrese un numero  correspondiente a alguna de las opciones");
            System.out.println("1. ingresar automotor ");
            System.out.println("2. ingresar embarcacion ");
            System.out.println("opcion: ");
            opcion = in.nextInt();
            
            switch (opcion){
                case 1: 
                    System.out.print("Ingresar año: ");
                    año = in.nextInt();
                    
                    System.out.print("Ingresar importe: ");
                    importe = in.nextDouble();
                    
                    System.out.print("Ingresar cit: ");
                    cit = in.nextInt();
                    
                    in.nextLine(); // limpiar buffer
                    
                    System.out.print("Ingresar nombre del propietario: ");
                    nombre = in.nextLine();
                    
                    System.out.print("Ingresar apellido del propietario: ");
                    apellido = in.nextLine();
                    
                    System.out.print("Ingresar patente: ");
                    p = in.nextLine();
                    
                    System.out.print("Ingresar importe adicional: ");
                    ip = in.nextDouble();
                    
                    in.nextLine(); // limpiar buffer
                    
                    System.out.print("Ingresar descripción: ");
                    d = in.nextLine();
                    
                    Vehiculo auto = new Automotor(año, importe, cit, nombre, apellido, p, ip, d);
                    System.out.println("Automotor cargado correctamente.");
                    
                    break;
                case 2: 
                        System.out.print("Ingresar año: ");
                    año = in.nextInt();
            
                    System.out.print("Ingresar importe adicional: ");
                    importe = in.nextDouble();
            
                    System.out.print("Ingresar cit: ");
                    cit = in.nextInt();
            
                    in.nextLine(); // limpiar buffer
            
                    System.out.print("Ingresar nombre del propietario: ");
                    nombre = in.nextLine();
            
                    System.out.print("Ingresar apellido del propietario: ");
                    apellido = in.nextLine();
            
                    System.out.print("Ingresar REY: ");
                    r = in.nextLine();
            
                    System.out.print("Ingresar tipo de embarcacion: ");
                    t = in.nextLine();
            
                    System.out.print("Ingresar eslora: ");
                    e = in.nextInt();
            
                    System.out.print("Ingresar peso: ");
                    peso = in.nextInt();
            
                    System.out.print("Ingresar valor: ");
                    v = in.nextInt();
                    
                    Vehiculo barco = new Embarcacion(año, importe, cit, nombre, apellido, r, t, e, peso, v);
            
                    System.out.println("Embarcacion cargada correctamente.");
            }
        }
        in.close();
    }
}