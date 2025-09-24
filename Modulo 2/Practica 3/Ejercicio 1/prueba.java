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
        
        Area = Triangulo.calcularArea();
        Perimetro = Triangulo.calcularPerimetro();
        System.out.print("El area es: " + Area);
        System.out.print("El perimetro es: " + Perimetro);
    }
}