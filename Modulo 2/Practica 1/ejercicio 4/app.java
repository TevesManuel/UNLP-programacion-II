public class app {
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }
    public static void main(String [] args) {
        for(int i = 1; i <= 9; i++) {
            //Si quisieramos imprimir SOLO los numeros impares tendriamos que descomentar la siguiente linea
            //if((i % 2) != 0)//Esta linea lo que hace es filtrar solo aquellos i que no sean divisibles por 2, es decir resto != 0
            System.out.println(i + "! = " + factorial(i));
        }
    }
}