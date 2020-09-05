package dsf.algorithm.leetcode.biweekly.c33;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 23:23
 */
public class P3 {

    public int minOperations(int[] nums) {

        int res = 0;
        for (int num : nums)
            res += getCount(num);
        return res;
    }

    public int getCount(int n) {

        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                res++;
            if (n == 1) break;
            n >>= 1;
            res++;
        }
        return res;
    }
}
