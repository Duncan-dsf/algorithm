package dsf.algorithm.interview.jd.b20200827;

import java.util.Scanner;

/**
 * AC 中下
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/27 19:41
 */
public class P2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][2*n-1];
            for (int i=0; i<n; i++) {
                for (int j=n-1-i; j<=n-1+i; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int[][] dp = new int[n][2*n-1];
            for (int i=0; i<2*n-1; i++) {
                dp[n-1][i] = arr[n-1][i];
            }

            for (int i=n-2; i>=0; i--) {
                for (int j=n-1-i; j<=n-1+i; j++) {
                    dp[i][j] = Math.max(Math.max(dp[i+1][j-1], dp[i+1][j]), dp[i+1][j+1]) + arr[i][j];
                }
            }
            System.out.println(dp[0][n-1]);
        }
    }
}
