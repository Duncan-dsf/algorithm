package dsf.algorithm.wust;

import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/4/18 10:43
 */
public class P1 {
    public static void main(String[] args) {
        double[] res = new double[1000];

        double flag;
        for (int i=1; i<1000; i++) {
            flag = (i&1) == 1 ? 1 : -1;
            res[i] = flag/i + res[i-1];
        }

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {

            int m = scanner.nextInt();
            int n;
            for (int i=0; i<m; i++) {
                n = scanner.nextInt();
                System.out.printf("%.2f", res[n]);
                if (i < m-1)
                    System.out.println();
            }
        }
    }
}
