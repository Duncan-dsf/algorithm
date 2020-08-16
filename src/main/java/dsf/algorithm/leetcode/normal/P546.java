package dsf.algorithm.leetcode.normal;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/15 10:48
 */
public class P546 {
    int[][][] dp;
    int n;
    int[] boxes;

    public int removeBoxes(int[] boxes) {

        n = boxes.length;
        dp = new int[n][n][n];
        this.boxes = boxes;

        return recursion(0, n-1, 0);
    }

    public int recursion(int l, int r, int k) {

        if (r < 0 || l > r) return 0;
        if (dp[l][r][k] != 0)
            return dp[l][r][k];

        int res1 = recursion(l, r-1, 0) + (k+1)*(k+1);

        int max = 0;
        for (int i=l; i<r; i++) {
            if (boxes[i] == boxes[r]) {
                max = Math.max(max, recursion(l, i, k+1) + recursion(i+1, r-1, 0));
            }
        }
        dp[l][r][k] = Math.max(max, res1);

        return dp[l][r][k];
    }


    public static void main(String[] args) {

        int res = new P546().removeBoxes(new int[]{1,3,2,2,2,3,4,3,1});
        System.out.println(res);
    }
}
