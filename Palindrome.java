import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Palindrome {
    public static boolean isPalindrome(int palindrome) {
        String palindromeString = String.valueOf(palindrome);
        String invert = new StringBuilder(palindromeString).reverse().toString();;
        return invert.equals(palindromeString);
    }

    public static boolean factor(int numero) {
        int num = 2;
        List<Integer> multiplos = new ArrayList<>();
        while (numero > 1 && numero/2 >= num) {
            if (numero % num == 0) {
                numero /= num;
                //System.out.println("divisible: " + num + ", resto: " + numero);
                multiplos.add(num);
                continue;
            }
            num++;
        }
        multiplos.add(numero);
        Collections.reverse(multiplos);
        int multiplo1 = 1;
        int multiplo2 = 1;
        for (int multiplo : multiplos) {
            if (multiplo1 * multiplo <= 999) {
                multiplo1 *= multiplo;
            } else {
                multiplo2 *= multiplo;
            }
        }
        //System.out.println("multiplo1: " + multiplo1 + ", multiplo2: " + multiplo2);
        if (100 <= multiplo1 && multiplo1 <= 999 && 100 <= multiplo2 && multiplo2 <= 999) {
            return true;
        }
        return false;
    }

    public static boolean factor2(int num) {
        for (int i = 100; i <= 999; i++) {
            //System.out.println("Productos: " + num + " - i: " + i + " - i % num " + (num % i));
            if (num % i == 0) {
                //System.out.println(i + " % " + num + " = " + (i % num));
                int resto = num / i;
                //System.out.println("Productos: " + i + " / " + resto);
                if (100 <= resto && resto <= 999) {
                    return true;
                }
            }
            continue;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            n = 1000000 < n ? 1000000 : n;
            while(101101 <= n) {
                if(isPalindrome(n)) {
                    //System.out.println("Es palindromo: " + n);
                    if(factor2(n)) {
                        System.out.println(n);
                        break;
                    }
                }
                n--;
            }
        }
    }
}
