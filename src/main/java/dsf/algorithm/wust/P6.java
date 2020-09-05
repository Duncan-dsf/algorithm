package dsf.algorithm.wust;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/4/18 12:04
 */
public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int res, i;
            res = scanner.nextInt();
            for (i=1; i<n; i++) {

                int t = scanner.nextInt();
                res *= (t/getInt(res, t));
            }
            System.out.println(res);
        }
    }

    public static int getInt(int a, int b) {

        if (a%b == 0)
            return b;
        else
            return getInt(b, a%b);
    }
}
