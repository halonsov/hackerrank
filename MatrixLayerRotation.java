import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.ThreadLocalRandom;

public class MatrixLayerRotation  {

    static int[][] matrixRotation(int[][] matrix) {
        // Complete this function
        int[][] response = new int[matrix.length][matrix[0].length];
	    int inicio_i = 0;
        int inicio_j = 0;
        int fin_i  = matrix.length - 1;
        int fin_j  = matrix[0].length - 1;
        while (inicio_i <= matrix[0].length/2) {
            for(int i = inicio_i; i <= fin_i; i++) {
                for(int j = inicio_j; j <= fin_j; j++) {
                    if(i == inicio_i && j == fin_j) {
                        response[i][fin_j] = matrix[i + 1][fin_j];
                        continue;
                    } else if (i == inicio_i) {
                        response[i][j] = matrix[i][j + 1];
                        continue;
                    } else if (i == fin_i && j == inicio_j) {
                        response[i][j] = matrix[i - 1][j];
                        continue;
                    } else if (i == fin_i) {
                        response[i][j] = matrix[i][j - 1];
                        continue;
                    } else {
                        response[i][inicio_j] = matrix[i - 1][inicio_j];
                        response[i][fin_j] = matrix[i + 1][fin_j];
                        break;
                    }
                }
            }
            inicio_i++;
            inicio_j++;
            fin_i--;
            fin_j--;
        }
        return response;
    }

    static void matrixRotation(int[][] matrix, int rotation) {
        System.out.println();System.out.println();System.out.println();
        for (int i = 0; i < rotation; i++) {
            matrix = matrixRotation(matrix);
        }
        printMatrix(matrix);
    }

    static void printMatrix(int[][] response) {
        for (int i = 0; i < response.length; i++) {
            for (int j = 0; j < response[i].length; j++) {
                System.out.print(response[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] matrixRotation_1(int[][] matrix, int rotation) {
        int[][] response = matrix;
	    int inicio_i = 0;
        int inicio_j = 0;
        int fin_i  = matrix.length - 1;
        int fin_j  = matrix[0].length - 1;
        int perimetro = (fin_i + fin_j) * 2;
        while (inicio_i <= perimetro) {
            System.out.println("Iteraciones: " + perimetro);
            System.out.println("inicio_i: " + inicio_i);
            System.out.println("inicio_j: " + inicio_j);
            System.out.println("fin_i: " + fin_i);
            System.out.println("fin_j: " + fin_j);
            int i = inicio_i;
            int j = inicio_j;
            for(int perimetro_elemento = 0; perimetro_elemento < perimetro; perimetro_elemento++) {
                if (perimetro_elemento <= fin_j) {
                    j = perimetro_elemento + inicio_j;
                    i = inicio_i;
                    System.out.println("Iteracion-1: " + perimetro_elemento + " - [i, j]: [" + i + ", " + j + "]");
                    response[i][j] = getElement(matrix, rotation + perimetro_elemento, inicio_i, inicio_j, fin_i, fin_j);
                } else if (perimetro_elemento <= fin_i + fin_j) {
                    j = fin_j;
                    i++;
                    System.out.println("Iteracion-2: " + perimetro_elemento + " - [i, j]: [" + i + ", " + j + "]");
                    response[i][j] = getElement(matrix, rotation + perimetro_elemento, inicio_i, inicio_j, fin_i, fin_j);
                } else if (perimetro_elemento <= fin_i + 2 * fin_j) {
                    i = fin_i;
                    j = fin_j - (perimetro_elemento - (fin_i + fin_j));
                    System.out.println("Iteracion-3: " + perimetro_elemento + " - [i, j]: [" + i + ", " + j + "]");
                    response[i][j] = getElement(matrix, rotation + perimetro_elemento, inicio_i, inicio_j, fin_i, fin_j);
                } else if (perimetro_elemento < 2 * fin_j + 2 * fin_i) {
                    i = fin_i - (perimetro_elemento - (2 * fin_j + fin_i));
                    j = inicio_j;
                    System.out.println("Iteracion-4: " + perimetro_elemento + " - [i, j]: [" + i + ", " + j + "]");
                    response[i][j] = getElement(matrix, rotation + perimetro_elemento, inicio_i, inicio_j, fin_i, fin_j);
                }
            }
            System.out.println();System.out.println();System.out.println();
            printMatrix(response);
            System.out.println();System.out.println();System.out.println();
            inicio_i++;
            inicio_j++;
            fin_i -= 2;
            fin_j -= 2;
            perimetro = (fin_i + fin_j) * 2;
            System.out.println("Iteraciones: " + perimetro);
            System.out.println("inicio_i: " + inicio_i);
            System.out.println("inicio_j: " + inicio_j);
            System.out.println("fin_i: " + fin_i);
            System.out.println("fin_j: " + fin_j);
        }
        return response;
    }

    static int getElement(int[][] matrix, int element, int inicio_i, int inicio_j, int fin_i, int fin_j) {
        element = element % ((fin_i + fin_j) * 2);
        int matrix_i = inicio_i;
        int matrix_j = inicio_j;
        if (fin_j < element) {
            matrix_j = fin_j;
            element -= matrix_j;
        } else {
            return matrix[matrix_i][element];
        }
        if (fin_i < element) {
            matrix_i = fin_i;
            element -= matrix_i;
        } else {
            return matrix[element][matrix_j];
        }
        if (fin_j < element) {
            matrix_j = inicio_j;
            element -= fin_j;
        } else {
            matrix_j = fin_j - element;
            return matrix[matrix_i][matrix_j];
        }
        matrix_i = fin_i - element;
        return matrix[matrix_i][matrix_j];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                //matrix[matrix_i][matrix_j] = in.nextInt();
                matrix[matrix_i][matrix_j] =  ThreadLocalRandom.current().nextInt(0, 1000000 + 1);
            }
        }
        System.out.println();System.out.println();System.out.println();
        printMatrix(matrix);
        System.out.println();System.out.println();System.out.println();
        matrixRotation(matrix, r);
        System.out.println();System.out.println();System.out.println();
        printMatrix(matrixRotation_1(matrix, r));
        //matrixRotation(matrix, (r % ((matrix.length + matrix[0].length) * 2 - 4)));
        in.close();
    }
}
