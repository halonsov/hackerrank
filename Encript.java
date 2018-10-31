import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encript {
    /**
     * Imprime matriz.
     *
     * @param matrix
     */
    static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //\t es tabulador
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    static String printEncryption(char[][] matrix) {
        String ret = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //\t es tabulador
                if (matrix[i][j] <= ' ') {
                    continue;
                }
                ret += matrix[i][j];
            }
            ret += " ";
        }
        return ret;
    }

    static String encryption(String s) {
        s = s.replaceAll("\\s+","");
        int size = s.length();
        //System.out.println("size: " + size);
        int ceil = (int) Math.ceil(Math.sqrt(size));
        int floor = (int) Math.floor(Math.sqrt(size));
        //System.out.println("ceil*floor: " + (ceil*floor));
        if (size > ceil*floor) {
            floor = ceil;
        }
        //System.out.println("ceil: " + ceil);
        //System.out.println("floor: " + floor);
        char[][] matriz = new char[ceil][floor];
        int i = 0;
        int j = 0;
        String ret = "";
        for (char a : s.toCharArray()) {
            if (j >= ceil) {
                j = 0;
                i++;
            }
            //System.out.println("matriz[" + i + "][" + j + "]");
            matriz[j][i] = a;
            ret += a;
            j++;
        }
        //printMatrix(matriz);
        return printEncryption(matriz);
    }
    
    public static void main(String[] args) throws IOException {
        String s = "Ah nu ma es mi frase";
        String result = encryption(s);
        System.out.println(result);
    }
}