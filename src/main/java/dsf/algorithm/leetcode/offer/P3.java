package dsf.algorithm.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 16:27
 */
public class P3 {

    public int findRepeatNumber(int[] nums) {

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == i) continue;
            if (nums[i] == nums[nums[i]])
                return nums[i];
            else {
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>((int)(n*3.0/4+1));
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return 0;
    }
}
