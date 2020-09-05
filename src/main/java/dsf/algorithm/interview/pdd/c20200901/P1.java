package dsf.algorithm.interview.pdd.c20200901;

import java.util.Scanner;

/**
 * AC
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/1 18:54
 */
public class P1 {

    static int n;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
//            int[][] arr = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
//                    arr[i][j] = get(i, j);
                    System.out.print(get(i, j));
                    if (j < n-1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static int get(int i, int j) {
        if (i == j || i+j == n-1)
            return 0;
        if (n%2 == 1 && (i == n/2 || j == n/2))
            return 0;

        if (i<n/2 && j>=n/2) {
            if (i+j<n-1)
                return 1;
            else
                return 8;
        }
        if (i<n/2 && j<n/2) {
            if (i<j)
                return 2;
            else
                return 3;
        }
        if (i>=n/2 && j<n/2) {
            if (i+j < n-1)
                return 4;
            else
                return 5;
        }
        if (i<j) return 7;
        return 6;
    }
}
