package dsf.algorithm.leetcode.weekly.c201;

import java.util.Arrays;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/9 11:44
 */
public class P1547 {
    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);
        int m = cuts.length;
        int[] arr = new int[m+2];
        System.arraycopy(cuts, 0, arr, 1, m);
        arr[0] = 0;
        arr[m+1] = n;
        int[][] dp = new int[m+2][m+2];

        for (int i=m-1; i>-1; i--) {
            for (int j=i+2; j<m+2; j++) {
                int min = Integer.MAX_VALUE;
                for (int k=i+1; k<j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k][j]);
                }
                dp[i][j] = min + arr[j] - arr[i];
            }
        }
        return dp[0][m+1];
    }

    public static void main(String[] args) {

        System.out.println(new P1547().minCost(7, new int[]{1, 3, 4, 5}));
    }

}
