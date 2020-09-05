package dsf.algorithm.archive.ac.t1;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 移动平均值
 * 最大值和最小值差值
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/18 18:15
 */
public class P1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(5);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt(), k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) arr[i] = scanner.nextInt();
            if (n == k) {
                System.out.println(0);
                continue;
            }

            int max = 0, min = Integer.MAX_VALUE, l = 0, sum = 0;
            for (int i=0; i<k; i++) {
                sum += arr[i];
            }
            max = min = sum;
            for (int i=k; i<n; i++) {
                sum = sum + arr[i] - arr[i-k];
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }

            System.out.println(numberFormat.format(1.0*(max-min)/k));
        }
    }
}
