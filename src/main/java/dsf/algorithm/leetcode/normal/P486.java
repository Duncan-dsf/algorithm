package dsf.algorithm.leetcode.normal;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/1 7:45
 */
public class P486 {

    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        if (n <= 2) return true;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) dp[i] = nums[i];

        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                dp[j] = Math.max(nums[i]-dp[j], nums[j]-dp[j-1]);
            }
        }
        return dp[n-1] >= 0;
    }

    public boolean PredictTheWinner2(int[] nums) {

        int n = nums.length;
        if (n <= 2) return true;
        int[][] dp = new int[n][n];
        int[] pre = new int[n];
        dp[0][0] = pre[0] = nums[0];
        for (int i=1; i<n; i++) {
            dp[i][i] = nums[i];
            pre[i] = pre[i-1]+nums[i];
        }
        for (int i=0; i<n-1; i++) {
            dp[i][i+1] = Math.max(nums[i], nums[i+1]);
        }
        for (int k=2; k<n; k++) {
            for (int i=0; i+k<n; i++) {
                int sum = i!=0 ? pre[k+i]-pre[i-1] : pre[k+i];
                dp[i][k+i] = sum - Math.min(dp[i+1][i+k], dp[i][i+k-1]);
            }
        }
        return pre[n-1] - dp[0][n-1] <= dp[0][n-1];
    }

    public boolean PredictTheWinner1(int[] nums) {

        int n = nums.length;
        if (n <= 2) return true;
        int[][] before = new int[n][n], after = new int[n][n];
        for (int i=0; i<n; i++) {
            before[i][i] = nums[i];
        }
        for (int i=0; i<n-1; i++) {
            before[i][i+1] = Math.max(nums[i], nums[i+1]);
            after[i][i+1] = Math.min(nums[i], nums[i+1]);
        }

        for (int j=2; j<n; j++) {
            for (int i=0; j+i<n; i++) {
                int a = nums[i]+after[i+1][j+i], b = nums[j+i]+after[i][j+i-1];
                before[i][j+i] = Math.max(a, b);
                after[i][j+i] = Math.min(before[i+1][j+i], before[i][j+i-1]);
            }
        }
        return before[0][n-1] >= after[0][n-1];
    }
}
