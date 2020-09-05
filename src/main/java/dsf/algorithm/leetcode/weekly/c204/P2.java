package dsf.algorithm.leetcode.weekly.c204;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 10:55
 */
public class P2 {

    public int getMaxLen(int[] nums) {

        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp1 = new int[n], dp2 = new int[n];
        int max = 0;
        if (nums[0] > 0) {
            dp1[0] = 1;
            max = 1;
        } else if (nums[0] < 0)
            dp2[0] = 1;

        for (int i=1; i<n; i++) {
            if (nums[i] > 0) {
                dp1[i] = dp1[i-1]+1;
                dp2[i] = dp2[i-1]>0 ? dp2[i-1]+1 : 0;
            } else if (nums[i] < 0) {
                dp1[i] = dp2[i-1]>0 ? dp2[i-1]+1 : 0;
                dp2[i] = dp1[i-1]+1;
            } else {
                dp1[i] = dp2[i] = 0;
            }
            max = Math.max(max, dp1[i]);
        }
        return max;
    }
}
