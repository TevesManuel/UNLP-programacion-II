/**
 * Write a description of class app here.
 *
 * @author ( Manuel Tomas Teves )
 * 
 */

import java.util.Scanner;

public class app
{
    static final int DIMF = 10;
    static final int DIMC = 10;
    
    private static void printMatrix(int [][] m) {   
        for(int i = 0; i < DIMF; i++) {
            for(int j = 0; j < DIMC; j++) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    private static int sumFC(int [][] m, int minF, int maxF, int minC, int maxC) {
        int total = 0;
        for(int i = 0; i < DIMF; i++) {
            for(int j = 0; j < DIMC; j++) {
                if((i >= minF) && (i <= maxF) && (j >= minC) && (j <= maxC)) {
                    total += m[i][j];
                }
            }
        }
        return total;
    }
    private static void find(int [][] m, int n) {
        boolean finded = false;
        for(int i = 0; i < DIMF; i++) {
            for(int j = 0; j < DIMC; j++) {
                if(n == m[i][j]) {
                    System.out.println("Numero encontrado en "+i+","+j);
                    finded = true;
                    break;
                }
                if(finded) {
                    break;
                }
            }
        }
        if(!finded) {
            System.out.println("No se encontro el elemento.");
        }
    }
    private static int sumF(int [][] m, int f) {
        int total = 0;
        for(int j = 0; j < DIMC; j++) {
            total += m[f][j];
        }
        return total;
    }
    public static void main(String args[]) {
        //Declaro la matriz y reservo su memoria
        int [][] m = new int[DIMF][DIMC];
        //Inicializo la matriz
        for(int i = 0; i < DIMF; i++) {
            for(int j = 0; j < DIMC; j++) {
                m[i][j] = (i*10 + j) * 2;
            }
        }

        printMatrix(m);
        
        System.out.println("Sum punto 6)2): " + sumFC(m, 2, 9, 0, 3));
        
        int [] v = new int[10];
        for(int i = 0; i < 10; i++) {
            v[i] = sumF(m, i);
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("v[" + i + "]: " + v[i]);
        }
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        find(m, n);
        
        
    }
}