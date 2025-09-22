import java.util.Scanner;
public class ejer5
{
    /**
     * Método main
     * 
     */
    public static void main(String[] args)
    {
        //Paso 1: Declarar la variable vector de alturas
        Double [] alturas = new Double[15];
        //Paso 2: Declarar indice y promedio (iniciarlo)
        int i;
        Double a;
        Double promedio;
        Double suma = 0.0;
        int cant = 0;
        int index;
        //Paso 3: Declarar y crear el scanner
        Scanner in = new Scanner(System.in);
        //Paso 4: Crear el vector para 15 valores
            // en el paso 1 :)
        //Paso 5: Ingresar 15 numeros, cargarlos en el vector, ir calculando la suma
        for (i=0; i<15; i++)
        {
            index = i + 1;
            System.out.printf("ingrese al jugador N° " + index + ": ");
            a = in.nextDouble();
            alturas[i] =  a;
            suma = suma + a;
        }
        //Paso 6: Calcular el promedio
        promedio = suma / 15;
        //Paso 7: Recorrer el vector, contar los números que son mayores que el promedio
        for (i=0; i<15; i++)
            {
            if (alturas[i] > promedio)
                cant++;
            }
        System.out.printf("promedio : " + promedio);
        System.out.printf("cantidadde jugadores por encima del promedio : " + cant);
    }
}
