import java.util.Scanner;
public class prueba
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        triangulo Triangulo = new triangulo();
        double a;
        double b;
        double c;
        double Area;
        double Perimetro;
        String L;
        String R;
        
        System.out.print("Ingrese el valor A: ");
        a = in.nextDouble();
        Triangulo.setLadoA(a);
        System.out.print("Ingrese el valor B: ");
        b = in.nextDouble();
        Triangulo.setLadoB(b);
        do
        {
            System.out.print("Ingrese el valor C: ");
            c = in.nextDouble();
            Triangulo.setLadoC(c);
        } while (Triangulo.EsTriangulo() != true);
        System.out.print("Ingrese el color de las lineas: ");
        L = in.next();
        Triangulo.setColorLinea(L);
        System.out.print("Ingrese el color de las lineas: ");
        R = in.next();
        Triangulo.setColorLinea(R);
        
        triangulo triangulito = new triangulo(a,b,c,R,L);
        
        Area = Triangulo.calcularArea();
        Perimetro = Triangulo.calcularPerimetro();
        System.out.print("El area es: " + Area);
        System.out.print("El perimetro es: " + Perimetro);
    }
}