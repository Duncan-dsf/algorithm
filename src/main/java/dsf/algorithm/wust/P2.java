package dsf.algorithm.wust;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/4/18 11:14
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if (n <= 0) return;
            for (int i=0; i<n; i++) {
                double a = scanner.nextDouble(), b = scanner.nextDouble();
                if (Math.abs(a - b) < 0.00001)
                    System.out.printf("CASE# %d : YES\n", i+1);
                else System.out.printf("CASE# %d : No\n", i+1);
            }
            System.out.println();
        }
    }
}
