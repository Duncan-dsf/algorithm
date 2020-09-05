package dsf.algorithm.wust;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/4/18 11:55
 */
public class P5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            int n = scanner.nextInt();
            int i, sum, max, min;
            for (i=0, sum=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE; i<n; i++) {
                int a = scanner.nextInt();
                sum += a;
                max = Math.max(a, max);
                min = Math.min(a, min);
            }
            System.out.printf("%.2f\n", 1.0*(sum-max-min)/(n-2));
        }
    }
}
