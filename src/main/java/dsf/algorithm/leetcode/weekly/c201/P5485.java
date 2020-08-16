package dsf.algorithm.leetcode.weekly.c201;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/9 11:10
 */
public class P5485 {
    public int maxNonOverlapping(int[] nums, int target) {

        HashMap<Integer, Integer[]> map = new HashMap<>();
        int len = nums.length;
        for (int i=0; i<len; i++) {
            int sum = 0;
            for (int j=i; j<len; j++) {
                sum += nums[j];
                if (sum == target) {
                    map.put(i, new Integer[]{i, j});
                    break;
                }
            }
        }
        int res = 0, lastL = -1, lastR = -1;
        for (int i=0; i<len; i++) {
            Integer[] pos = map.get(i);
            if (pos != null) {
                if (lastL<pos[0] && lastR < pos[1]) {
                    lastL = pos[0];
                    lastR = pos[1];
                    res++;
                }
            }
        }
        return res;
    }
}
