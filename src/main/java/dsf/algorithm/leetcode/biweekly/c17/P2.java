package dsf.algorithm.leetcode.biweekly.c17;

import java.util.Arrays;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.leetcode.biweekly.c17
 * @Description: TODO
 * @date Date : 2020年01月12日 13:55
 *
 * P5144 矩阵区域和
 */
public class P2 {

    public static void main(String[] args) {
        int[][] ans = matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 1);
        System.out.println(Arrays.toString(ans));
    }

    public static int[][] matrixBlockSum(int[][] mat, int K) {

        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i=1, j; i<=m; i++) {
            for (j=1; j<=n; j++) {
                dp[i][j] = mat[i-1][j-1] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }

        int[][] ans = new int[m][n];
        for (int i=1, j; i<=m; i++) {
            for(j=1; j<=n; j++) {
                int x1 = Math.max(0, i-K), y1 = Math.max(0, j-K), x2 = Math.min(m, i+K), y2 = Math.min(n, j+K);
                int x0 = Math.max(0, x1-1), y0 = Math.max(0, y1-1);
                ans[i-1][j-1] = dp[x2][y2] + dp[x0][y0] - dp[x0][y2] - dp[x2][y0];
            }
        }
        return ans;
    }
}
