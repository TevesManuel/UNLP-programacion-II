import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        // Variables y clases//
        Scanner in = new Scanner(System.in);
        int dni;
        String nombre;
        String apellido;
        int numero;
        int importe;
        int cliente;
        int clienteMax;
        int litros;
        int opcion;
        int importeFinal;
        
        System.out.println("ingresar el numero correspondiente al surtidor requerido: ");
        System.out.println("1. Surtidor de Gasoil");
        System.out.println("2. Surtidor de Nafta");
        System.out.println("Ingresar opcion: ");
        opcion = in.nextInt();
        
        switch (opcion)
        {
            case 1:
                System.out.print("Ingresar DNI: ");
                dni = in.nextInt();
                in.nextLine(); // limpiar buffer
        
                System.out.print("Ingresar nombre: ");
                nombre = in.nextLine();
        
                System.out.print("Ingresar apellido: ");
                apellido = in.nextLine();
        
                System.out.print("Ingresar número de surtidor: ");
                numero = in.nextInt();
        
                System.out.print("Ingresar importe: ");
                importe = in.nextInt();
        
                System.out.print("Ingresar número de cliente: ");
                cliente = in.nextInt();
        
                System.out.print("Ingresar cliente máximo: ");
                clienteMax = in.nextInt();
                
                SurtidorGas surtidorGas = new SurtidorGas(dni, nombre, apellido, numero, importe, cliente, clienteMax);
        
                System.out.println("Surtidor cargado correctamente.");
                System.out.println(surtidorGas.toString());
                
                break;
                
            case 2:
                System.out.print("Ingresar DNI: ");
                dni = in.nextInt();
                in.nextLine(); // limpiar buffer
        
                System.out.print("Ingresar nombre: ");
                nombre = in.nextLine();
        
                System.out.print("Ingresar apellido: ");
                apellido = in.nextLine();
        
                System.out.print("Ingresar número de surtidor: ");
                numero = in.nextInt();
        
                System.out.print("Ingresar importe: ");
                importe = in.nextInt();
        
                System.out.print("Ingresar litros: ");
                litros = in.nextInt();
        
                SurtidorNafta surtidorNafta = new SurtidorNafta(dni, nombre, apellido, numero, importe, litros);
        
                System.out.println("SurtidorNafta cargado correctamente.");
                System.out.println(surtidorNafta.toString());
                
                break;
        }
        in.close();
    }
}