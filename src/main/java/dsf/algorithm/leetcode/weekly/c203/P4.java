package dsf.algorithm.leetcode.weekly.c203;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/24 18:48
 */
public class P4 {

    int[][] dp;
    int n;
    int[] pre;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        if (n < 2) return 0;

        pre = new int[n];
        pre[0] = stoneValue[0];
        for (int i=1; i<n; i++) {
            pre[i] = pre[i-1]+stoneValue[i];
        }

        dp = new int[n][n];
        return recursion(0, n-1);
    }

    public int recursion(int l, int r) {

        if (l > r) return 0;
        if (l < 0 || r >= n) return 0;
        if (l == r) return 0;

        if (dp[l][r] != 0) return dp[l][r];

        int max = 0;
        for (int k=l; k<r; k++) {
            int lv = l==0 ? pre[k] : pre[k] - pre[l-1];
            int rv = pre[r] - pre[k];
            int v = 0;
            if (lv < rv) {
                v += lv + recursion(l, k);
            } else if (lv > rv) {
                v += rv + recursion(k+1, r);
            } else {
                v += lv + Math.max(recursion(l, k), recursion(k+1, r));
            }
            max = Math.max(max, v);
        }

        dp[l][r] = max;
        return max;
    }
}
