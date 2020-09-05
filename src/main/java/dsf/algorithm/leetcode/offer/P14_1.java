package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/21 8:50
 */
public class P14_1 {


    public int cuttingRope1(int n) {

        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i=5; i<=n; i++) {
            int max = 0;
            for (int j=2; j<=n/2; j++) {
                max = Math.max(max, dp[j]*dp[i-j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
