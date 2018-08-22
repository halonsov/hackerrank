import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class PlusMinus {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr, int n) {
        float plus = 0;
        float minus = 0;
        float zero = 0;
        for (int a : arr) {
            if (0 < a) {
                plus++;
            } else if (a < 0) {
                minus++;
            } else {
                zero++;
            }
        }
        NumberFormat formatter = new DecimalFormat("#0.000000");
       // Print the number using scientific number format and using our
       // defined decimal format pattern above.
        System.out.println(formatter.format(plus/n));
        System.out.println(formatter.format(minus/n));
        System.out.println(formatter.format(zero/n));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr, n);
    }
}
