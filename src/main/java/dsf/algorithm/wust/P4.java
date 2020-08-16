package dsf.algorithm.wust;

import java.util.Scanner;

/**
 * AC
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/4/18 11:30
 */
public class P4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int i, sum, k;
            for (i=1, sum=0, k=0; i<=n; i++) {
                k++;
                sum += i*2;
                if (k == m) {
                    System.out.print(sum/m);
                    if (i != n)
                        System.out.print(" ");
                    sum = 0;
                    k = 0;
                }
            }
            if (sum > 0)
                System.out.print(sum/k);
            System.out.println();
        }
    }
}
