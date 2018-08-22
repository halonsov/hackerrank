import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Find the greatest product of K consecutive digits in the N digit number.
 */

class LargestProductInASeries {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); //input
        int t = in.nextInt(); // t = 2

        for(int a0 = 0; a0 < t; a0++){ //iteraciones sobre el número de casos de prueba
            int n = in.nextInt(); // n = 10
            int k = in.nextInt(); // k = 5
            String num = in.next(); // a0 = 0: 375356291 , a0 = 1: 2709360626

            int largestProduct = 0; //inicializar la variable que guarda el maximo producto


            for (int i = 0; i <= n - k; i++){ //iteraciones sobre el tamaño en númer de dígitos del número (n)
                int product = 1; //inicializacion de la variable temporal que guarda el producto de los digitos de la serie
                for (int j = i; j < i + k; j++){ //iteraciones sobre el tamaño de la serie (k)
                    product *= Character.getNumericValue(num.charAt(j));// * Character.getNumericValue(num.charAt(k));
                }
                if (product > largestProduct) largestProduct = product; //validacion del producto más grande con respecto al anterior
            }
            System.out.println(largestProduct);
        }
    }
}Eul
