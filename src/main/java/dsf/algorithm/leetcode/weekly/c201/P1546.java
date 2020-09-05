package dsf.algorithm.leetcode.weekly.c201;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/9 11:10
 */
public class P1546 {
    public int maxNonOverlapping(int[] nums, int target) {

        int n = nums.length, res = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
        for (int num : nums) {
            sum += num;

            if (set.contains(sum - target)) {
                res++;
                sum = 0;
                set.clear();
                set.add(0);
            } else {
                set.add(sum);
            }
        }
        return res;
    }
}
